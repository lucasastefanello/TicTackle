package model;

public class Jogador {

	private String name;
	private String cor;
	private boolean daVez;
	
	public Jogador(String name, String cor){
		this.name = name;
		this.cor = cor;
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
