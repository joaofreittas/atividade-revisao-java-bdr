package br.home.classes;

import java.sql.SQLException;
import java.util.List;

public interface ColecaoDePessoa {

	public List<Pessoa> todas() throws ColecaoException, SQLException;
	public List<Pessoa> porNome(String nome) throws ColecaoException, SQLException;
	public Pessoa porId(int id) throws ColecaoException; 
	public void inserir(Pessoa p) throws ColecaoException, SQLException;
	public void atualizar(Pessoa p) throws ColecaoException;
	public void remover(Pessoa p) throws ColecaoException;
	
}
