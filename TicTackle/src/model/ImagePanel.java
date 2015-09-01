package model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image = null;
	private int iWidth2;
	private int iHeight2;
	private int type;

	public ImagePanel(Image image, int type) {
		this.image = image;
		this.iWidth2 = image.getWidth(this) / 2;
		this.iHeight2 = image.getHeight(this) / 2;
		this.setType(type);
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
}