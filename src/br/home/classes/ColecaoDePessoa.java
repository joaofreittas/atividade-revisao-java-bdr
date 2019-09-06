package br.home.classes;

import java.util.List;

public interface ColecaoDePessoa {

	public List<Pessoa> todas();
	public List<Pessoa> porNome(String nome);
	public Pessoa porId(int id);
	public void inserir(Pessoa p);
	public void atualizar(Pessoa p);
	public void remover(Pessoa p);
	
}
