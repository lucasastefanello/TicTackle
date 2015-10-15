package model;

public class AtorJogador {

	private Tabuleiro mTabuleiro;
	
	public AtorJogador(){
		mTabuleiro = new Tabuleiro();
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
