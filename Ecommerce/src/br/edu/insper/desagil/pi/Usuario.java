package br.edu.insper.desagil.pi;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nome;
	private List<Video> videos;
	
	public Usuario(String nome) {
		super();
		this.nome = nome;
		this.videos = new ArrayList<>();;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Video postaVideo(int id, Produto produto) {
		Video novoVideo = new Video(id, this, produto);
		this.videos.add(novoVideo);
		return novoVideo;
	}
	
	public int totalAvaliacoes() {
		int soma = 0;
		
		for (Video i: this.videos) {
			soma += i.mediaAvaliacoes();
		}
		
		return soma;
	}
	
	

}
