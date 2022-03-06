//WARNING: O caminho de dados utilizado é nativo à máquina em que foi escrito este programa. 
//-------- Para usar o programa localmente, substitua a URL nativa pela local, onde o programa for instalado.

package managers;

import interfaces.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import classes.Cliente;

public class ClienteManager implements manager {
	
	private JFrame jInicio;
	
	private JFrame getjInicio() {
		
		return this.jInicio;
	}
	
	private void setjInicio() {
		
		this.jInicio = new JFrame();
		this.getjInicio().setLayout(null);
		this.getjInicio().setTitle("Inicial");
		this.getjInicio().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getjInicio().setBounds(620,250,720,320);
		this.getjInicio().getContentPane().setBackground(Color.lightGray);
		this.getjInicio().setResizable(false);
		this.getjInicio().setVisible(true);
		
		ClienteManager ghost = this;
		
		JLabel titulo = new JLabel();
		this.getjInicio().getContentPane().add(titulo);
		titulo.setFont(new Font("Serif", Font.ITALIC, 32));
		titulo.setBorder(BorderFactory.createLineBorder(Color.black));
		titulo.setText("Gerenciador de clientes");
		titulo.setBounds((this.getjInicio().getBounds().width - titulo.getPreferredSize().width)/2, 25, titulo.getPreferredSize().width, titulo.getPreferredSize().height);
		
		JLabel versao = new JLabel();
		this.getjInicio().getContentPane().add(versao);
		versao.setFont(new Font("Serif", Font.PLAIN, 20));
		versao.setText("Versão 1.0.");
		versao.setBounds(this.getjInicio().getBounds().width - versao.getPreferredSize().width 
				- (this.getjInicio().getBounds().width - titulo.getPreferredSize().width)/2, 
				titulo.getBounds().height + titulo.getBounds().y + 5, versao.getPreferredSize().width, versao.getPreferredSize().height);
			
		
		JButton bCad = new JButton();
		this.getjInicio().getContentPane().add(bCad);
		bCad.setText("Cadastrar clientes:");
		bCad.setToolTipText("Cadastre clientes aqui.");
		bCad.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		bCad.setVisible(true);
		
		bCad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ghost.getjInicio().dispose();
				ghost.create();
				return;
				
			}});
		
		JButton bDel = new JButton();
		this.getjInicio().getContentPane().add(bDel);
		bDel.setText("Apagar clientes:");
		bDel.setToolTipText("Apague clientes aqui.");
		bDel.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		bDel.setVisible(true);

		
		bDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ghost.getjInicio().dispose();
				ghost.delete();
				return;
				
			}});
		
		JButton bList = new JButton();
		this.getjInicio().getContentPane().add(bList);
		bList.setText("Consultar clientes:");
		bList.setToolTipText("Consulte clientes aqui.");
		bList.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		bList.setVisible(true);
		
		bList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ghost.getjInicio().dispose();
				ghost.search();
				return;
				
			}});

		
		int gap = (this.getjInicio().getBounds().width - bCad.getPreferredSize().width 
				- bDel.getPreferredSize().width - bList.getPreferredSize().width)/4;
		
		bCad.setBounds(gap, 205, 
				bCad.getPreferredSize().width, bCad.getPreferredSize().height);
		
		bDel.setBounds(2*gap + bCad.getPreferredSize().width, 205, 
				bDel.getPreferredSize().width, bDel.getPreferredSize().height);
		
		bList.setBounds(3*gap + bCad.getPreferredSize().width + bDel.getPreferredSize().width, 205, 
				bList.getPreferredSize().width, bList.getPreferredSize().height);
		
			
		
		
	}
	
	@Override
	public void startManager() {
		
		this.setjInicio();
		this.getjInicio().setVisible(true);
		
	}
	
	@Override
	public void create() {

		JFrame jMain = new JFrame();
		jMain.setLayout(null);
		jMain.setTitle("Frame de Cadastro");
		jMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jMain.setBounds(750,250,450,630);
		jMain.getContentPane().setBackground(Color.lightGray);
		jMain.setResizable(false);
		jMain.setVisible(true);
		
		JLabel title = new JLabel();
		jMain.getContentPane().add(title);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		title.setFont(new Font("Serif", Font.PLAIN, 32));
		title.setText("Cadastro de Clientes");
		title.setBounds((jMain.getBounds().width - title.getPreferredSize().width)/2, 30, title.getPreferredSize().width, title.getPreferredSize().height);
		title.setVisible(true);
		
		
		JLabel texto1 = new JLabel();
		jMain.getContentPane().add(texto1);
		texto1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));
		texto1.setText("Digite aqui os dados do cliente a ser cadastrado:");
		texto1.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/5, 100, texto1.getPreferredSize().width, texto1.getPreferredSize().height);	
		texto1.setVisible(true);
		
		JLabel cNome = new JLabel();
		jMain.getContentPane().add(cNome);
		cNome.setFont(new Font("Calisto MT", Font.ITALIC, 20));
		cNome.setText("Nome: ");
		cNome.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/3, 175, cNome.getPreferredSize().width, cNome.getPreferredSize().height);
		cNome.setVisible(true);
		
		int tNomeAlign = 0;
		int alignForAll = 0;
		
		JTextField tNome = new JTextField();
		jMain.getContentPane().add(tNome);
		tNome.setFont(new Font("Harrington", Font.BOLD, 20));
		tNomeAlign = ((jMain.getBounds().width - title.getPreferredSize().width)/2 + title.getPreferredSize().width)
				- ((jMain.getBounds().width - texto1.getPreferredSize().width)/3 + cNome.getPreferredSize().width + 5);
		alignForAll = (jMain.getBounds().width - texto1.getPreferredSize().width)/3 + cNome.getPreferredSize().width + 5;
		tNome.setBounds(alignForAll,
				172, tNomeAlign, tNome.getPreferredSize().height);
		tNome.setVisible(true);
		
		
		JLabel cIdade = new JLabel();
		jMain.getContentPane().add(cIdade);
		cIdade.setFont(new Font("Calisto MT", Font.ITALIC, 20));
		cIdade.setText("Idade: ");
		cIdade.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/3, 250, cIdade.getPreferredSize().width, cIdade.getPreferredSize().height);
		cIdade.setVisible(true);
		
		
		JTextField tIdade = new JTextField();
		jMain.getContentPane().add(tIdade);
		tIdade.setFont(new Font("Harrington", Font.BOLD, 20));
		tIdade.setBounds(alignForAll,
				247, tNomeAlign, tIdade.getPreferredSize().height);
		tIdade.setVisible(true);
		
		JLabel cID = new JLabel();
		jMain.getContentPane().add(cID);
		cID.setFont(new Font("Calisto MT", Font.ITALIC, 20));
		cID.setText("ID: ");
		cID.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/3, 325, cID.getPreferredSize().width, cID.getPreferredSize().height);
		cID.setVisible(true);
		
		int IDtext = ClienteManager.IDgenerator();
		
		JTextField tID = new JTextField();
		jMain.getContentPane().add(tID);
		tID.setFont(new Font("Harrington", Font.BOLD, 20));
		tID.setText(Integer.toString(IDtext));
		tID.setToolTipText("O ID é gerado automaticamente. Não é possível alterá-lo.");
		tID.setEditable(false);
		tID.setBounds(alignForAll,
				323, tNomeAlign, tID.getPreferredSize().height);
		tID.setVisible(true);
		
		JLabel cJob = new JLabel();
		jMain.getContentPane().add(cJob);
		cJob.setFont(new Font("Calisto MT", Font.ITALIC, 20));
		cJob.setText("Job: ");
		cJob.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/3, 400, cJob.getPreferredSize().width, cJob.getPreferredSize().height);
		cJob.setVisible(true);
		
		JTextField tJob = new JTextField();
		jMain.getContentPane().add(tJob);
		tJob.setFont(new Font("Harrington", Font.BOLD, 20));
		tJob.setBounds(alignForAll,
				397, tNomeAlign, tJob.getPreferredSize().height);
		tJob.setVisible(true);
		
		JButton bCad = new JButton();
		jMain.getContentPane().add(bCad);
		bCad.setText("Cadastrar!");
		bCad.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		bCad.setBounds((jMain.getBounds().width - bCad.getPreferredSize().width)/2, 475, bCad.getPreferredSize().width, bCad.getPreferredSize().height);
		bCad.setVisible(true);
		
		bCad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String warning1 = "";
				boolean flag1 = tNome.getText().length() == 0 || tIdade.getText().length() == 0 || tJob.getText().length() == 0;
				
				if(tNome.getText().length() == 0) {
					
					warning1 = "O campo de nome está em branco.";
					
				}
								
				if(tIdade.getText().length() == 0) {
					
					warning1 += "\n O campo de idade está em branco.";
					
				}
				 
				if(tJob.getText().length() == 0) {
					
					warning1 += "\n O campo de job está em branco.";	
				}
				
				if(flag1) {
					JOptionPane.showMessageDialog(jMain, warning1);	
					return;	
				}
				
				try {
					Integer.parseInt(tIdade.getText());
					
				} catch(Exception e){
					JOptionPane.showMessageDialog(jMain, "A idade não é valor numérico.");
					return;
                }
				
				if(Integer.parseInt(tIdade.getText()) < 0) {
					
					JOptionPane.showMessageDialog(jMain, "A idade não pode ser negativa.");
					return;
                }
				
				boolean flag2 = false;
				String message2 = "";
				
				try {
					Integer.parseInt(tNome.getText());
					flag2 = true;
					message2 += "O nome não pode ser numérico.";
			       } catch(Exception e) {}
				
				try {
					Integer.parseInt(tJob.getText());
					flag2 = true;
					message2 += "\n O job não pode ser numérico.";
			       } catch(Exception e) {}
				
				if(flag2) {
					JOptionPane.showMessageDialog(jMain, message2);
					return;	
				}
				
				Cliente c = new Cliente(tNome.getText(), Integer.parseInt(tIdade.getText()), Integer.parseInt(tID.getText()), tJob.getText());
				c.recordCliente();
				jMain.dispose();
				tNome.setText("");
				tIdade.setText("");
				tID.setText(Integer.toString(ClienteManager.IDgenerator()));
				tJob.setText("");
			    jMain.setVisible(true);
				return;}});
		
		JButton bSair = new JButton();
		jMain.getContentPane().add(bSair);
		bSair.setText("Voltar");
		bSair.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		bSair.setBounds(jMain.getBounds().width - bCad.getPreferredSize().width - 
				(jMain.getBounds().width - texto1.getPreferredSize().width)/2, 550, bSair.getPreferredSize().width, bSair.getPreferredSize().height);
		bSair.setVisible(true);
				
		bSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				jMain.dispose();
				ClienteManager cM = new ClienteManager();
				cM.startManager();
				
			}});
		
	}

	@Override
	public void delete() {
		
		JFrame jMain = new JFrame();
		jMain.setLayout(null);
		jMain.setTitle("Frame de Deleção");
		jMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jMain.setBounds(750,250,450,450);
		jMain.getContentPane().setBackground(Color.lightGray);
		jMain.setResizable(false);
		jMain.setVisible(true);
		
		JLabel title = new JLabel();
		jMain.getContentPane().add(title);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		title.setFont(new Font("Serif", Font.PLAIN, 32));
		title.setText("Deleção de Clientes");
		title.setBounds((jMain.getBounds().width - title.getPreferredSize().width)/2, 30, title.getPreferredSize().width, title.getPreferredSize().height);
		title.setVisible(true);
		
		JLabel texto1 = new JLabel();
		jMain.getContentPane().add(texto1);
		texto1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));
		texto1.setText("Digite aqui o ID do cliente a ser deletado:");
		texto1.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/5, 125, texto1.getPreferredSize().width, texto1.getPreferredSize().height);	
		texto1.setVisible(true);
		
		JLabel cID = new JLabel();
		jMain.getContentPane().add(cID);
		cID.setFont(new Font("Calisto MT", Font.ITALIC, 20));
		cID.setText("ID: ");
		cID.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/3, 200, cID.getPreferredSize().width, cID.getPreferredSize().height);
		cID.setVisible(true);
				
		JTextField tID = new JTextField();
		jMain.getContentPane().add(tID);
		tID.setFont(new Font("Harrington", Font.BOLD, 20));
		tID.setToolTipText("O ID identifica o cliente unicamente.");
		tID.setBounds(jMain.getBounds().width - (jMain.getBounds().width - texto1.getPreferredSize().width)/3 - texto1.getPreferredSize().width,
				197, 250, tID.getPreferredSize().height);
		tID.setVisible(true);
		
		JButton bDel = new JButton();
		jMain.getContentPane().add(bDel);
		bDel.setText("Apagar!");
		bDel.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		bDel.setBounds((jMain.getBounds().width - bDel.getPreferredSize().width)/2, 260 + texto1.getPreferredSize().height, bDel.getPreferredSize().width, bDel.getPreferredSize().height);
		bDel.setVisible(true);
		
		bDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(tID.getText().length() == 0) {
					JOptionPane.showMessageDialog(jMain, "O campo de ID está em branco. Por favor, digite um ID válido.");
					return;
				}
				
				try {
					
					Integer.parseInt(tID.getText());
					
				} catch(Exception e) {
					tID.setText(null);
					JOptionPane.showMessageDialog(jMain, "O ID deve ser numérico.");
					return;
			}
				
				if(Integer.parseInt(tID.getText()) < 0) {
					tID.setText(null);
					JOptionPane.showMessageDialog(jMain, "O ID não pode ser negativo.");
					return;
           }
				
				Cliente c = new Cliente(Integer.parseInt(tID.getText()));
				c.deleteCliente();
				tID.setText("");
				jMain.dispose();
				jMain.setVisible(true);

			}});
		
		JButton bSair = new JButton();
		jMain.getContentPane().add(bSair);
		bSair.setText("Voltar");
		bSair.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		bSair.setBounds(jMain.getBounds().width - bDel.getPreferredSize().width - 
				(jMain.getBounds().width - texto1.getPreferredSize().width)/2, 
				jMain.getBounds().height - bSair.getPreferredSize().height - 40, bSair.getPreferredSize().width, bSair.getPreferredSize().height);
		bSair.setVisible(true);
				
		bSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				jMain.dispose();
				ClienteManager cM = new ClienteManager();
				cM.startManager();
				
			}});

	}
	
	@Override
	public void search() {
		
		JFrame jMain = new JFrame();
		jMain.setLayout(null);
		jMain.setTitle("Frame de Consulta");
		jMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jMain.setBounds(750,250,450,450);
		jMain.getContentPane().setBackground(Color.lightGray);
		jMain.setResizable(false);
		jMain.setVisible(true);
		
		JLabel title = new JLabel();
		jMain.getContentPane().add(title);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		title.setFont(new Font("Serif", Font.PLAIN, 32));
		title.setText("Consulta de Clientes");
		title.setBounds((jMain.getBounds().width - title.getPreferredSize().width)/2, 30, title.getPreferredSize().width, title.getPreferredSize().height);
		title.setVisible(true);
		
		JLabel texto1 = new JLabel();
		jMain.getContentPane().add(texto1);
		texto1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));
		texto1.setText("Digite aqui o ID do cliente a ser consultado:");
		texto1.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/5, 125, texto1.getPreferredSize().width, texto1.getPreferredSize().height);	
		texto1.setVisible(true);
		
		JLabel cID = new JLabel();
		jMain.getContentPane().add(cID);
		cID.setFont(new Font("Calisto MT", Font.ITALIC, 20));
		cID.setText("ID: ");
		cID.setBounds((jMain.getBounds().width - texto1.getPreferredSize().width)/3, 200, cID.getPreferredSize().width, cID.getPreferredSize().height);
		cID.setVisible(true);
				
		JTextField tID = new JTextField();
		jMain.getContentPane().add(tID);
		tID.setFont(new Font("Harrington", Font.BOLD, 20));
		tID.setToolTipText("O ID identifica o cliente unicamente.");
		tID.setBounds(jMain.getBounds().width - (jMain.getBounds().width - texto1.getPreferredSize().width)/3 - texto1.getPreferredSize().width,
				197, 250, tID.getPreferredSize().height);
		tID.setVisible(true);
		
		JButton bList = new JButton();
		jMain.getContentPane().add(bList);
		bList.setText("Consultar!");
		bList.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		bList.setBounds((jMain.getBounds().width - bList.getPreferredSize().width)/2, 280 + texto1.getPreferredSize().height, bList.getPreferredSize().width, bList.getPreferredSize().height);
		bList.setVisible(true);
		
		bList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(tID.getText().length() == 0) {
					JOptionPane.showMessageDialog(jMain, "O campo de ID está em branco. Por favor, digite um ID válido.");
					return;
				}
				
				try {
					
					Integer.parseInt(tID.getText());
					
				} catch(Exception e) {
					tID.setText(null);
					JOptionPane.showMessageDialog(jMain, "O ID deve ser numérico.");
					return;
			}
				
				if(Integer.parseInt(tID.getText()) < 0) {
					tID.setText(null);
					JOptionPane.showMessageDialog(jMain, "O ID não pode ser negativo.");
					return;
           }
				Cliente c = new Cliente(Integer.parseInt(tID.getText()));
				tID.setText("");

				if(Cliente.browseCliente(c.getID())) {
					
					jMain.dispose();
					
					JFrame jSearch = new JFrame();
					jSearch.setLayout(null);
					jSearch.setTitle("Frame de Exibição");
					jSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jSearch.setBounds(750,250,450,450);
					jSearch.getContentPane().setBackground(Color.lightGray);
					jSearch.setResizable(false);
					jSearch.setVisible(true);
					
					JLabel label1 = new JLabel();
					jSearch.getContentPane().add(label1);
					label1.setText("Cliente do ID " + c.getID() + ":");
					label1.setBorder(BorderFactory.createLineBorder(Color.black));
					label1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
					label1.setBounds((jSearch.getBounds().width - label1.getPreferredSize().width)/2, 
							(jSearch.getBounds().height - label1.getPreferredSize().height)/9, 
							label1.getPreferredSize().width, label1.getPreferredSize().height);
										
					JLabel jNome = new JLabel();
					jSearch.getContentPane().add(jNome);
					jNome.setText("Nome: ");
					jNome.setFont(new Font("Batang", Font.HANGING_BASELINE, 28));
					
					int alignX = jSearch.getBounds().width/8;
					int alignY = jSearch.getBounds().height/9 + label1.getBounds().height + 50;
					
					jNome.setBounds(alignX, alignY, jNome.getPreferredSize().width, jNome.getPreferredSize().height);
					
					JTextField tNome = new JTextField();
					jSearch.getContentPane().add(tNome);
					tNome.setFont(new Font("Batang", Font.CENTER_BASELINE, 22));
					tNome.setEditable(false);
					tNome.setText(c.getNome());

					int boxSize = jSearch.getBounds().width - alignX - jNome.getBounds().width - 15 - 
							(jSearch.getBounds().width - label1.getPreferredSize().width)/2;
										
					tNome.setBounds(alignX + jNome.getBounds().width + 15, alignY, 
							boxSize, tNome.getPreferredSize().height);
					
					JLabel jIdade = new JLabel();
					jSearch.getContentPane().add(jIdade);
					jIdade.setText("Idade: ");
					jIdade.setFont(new Font("Batang", Font.HANGING_BASELINE, 28));
					
					jIdade.setBounds(alignX, alignY + 70, jIdade.getPreferredSize().width, jIdade.getPreferredSize().height);
					
					JTextField tIdade = new JTextField();
					jSearch.getContentPane().add(tIdade);
					tIdade.setFont(new Font("Batang", Font.CENTER_BASELINE, 22));
					tIdade.setEditable(false);
					tIdade.setText(Integer.toString(c.getIdade()));
			
					tIdade.setBounds(alignX + jNome.getBounds().width + 15, alignY + 70, 
							boxSize, tIdade.getPreferredSize().height);
					
					JLabel jJob = new JLabel();
					jSearch.getContentPane().add(jJob);
					jJob.setText("Job: ");
					jJob.setFont(new Font("Batang", Font.HANGING_BASELINE, 28));
					
					jJob.setBounds(alignX, alignY + 140, jJob.getPreferredSize().width, jJob.getPreferredSize().height);
					
					JTextField tJob = new JTextField();
					jSearch.getContentPane().add(tJob);
					tJob.setFont(new Font("Batang", Font.CENTER_BASELINE, 22));
					tJob.setEditable(false);
					tJob.setText(c.getJob());
			
					tJob.setBounds(alignX + jNome.getBounds().width + 15, alignY + 140, 
							boxSize, tJob.getPreferredSize().height);
					
					JButton jVoltar = new JButton();
					jSearch.getContentPane().add(jVoltar);
					jVoltar.setText("Voltar");
					jVoltar.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
					
					jVoltar.setBounds((jSearch.getBounds().width - jVoltar.getPreferredSize().width)/2,
							alignY + 210, jVoltar.getPreferredSize().width, jVoltar.getPreferredSize().height);
					
					jVoltar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							jSearch.dispose();
							jMain.setVisible(true);
												
						}});
				}
			}});
		
		
		JButton jBack = new JButton();
		jMain.getContentPane().add(jBack);
		jBack.setFont(new Font("Haettenschweiler", Font.ITALIC, 28));
		jBack.setText("Voltar");
		jBack.setBounds(jMain.getBounds().width*3/4, bList.getBounds().y + 70,
				jBack.getPreferredSize().width, jBack.getPreferredSize().height);
		
		jBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jMain.dispose();
				ClienteManager cM = new ClienteManager();
				cM.startManager();
				
			}});
	}
	
	private static int IDgenerator() {
		
		
		int ID = 1;
		boolean flag = false;
		
		try {
			
			while(flag == false){
				
				File arquivo = new File("C:\\Users\\Administrador.000\\eclipse\\Java2022a\\src\\Clientes\\" + ID + ".txt");
				
				if(arquivo.exists()) {
					
					ID++;
					
				} else {
					
					flag = true;
					
				}		
			}
				
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return ID;
		
	}

}