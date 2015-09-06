package controller;

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
}
