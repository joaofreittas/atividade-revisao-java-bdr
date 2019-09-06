package br.home.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {

	private static Connection conexao = null;
	private ConexaoSingleton() {
		
	}
	
	private static Connection novaConexao() throws ClassNotFoundException{
		Connection conn = null;
		
		String USUARIO = "root";
		String SENHA = "";
		String URL = "jdbc:mysql://localhost:3306/crudFuncionario?serverTimezone=UTC";
		String DRIVER = "com.mysql.jdbc.Driver";
		try {
			Class.forName(DRIVER);
	        conn = DriverManager.getConnection(URL, USUARIO, SENHA);
	        
		}catch(SQLException e) {
			System.out.println("Falha ao conectar ao Banco.");
		}
		return conn;
		
	}
	public static Connection getConexao() throws ClassNotFoundException, SQLException {
		if(conexao == null) 
			conexao = novaConexao(); 
		return conexao;
	}
	
	

}
