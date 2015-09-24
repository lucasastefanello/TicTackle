package controller;

import javax.swing.JPanel;

import view.Game;
import model.Posicao;
import model.Tabuleiro;

public class Controle {
	
	protected Tabuleiro tabuleiro;
	protected Game game;

	public Controle(){
		tabuleiro = new Tabuleiro();
	}

	public boolean ehMovimentoValido(Posicao prePos, Posicao posPos){
		return tabuleiro.verificaMovimento(prePos, posPos);
	}
	
	public void setPosicoesGame(Posicao [] posicoes){
		tabuleiro.recebePosicoes(posicoes);
	}
	
	public void desistirPartida(){
		tabuleiro.desistirPartida();
	}
	
	public void reiniciarPartida(){
		tabuleiro.reiniciarPartida();
	}

	public void comoJogar(){
		tabuleiro.comoJogar();
	}	
	
	public void setContainerJogo(JPanel container){
		tabuleiro.setContainerJogo(container);
	}
}
