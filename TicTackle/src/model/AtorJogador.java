package model;

public class AtorJogador {

	private Tabuleiro mTabuleiro;
	
	public AtorJogador(Tabuleiro tabuleiro){
		mTabuleiro = tabuleiro;
	}
	
	public boolean realizarLanceJogador(Posicao prePos, Posicao posPos){
		return mTabuleiro.realizarLanceTabuleiro(prePos, posPos);
	}
	
	public void desistirPartida(){
		mTabuleiro.desistirPartida();
	}
	
	public void reiniciarPartida(){
		mTabuleiro.reiniciarPartida();
	}
}
