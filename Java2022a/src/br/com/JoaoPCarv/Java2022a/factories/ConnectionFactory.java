//WARNING: O servidor utilizado para o banco de dados é o local (localhost, porta 1433).
//WARNING: Para a devida criação do banco de dados, execute a query escrita no arquivo "Java2022a_SQLQuery.sql".

package br.com.JoaoPCarv.Java2022a.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public abstract class ConnectionFactory {

	public static Connection getConnection() throws SQLException {

		Connection con = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
					+ "username=Joao;password=senha;databaseName=Java2022a;encrypt=false");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return con;

	}

}
