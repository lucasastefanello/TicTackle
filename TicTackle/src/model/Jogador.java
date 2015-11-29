package model;

public class Jogador {

	private String name;
	private String cor;
	private boolean daVez;
	private int tipo;
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Jogador(String name, String cor, int tipo){
		this.name = name;
		this.cor = cor;
		this.tipo = tipo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public boolean isDaVez() {
		return daVez;
	}

	public void setDaVez(boolean daVez) {
		this.daVez = daVez;
	}
}
