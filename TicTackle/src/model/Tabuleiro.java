package model;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import network.AtorNetGames;
import controller.Controle;

public class Tabuleiro{
	
	private Jogador mJogador;
	private VerificaVencedor existeVencedor;
	private Posicao [] posicoes;
	private char[][] matriz;
	private String[] combinacoes;
	private AtorNetGames mAtorNetGames;
	private Controle mControle;
	private Image peaoAzul;
	private Image peaoVermelho;
	private Image espacoVazio;
	
	// 0 == blue
	// 1 == red
	
	public Tabuleiro(Jogador jogador, AtorNetGames atorNetGames, Controle controle){
		
		mAtorNetGames = atorNetGames;
		mControle = controle;
	
		mJogador = jogador;
				
		combinacoes = new String[2];
		
		matriz = new char[4][4];
		
		combinacoes[0] = "000";
		combinacoes[1] = "111";
		
		inicializarImagens();
	}
	
	private void inicializarImagens() {
		peaoAzul = loadImage("peaoAzul");
		peaoVermelho = loadImage("peaoVermelho");
		espacoVazio = loadImage("espacoVazio");
	}
	
	public boolean realizarLanceTabuleiro(Posicao prePos, Posicao posPos){
		
		if(mJogador.isDaVez() && prePos.getType() == mJogador.getTipo()){

			if(ehLanceValido(prePos, posPos)) {
					
				trocarPosicao(prePos, posPos);		
				
				if(ehVencedor(mJogador.getTipo())){
					
					mControle.informarVencedor();
					setDaVezJogador(false);
				
					Lance lanceInformarPerdedor = new Lance();
					lanceInformarPerdedor.setPrePos(prePos);
					lanceInformarPerdedor.setPosPos(posPos);
					lanceInformarPerdedor.setVencedorExiste(true);
					mAtorNetGames.enviarJogada(lanceInformarPerdedor);
					
				}else{
					Lance lanceNormal = new Lance();
					lanceNormal.setVencedorExiste(false);
					lanceNormal.setPartidaDesistida(false);
					lanceNormal.setPrePos(prePos);
					lanceNormal.setPosPos(posPos);
					mAtorNetGames.enviarJogada(lanceNormal);
					setDaVezJogador(false);
					mControle.mostraDaVezTabuleiro(false);
				}
			}

			return true;
		}
		return false;
	}
	
	public void setDaVezJogador(boolean v){
		mJogador.setDaVez(v);
	}
	
	public boolean ehLanceValido(Posicao prePos, Posicao posPos){
		
		if(posPos.getType() == -1 && posPos.getType() != mJogador.getTipo() && (prePos.getType() == 1 || prePos.getType() == 0)){
			
			boolean diferenceColunm = Math.abs(prePos.getColumn() - posPos.getColumn()) == 1;
			boolean diferenceRow = Math.abs(prePos.getRow() - posPos.getRow()) == 1;
			
			boolean isSameColunm = (prePos.getColumn() == posPos.getColumn());
			boolean isSameRow = (prePos.getRow() == posPos.getRow());
			
			if(isSameColunm || isSameRow){	
				if(diferenceColunm || diferenceRow){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void realizarLanceOponente(Posicao prePos, Posicao posPos){
		
		for(int i = 0; i < posicoes.length; i++){
			if(posicoes[i].getColumn() == prePos.getColumn() && posicoes[i].getRow() == prePos.getRow()){
				prePos = posicoes[i];
			}
			
			if(posicoes[i].getColumn() == posPos.getColumn() && posicoes[i].getRow() == posPos.getRow()){
				posPos = posicoes[i];
			}
		}
		
		trocarPosicao(prePos, posPos);	
	}
	
	public void trocarPosicao(Posicao prePos, Posicao posPos){
		int tempTypePre = prePos.getType();
		int tempTypePos = posPos.getType();
		
		prePos.setType(tempTypePos);
		posPos.setType(tempTypePre);
		
		setCor(prePos, posPos);
		
		prePos.repaint();
		posPos.repaint();
		
//		prePos.setImagem(espacoVazio);
//		
//		if(posPos.getType() == 0){
//			posPos.setImagem(peaoAzul);
//		}else{
//			posPos.setImagem(peaoVermelho);
//		}
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
	
	
	
	public boolean ehVencedor(int i){
		inicializarMatriz();
		existeVencedor = new VerificaVencedor(matriz, combinacoes[i]);
		return existeVencedor.solve();
	}
	
	public void inicializarMatriz(){
		
		if(posicoes != null){
			matriz[0][0] = Integer.toString(posicoes[0].getType()).charAt(0);
			matriz[0][1] = Integer.toString(posicoes[1].getType()).charAt(0);
			matriz[0][2] = Integer.toString(posicoes[2].getType()).charAt(0);
			matriz[0][3] = Integer.toString(posicoes[3].getType()).charAt(0);
			matriz[1][0] = Integer.toString(posicoes[4].getType()).charAt(0);
			matriz[1][1] = Integer.toString(posicoes[5].getType()).charAt(0);
			matriz[1][2] = Integer.toString(posicoes[6].getType()).charAt(0);
			matriz[1][3] = Integer.toString(posicoes[7].getType()).charAt(0);
			matriz[2][0] = Integer.toString(posicoes[8].getType()).charAt(0);
			matriz[2][1] = Integer.toString(posicoes[9].getType()).charAt(0);
			matriz[2][2] = Integer.toString(posicoes[10].getType()).charAt(0);
			matriz[2][3] = Integer.toString(posicoes[11].getType()).charAt(0);
			matriz[3][0] = Integer.toString(posicoes[12].getType()).charAt(0);
			matriz[3][1] = Integer.toString(posicoes[13].getType()).charAt(0);
			matriz[3][2] = Integer.toString(posicoes[14].getType()).charAt(0);
			matriz[3][3] = Integer.toString(posicoes[15].getType()).charAt(0);
		}
	}
	
	
	public void setPosicoes(Posicao[] posicoes){
		this.posicoes = posicoes;
	}	
	
	
	public static Image loadImage(String name) {
		String filename = "src/images/" + name;
		File file = new File(filename);
		Image image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
		return image;
	}
}
