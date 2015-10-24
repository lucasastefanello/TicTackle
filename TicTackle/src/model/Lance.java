package model;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada{

	private Posicao prePos;
	private Posicao posPos;
	private boolean vencedorExiste;
	private boolean criarJogo;
	
	public Posicao getPrePos() {
		return prePos;
	}
	public void setPrePos(Posicao prePos) {
		this.prePos = prePos;
	}
	public Posicao getPosPos() {
		return posPos;
	}
	public void setPosPos(Posicao posPos) {
		this.posPos = posPos;
	}
	public boolean isVencedorExiste() {
		return vencedorExiste;
	}
	public void setVencedorExiste(boolean vencedorExiste) {
		this.vencedorExiste = vencedorExiste;
	}
	public boolean isCriarJogo() {
		return criarJogo;
	}
	public void setCriarJogo(boolean criarJogo) {
		this.criarJogo = criarJogo;
	}
	
	
}
