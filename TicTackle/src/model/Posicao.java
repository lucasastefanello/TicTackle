package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Posicao extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image = null;
	private int iWidth2;
	private int iHeight2;
	private int type;
	private int column;
	private int row;

	public Posicao(Image image, int type, int row, int column) {
		this.image = image;
		this.iWidth2 = image.getWidth(this) / 2;
		this.iHeight2 = image.getHeight(this) / 2;
		this.type = type;
		this.column = column;
		this.row = row;
	}
	
	public Posicao(int type, int row, int column) {
		
		this.type = type;
		this.column = column;
		this.row = row;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			int x = this.getParent().getWidth() / 2 - iWidth2;
			int y = this.getParent().getHeight() / 2 - iHeight2;
			g.drawImage(image, x, y, this);
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void setCor(Color color){
		this.setBackground(color);
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	
}