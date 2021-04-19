package br.edu.insper.desagil.pi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoTest {
	
	private static double DELTA=0.05;	
	
	private Usuario usuario;
	private Produto produto;
	private Video video;
	
	@BeforeEach
	public void setUp() {
		this.usuario = new Usuario("Paulo");
		this.produto = new Produto("cadeira", 29.99);
		this.video = this.usuario.postaVideo(1, this.produto);
	}

	@Test
	public void testeUmVideoAvaliacoesInvalidas() {
		
		Usuario usuario1 = new Usuario("Dred");
		Usuario usuario2 = new Usuario("MatWon");
		
		this.video.adicionaAvaliacoes(this.usuario, 4);
		this.video.adicionaAvaliacoes(usuario1, 10);
		this.video.adicionaAvaliacoes(usuario2, -7);
		
		int media = this.usuario.totalAvaliacoes();
		
		assertEquals(0, media, DELTA);
		
	}
	
	@Test
	public void testeUmVideoUmaAvaliacao() {
		
		Usuario usuario2 = new Usuario("MatWon");
		
		this.video.adicionaAvaliacoes(usuario2, 4);
		
		int media = this.usuario.totalAvaliacoes();
		
		assertEquals(4, media, DELTA);
		
	}
	
	@Test
	public void testeUmVideoDuasAvaliacoes() {
		
		Usuario usuario1 = new Usuario("Dred");
		Usuario usuario2 = new Usuario("MatWon");
		
		this.video.adicionaAvaliacoes(usuario1, 5);
		this.video.adicionaAvaliacoes(usuario2, 4);
		
		int media = this.usuario.totalAvaliacoes();
		
		assertEquals(5, media, DELTA);
		
	}
	
	@Test
	public void testeUmVideoTresAvaliacoes() {
		
		Usuario usuario1 = new Usuario("Dred");
		Usuario usuario2 = new Usuario("MatWon");
		Usuario usuario3 = new Usuario("JV");
		
		this.video.adicionaAvaliacoes(usuario1, 1);
		this.video.adicionaAvaliacoes(usuario2, 1);
		this.video.adicionaAvaliacoes(usuario3, 2);
		
		int media = this.usuario.totalAvaliacoes();
		
		assertEquals(1, media, DELTA);
		
	}
	
	@Test
	public void testeDoisVideosTresAvaliacoes() {
		
		Usuario usuario2 = new Usuario("MatWon");
		
		this.video.adicionaAvaliacoes(usuario2, 4);
		this.video.adicionaAvaliacoes(usuario2, 5);
		
		Video video2 = this.usuario.postaVideo(2, this.produto);
		
		video2.adicionaAvaliacoes(usuario2, 10);
		
		int somaMedias = this.usuario.totalAvaliacoes();
		
		
		assertEquals(5, somaMedias, DELTA);
		
	}

}
