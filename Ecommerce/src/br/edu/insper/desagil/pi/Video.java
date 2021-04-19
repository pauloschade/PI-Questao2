package br.edu.insper.desagil.pi;

import java.util.HashMap;
import java.util.Map;

public class Video {
	
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;
	
	public Video(int id, Usuario usuario, Produto produto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void adicionaAvaliacoes(Usuario usuarioAvaliador, int numero) {
		if (usuarioAvaliador.getNome() == this.usuario.getNome() || numero > 5 || numero < 0) {
			return;
		}
		
		this.avaliacoes.put(usuarioAvaliador.getNome(), numero);
		
		return;
		
	}
	
	public int mediaAvaliacoes() {
		double mediaDouble;
		int soma = 0;
		int media;
		
		if (this.avaliacoes.size() == 0) {
			return 0;
		}
		for (int i: this.avaliacoes.values()) {
			soma += i;
		}
		
		mediaDouble = (double) soma/this.avaliacoes.size();
		
		media = (int) Math.round(mediaDouble);
		
		return media;
		
		
	}
	
	

}
