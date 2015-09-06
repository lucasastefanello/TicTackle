package model;

import java.awt.Color;

public class Tabuleiro{
	
	private Jogador jogadorAzul;
	private Jogador jogadorVermelho;
	
	// 0 == blue
	// 1 == red
	
	public Tabuleiro(){
		jogadorAzul = new Jogador("jogadorAzul", "azul");
		jogadorVermelho = new Jogador("jogadorVermelho", "vermelho");
		
		jogadorAzul.setDaVez(true);
		jogadorVermelho.setDaVez(true);
	}
	
	public void verificaMovimento(Posicao prePos, Posicao posPos){
		
		if(posPos.getType() == -1 && (prePos.getType() == 1 || prePos.getType() == 0)){
			
			boolean diferenceColunm = Math.abs(prePos.getColumn() - posPos.getColumn()) == 1;
			boolean diferenceRow = Math.abs(prePos.getRow() - posPos.getRow()) == 1;
			
			boolean isSameColunm = (prePos.getColumn() == posPos.getColumn());
			boolean isSameRow = (prePos.getRow() == posPos.getRow());
			
			if(isSameColunm || isSameRow){	
				if(diferenceColunm || diferenceRow){
					
					if(jogadorAzul.isDaVez() && prePos.getType() == 0){
						trocarPosicao(prePos, posPos);
						jogadorAzul.setDaVez(false);
						jogadorVermelho.setDaVez(true);
					}
					
					if(jogadorVermelho.isDaVez() && prePos.getType() == 1){
						trocarPosicao(prePos, posPos);
						jogadorAzul.setDaVez(true);
						jogadorVermelho.setDaVez(false);
					}
				}
			}
		}
	}	
	
	public void salvaEstado(){
		
	}
	
	public void trocarPosicao(Posicao prePos, Posicao posPos){
		int tempTypePre = prePos.getType();
		int tempTypePos = posPos.getType();
		
		prePos.setType(tempTypePos);
		posPos.setType(tempTypePre);
		
		setCor(prePos, posPos);
	}
	
	
	public void setCor(Posicao prePos, Posicao posPos){
		
		prePos.setCor(Color.LIGHT_GRAY);
		prePos.repaint();
		
		if(posPos.getType() == 1){
			posPos.setCor(Color.RED); 
			posPos.repaint();
		}else{
			posPos.setCor(Color.BLUE);
			posPos.repaint();
		}
		System.gc();
	}
}
