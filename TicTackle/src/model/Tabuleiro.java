package model;

import java.awt.Color;

import controller.Controle;
import view.DesistirPartida;
import view.PartidaCancelada;
import view.Reiniciar;
import view.ReiniciarPartidaNegado;

public class Tabuleiro{
	
	private Jogador mJogador;
	private VerificaVencedor existeVencedor;
	private Posicao [] posicoes;
	private int [] estado;
	private char[][] matriz;
	private String[] combinacoes;
	private AtorNetGames mAtorNetGames;
	private Controle mControle;
	// 0 == blue
	// 1 == red
	
	public Tabuleiro(Jogador jogador, AtorNetGames atorNetGames, Controle controle){
		
		mAtorNetGames = atorNetGames;
		mControle = controle;
	
		mJogador = jogador;
		
		mJogador.setDaVez(true);
		
		combinacoes = new String[2];
		
		matriz = new char[4][4];
		
		combinacoes[0] = "000";
		combinacoes[1] = "111";
	}
	
	public Tabuleiro(){
		
	}
	
	public boolean realizarLanceTabuleiro(Posicao prePos, Posicao posPos){
		
		if(mJogador.isDaVez()){

			if(ehLanceValido(prePos, posPos)) {
					
				trocarPosicao(prePos, posPos);
				
				if(ehVencedor(0)){
					
				}
			}

			return true;
		}
		return false;
	}
	
	public void setDaVezJogador(boolean v){
		mJogador.setDaVez(v);
		mControle.mostraDaVezTabuleiro(v);
	}
	
	public boolean ehLanceValido(Posicao prePos, Posicao posPos){
		
		if(posPos.getType() == -1 && (prePos.getType() == 1 || prePos.getType() == 0)){
			
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
	
	
	
	public boolean ehVencedor(int i){
	
		inicializarMatriz();
		existeVencedor = new VerificaVencedor(matriz, combinacoes[i]);
		return existeVencedor.solve();
	}
	
	
	public void getEstado(){
		for(int i = 0; i < posicoes.length; i ++){
			estado[i] = posicoes[i].getType();
		}
	}
	
	public void enviaEstado(Posicao prePos, Posicao posPre){
		Posicao [] estado = new Posicao[2];
		estado[0] = prePos;
		estado[1] = posPre;
		
		// netGames envia array...
	}
	
	public void recebeEstado(Posicao prePos, Posicao posPos){
		
		int columnPre = prePos.getColumn();
		int rowPre = prePos.getRow();
	
		int columnPos = posPos.getColumn();
		int rowPos = posPos.getRow();
		
		for(int i = 0; i < posicoes.length; i ++){
			
			if(posicoes[i].getColumn() == columnPre && posicoes[i].getRow() == rowPre){
				prePos = posicoes[i];
			}
			
			if(posicoes[i].getColumn() == columnPos && posicoes[i].getRow() == rowPos){
				posPos = posicoes[i];
			}
		}
		
		trocarPosicao(prePos, posPos);
		setCor(prePos, posPos);
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
	
	
	public void getPosicoes(Posicao[] posicoes){
		this.posicoes = posicoes;
	}

	public void desistirPartida(){
		// netGames envia requisicao para mostrar popup de cancelamento e encerra a partida
		new DesistirPartida();
	}
	
	public void recebeCancelamento(){
		new PartidaCancelada();
		mControle.disposeInterface();
	}
	
	public void reiniciarPartida(){
		//envia requisicao de reinicio
		
		// se aceita
		new Reiniciar(mJogador.getName(), mJogador.getName());
		
		// se nao aceita
		
		new ReiniciarPartidaNegado();
	}	
}
