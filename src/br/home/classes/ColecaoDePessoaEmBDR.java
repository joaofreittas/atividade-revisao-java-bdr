package br.home.classes;

import java.sql.Connection;
import java.util.List;

public class ColecaoDePessoaEmBDR implements ColecaoDePessoa {

	private Connection Conexao;
	
	ColecaoDePessoaEmBDR(Connection conexao){
		
	}

	@Override
	public List<Pessoa> todas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> porNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa porId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Pessoa p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Pessoa p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Pessoa p) {
		// TODO Auto-generated method stub
		
	}
}
