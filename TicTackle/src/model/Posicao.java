package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Posicao extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image imagem = null;
	private int largura;
	private int altura;
	private int tipo;
	private int coluna;
	private int linha;

	public Posicao(Image image, int type, int row, int column) {
		this.imagem = image;
		this.largura = image.getWidth(this) / 2;
		this.altura = image.getHeight(this) / 2;
		this.tipo = type;
		this.coluna = column;
		this.linha = row;
	}
	
	public Posicao(int type, int row, int column) {
		
		this.tipo = type;
		this.coluna = column;
		this.linha = row;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagem != null) {
			int x = this.getParent().getWidth() / 2 - largura;
			int y = this.getParent().getHeight() / 2 - altura;
			g.drawImage(imagem, x, y, this);
		}
	}

	public int getType() {
		return tipo;
	}

	public void setType(int type) {
		this.tipo = type;
	}
	
	public void setCor(Color color){
		this.setBackground(color);
	}
	
	public int getRow() {
		return linha;
	}

	public void setRow(int row) {
		this.linha = row;
	}

	public int getColumn() {
		return coluna;
	}

	public void setColumn(int column) {
		this.coluna = column;
	}
	
	
}