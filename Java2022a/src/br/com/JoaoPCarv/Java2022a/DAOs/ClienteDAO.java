//WARNING: O caminho de dados utilizado é nativo à máquina em que foi escrito este programa. 
//-------- Para usar o programa localmente, substitua a URL nativa pela local, onde o programa for instalado.

package br.com.JoaoPCarv.Java2022a.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.Java2022a.beans.Cliente;
import br.com.JoaoPCarv.Java2022a.factories.ConnectionFactory;
import br.com.JoaoPCarv.Java2022a.interfaces.DAO;

public class ClienteDAO implements DAO {

	private Connection con;

	public ClienteDAO() {

		try {

			this.con = ConnectionFactory.getConnection();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	@Override
	public boolean insert(Object o) {

		try {

			Cliente c = (Cliente) o;

			String cl_path = "C:\\Users\\Administrador.000\\eclipse\\Java2022a\\src\\Clientes\\" + c.getID() + ".txt";

			String sql = "Insert into Clientes(nome, idade, ID, job, cl_path) values (?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, c.getNome());
			stmt.setString(2, Integer.toString(c.getIdade()));
			stmt.setString(3, Integer.toString(c.getID()));
			stmt.setString(4, c.getJob());
			stmt.setString(5, cl_path);

			stmt.execute();
			con.close();

			return true;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return false;

	}

	@Override
	public boolean delete(Object o) {

		try {
			
			Cliente c = (Cliente) o;
			
			String sql = "Delete from Clientes where ID=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Integer.toString(c.getID()));	
			stmt.execute();
			con.close();
			
			return true;
			

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return false;

	}

}
