package controller;

import model.Posicao;
import model.Tabuleiro;

public class Controle {
	
	protected Tabuleiro tabuleiro;

	public Controle(){
		tabuleiro = new Tabuleiro();
	}

	public void ehMovimentoValido(Posicao prePos, Posicao posPos){
		tabuleiro.verificaMovimento(prePos, posPos);
	}
}
