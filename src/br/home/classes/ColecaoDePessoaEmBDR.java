package br.home.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ColecaoDePessoaEmBDR implements ColecaoDePessoa {

	private Connection conexao;
	
	ColecaoDePessoaEmBDR(Connection conexao){
		this.conexao = conexao;
	}

	public List<Pessoa> todas() throws ColecaoException, SQLException{
		String query = "SELECT * FROM pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(query);
		
		ResultSet resultado = ps.executeQuery();
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		while(resultado.next()) {
			int id = resultado.getInt("id");
			String name = resultado.getString("nome");
			int idade = resultado.getInt("idade");
			
			Pessoa p = new Pessoa(name, idade);
			lista.add(p);
		}
		
		resultado.close();
		ps.close();
		return lista;
	}

	public List<Pessoa> porNome(String nome) throws ColecaoException, SQLException{
		return null;
	}

	public Pessoa porId(int id) throws ColecaoException{
		return null;
	}

	public void inserir(Pessoa p) throws ColecaoException, SQLException{
		String query = 
				"INSERT INTO pessoa(nome, idade) "
				+ "VALUES('"+p.getNome()+"', "+p.getIdade()+")";
		
		PreparedStatement ps = this.conexao.prepareStatement(query);
		ps.execute();
		ps.close();
		
	}

	public void atualizar(Pessoa p) throws ColecaoException{
		String query = 
				"UPDATE pessoa SET nome = '" + p.getNome() + "', idade = " + p.getIdade() + 
				" WHERE id = " + p.getId();
		
		PreparedStatement ps;
		try {
			
			ps = this.conexao.prepareStatement(query);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void remover(Pessoa p) throws ColecaoException{
		String query = 
				" DELETE FROM pessoa WHERE id = " + p.getId();
		try {
			PreparedStatement ps = this.conexao.prepareStatement(query);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
