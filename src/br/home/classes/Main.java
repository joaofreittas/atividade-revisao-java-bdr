package br.home.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ColecaoException {
		
		
		Pessoa p = new Pessoa("Marcos", 55);
		p.setId(1);
		
		excluir(p);
			
	
		
	}
	
	public static void inserir(String nome, int idade) {
		try {
			
			Connection c = ConexaoSingleton.getConexao();
			Pessoa p = new Pessoa(nome, idade);
			ColecaoDePessoaEmBDR bd = new ColecaoDePessoaEmBDR( c );
			bd.inserir(p);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void listar() throws ClassNotFoundException, SQLException, ColecaoException {
		
		Connection c = ConexaoSingleton.getConexao();
		ColecaoDePessoaEmBDR bd = new ColecaoDePessoaEmBDR( c );
		
		List<Pessoa> lista = bd.todas();
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa.toString());
		}
	}
	
	public static void alterar(Pessoa p) throws ColecaoException {
		
		Connection c;
		try {
			c = ConexaoSingleton.getConexao();
			ColecaoDePessoaEmBDR bd = new ColecaoDePessoaEmBDR( c );
			
			bd.atualizar(p);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void excluir(Pessoa p ) throws ColecaoException {
		Connection c;
		try {
			c = ConexaoSingleton.getConexao();
			ColecaoDePessoaEmBDR bd = new ColecaoDePessoaEmBDR( c );
			bd.remover(p);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
