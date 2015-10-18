package controller;

import view.ComecarPartida;
import view.ComoJogar;
import view.Conectar;
import view.ImagemTabuleiro;
import model.AtorJogador;
import model.AtorNetGames;
import model.Posicao;
import model.Tabuleiro;

public class Controle {
	
	private Tabuleiro mTabuleiro;
	private ImagemTabuleiro mImagemTabuleiro;
	private AtorNetGames mAtorNetGames;
	private AtorJogador mAtorJogador;
	private Conectar mConectar;

	public Controle(){
		mAtorNetGames = new AtorNetGames();
		mConectar = new Conectar(this);
	}

	public boolean realizarLanceControle(Posicao prePos, Posicao posPos){
		return mAtorJogador.realizarLanceJogador(prePos, posPos);
	}
	
	public void getPosicoesGame(Posicao [] posicoes){
		mTabuleiro.getPosicoes(posicoes);
	}
	
	public void desistirPartida(){
		mAtorJogador.desistirPartida();
	}
	
	public void reiniciarPartida(){
		mAtorJogador.reiniciarPartida();
	}

	public void comoJogar(){
		new ComoJogar();
	}	
	
	public void disposeInterface(){
		mImagemTabuleiro.dismiss();
	}
	
	public void conectarComServidor(String server, String nomeJogador){
		int resultado = mAtorNetGames.conectar(server, nomeJogador);
		
		switch (resultado) {
		case 200:
			mConectar.dismiss();
			new ComecarPartida(this);
			break;
			
		default:
			mConectar.showError();
			break;
		}
	}
	
	public void criarJogo(){
		mImagemTabuleiro = new ImagemTabuleiro(this);
		mTabuleiro = new Tabuleiro(mAtorNetGames, this);
		mAtorJogador = new AtorJogador(mTabuleiro);
	}
}
