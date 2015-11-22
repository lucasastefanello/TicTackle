package model;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada{

	private Posicao prePos;
	private Posicao posPos;
	private boolean vencedorExiste;
	private boolean partidaDesistida;

	public boolean isPartidaDesistida() {
		return partidaDesistida;
	}
	public void setPartidaDesistida(boolean partidaDesistida) {
		this.partidaDesistida = partidaDesistida;
	}
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
	
	
}
