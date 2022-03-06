//WARNING: O caminho de dados utilizado é nativo à máquina em que foi escrito este programa. 
//-------- Para usar o programa localmente, substitua a URL nativa pela local, onde o programa for instalado.

package br.com.JoaoPCarv.Java2022a.beans;

import java.lang.String;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.Java2022a.DAOs.ClienteDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Cliente {

	private String nome;
	private int idade;
	private int ID;
	private String job;

	private void setNome(String nome) {

		this.nome = nome;

	};

	private void setIdade(int idade) {

		this.idade = idade;

	};

	private void setID(int ID) {

		this.ID = ID;

	};

	private void setJob(String job) {

		this.job = job;

	};

	public String getNome() {

		return this.nome;

	};

	public int getIdade() {

		return this.idade;

	};

	public int getID() {

		return this.ID;

	};

	public String getJob() {

		return this.job;

	};

	@Deprecated
	public void displayCliente() {

		if (!this.checkCliente()) {

			System.out.println("O objeto aponta para um cliente que não existe.");
			return;

		}
		;

		System.out.println("-------------------------------------");
		System.out.println(this.getNome());
		System.out.println(this.getIdade());
		System.out.println(this.getID());
		System.out.println(this.getJob());
		System.out.println("-------------------------------------");
		System.out.println(" ");

	};

	public void recordCliente() {

		if (!this.checkCliente()) {

			JOptionPane.showMessageDialog(null,
					"O objeto aponta para um cliente que não existe. Não é possível gravá-lo.");
			return;

		}
		;

		String pathID = Integer.toString(this.getID());

		String path = "C:\\Users\\Administrador.000\\eclipse\\Java2022a\\src\\Clientes\\" + pathID + ".txt";

		try {

			File arquivo = new File(path);

			if (!arquivo.exists()) {

				arquivo.createNewFile();

			} else {

				Object[] options = { "Yes", "No" };

				int option = JOptionPane.showOptionDialog(null, "O arquivo será sobrescrito. Deseja confirmar?",
						"Escolha uma opção", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
						"Yes");

				if (option == 0) {

					arquivo.delete();
					arquivo.createNewFile();
					System.out.println("O arquivo foi sobrescrito.");

				} else {
					System.out.println("O arquivo não será sobrescrito. Operação cancelada.");
					return;
				}
				;
			}
			;

			FileWriter fw = new FileWriter(arquivo);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(this.getNome() + "\n");
			bw.write(this.getIdade() + "\n");
			bw.write(this.getID() + "\n");
			bw.write(this.getJob());

			bw.close();
			fw.close();

			ClienteDAO clDAO = new ClienteDAO();
			boolean x = clDAO.insert(this);
			String message = "";

			if (x) {
				message = "O cliente foi inserido no banco de dados.";
			} else {
				message = "O cliente não foi inserido no banco de dados. Falha no processo.";
			}

			JOptionPane.showMessageDialog(null, "Cadastro realizado. " + message);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		;

	};

	public static boolean browseCliente(int ID) {

		boolean existe = false;
		String pathID = Integer.toString(ID);
		String path = "C:\\Users\\Administrador.000\\eclipse\\Java2022a\\src\\Clientes\\" + pathID + ".txt";

		try {

			File arquivo = new File(path);

			if (arquivo.exists()) {

				existe = true;

			}
			;

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		;

		return existe;

	};

	public void deleteCliente() {

		String pathID = Integer.toString(this.getID());
		String path = "C:\\Users\\Administrador.000\\eclipse\\Java2022a\\src\\Clientes\\" + pathID + ".txt";

		try {

			File arquivo = new File(path);

			if (!arquivo.exists()) {

				new Exception("Arquivo a ser deletado não existe.");

			} else {

				arquivo.delete();

				ClienteDAO clDAO = new ClienteDAO();
				boolean x = clDAO.delete(this);
				String message = "O arquvo foi deletado.";

				if (x) {

					message += "\n O cliente foi deletado do banco de dados.";

				}

				else {

					message += "\n Erro na deleção do cliente do banco de dados";
				}

				JOptionPane.showMessageDialog(null, message);
				
				this.setNome("");
				this.setIdade(0);
				this.setID(0);
				this.setJob("");
			}
			;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}
		;

	};

	private boolean checkCliente() {

		boolean existe = false;

		if (this.getNome() != null && this.getIdade() != 0 && this.getID() != 0 && this.getJob() != null) {

			existe = true;

		}
		;

		return existe;

	};

	public Cliente(String nome, int idade, int ID, String job) {

		this.setNome(nome);
		this.setIdade(idade);
		this.setID(ID);
		this.setJob(job);

	};

	public Cliente(int ID) {

		try {

			if (!browseCliente(ID)) {

				Exception e = new Exception("Cliente não existente.");
				throw e;

			} else {

				try {

					String pathID = Integer.toString(ID);
					String path = "C:\\Users\\Administrador.000\\eclipse\\Java2022a\\src\\Clientes\\" + pathID + ".txt";

					File arquivo = new File(path);

					FileReader fr = new FileReader(arquivo);
					BufferedReader br = new BufferedReader(fr);

					this.setNome(br.readLine());
					this.setIdade(Integer.parseInt(br.readLine()));
					this.setID(Integer.parseInt(br.readLine()));
					this.setJob(br.readLine());

					br.close();
					fr.close();

				} catch (Exception eIO) {

					JOptionPane.showMessageDialog(null, eIO.getMessage());

				}
				;

			}
			;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}
		;
	};

}
