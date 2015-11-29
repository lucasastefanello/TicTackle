package controller;

import network.AtorNetGames;
import view_dialogs.ComoJogar;
import view_dialogs.Mensagens;
import view_main_gui.ImagemTabuleiro;
import model.Jogador;
import model.Lance;
import model.Posicao;
import model.Tabuleiro;

public class Controle {
	
	private Tabuleiro mTabuleiro;
	private ImagemTabuleiro mImagemTabuleiro;
	private AtorNetGames mAtorNetGames;
	private String nomeJogador;
	private Mensagens mMensagens;
	private Jogador mJogador;
	private String corJogador;

	public Controle(){
		mAtorNetGames = new AtorNetGames(this);
		mMensagens = new Mensagens(this);
		mMensagens.mostrarConectar();
	}

	// ========================================REALIZAR_LANCE========================================//

	
	public boolean realizarLanceControle(Posicao prePos, Posicao posPos){
		return mTabuleiro.realizarLanceTabuleiro(prePos, posPos);
	}
	
	public void setPosicoesParaTabuleiro(Posicao [] posicoes){
		mTabuleiro.setPosicoes(posicoes);
	}
	
	// ========================================DESISTIR_PARTIDA========================================//
	
	public void desistirPartida(){
		mMensagens.mostrarDesistirPartida();
	}
	
	public void confirmarDesitencia() {
		Lance lance = new Lance();
		lance.setPartidaDesistida(true);
		mAtorNetGames.enviarJogada(lance);
		
		fimDePartida();
	}
	

	// ========================================COMO_JOGAR========================================//
	
	public void comoJogar(){
		new ComoJogar();
	}	
	
	public void fecharImagemTabuleiro(){
		mImagemTabuleiro.dismiss();
	}
	
	// ========================================CONEXAO_SERVIDOR========================================//
	
	public void conectarComServidor(String server, String nome){
		
		nomeJogador = nome;
		
		int resultado = mAtorNetGames.conectar(server, nomeJogador);
		
		switch (resultado) {
			
		case 200:
				
				switch (mAtorNetGames.iniciarPartida()) {
				
				case 200:
					mMensagens.mostrarEspera();
					iniciar();
					break;

				case 404:
					mMensagens.mostrarErroConectar();
					break;
				}
				break;
				
			case 201:
				//mMensagens.mostrarConexaoJaEstabelecida();
				break;
				
			case 404:
				mMensagens.mostrarErroConectar();
				break;
				
			case 500:
				mMensagens.mostrarErroPropriedades();
				break;
		}
	}
	
	public void mostrarErroConexao(){
		mMensagens.mostrarErroConectar();
	}
	
	// ========================================INICIAR/CRIAR_JOGO========================================//
	
public void iniciar(){
		
		if(mAtorNetGames.temAdversario()){
			mJogador = new Jogador(nomeJogador, "vermelho", 1);
			mTabuleiro = new Tabuleiro(mJogador, mAtorNetGames, this);
			corJogador = "vermelho";
			mTabuleiro.setDaVezJogador(false);			
		}else{
			mJogador = new Jogador(nomeJogador, "azul", 0);
			mTabuleiro = new Tabuleiro(mJogador, mAtorNetGames, this);
			corJogador = "azul";
			mTabuleiro.setDaVezJogador(true);
		}
		
		mAtorNetGames.setTabuleiro(mTabuleiro);
	}
	
	public void criarJogo(){
		mMensagens.fecharConectar();
		mImagemTabuleiro = new ImagemTabuleiro(this, mJogador.getCor());
		mImagemTabuleiro.mostraDaVezTabuleiro("azul");
		mTabuleiro.setPosicoes(mImagemTabuleiro.getPosicoes());
		mostraCorJogadorTabuleiro(corJogador);
	}
	
	// ========================================MOSTRAR_DA_VEZ========================================//
	
	public void mostraDaVezTabuleiro(boolean b){
		if(b){
			mImagemTabuleiro.mostraDaVezTabuleiro(mJogador.getCor());
		}else{
			if(mJogador.getCor().equals("azul")){
				mImagemTabuleiro.mostraDaVezTabuleiro("vermelho");
			}else{
				mImagemTabuleiro.mostraDaVezTabuleiro("azul");
			}
		}
	}
	
	// ========================================MOSTRAR_COR_JOGADOR========================================//
	
	public void mostraCorJogadorTabuleiro(String cor){
		mImagemTabuleiro.mostraCorJogadorTabuleiro(cor);
	}
	
	// ========================================PARTIDA_CANCELADA========================================//

	public void partidaCancelada() {
		mMensagens.mostrarPartidaCancelada();
	}

	// ========================================INFORMAR_PERDEDOR_VENCEDOR========================================//
	
	public void informarPerdedor() {
		mMensagens.mostrarPerdedor();
		
	}

	public void informarVencedor() {
		mMensagens.mostrarVencedor();
	}
	
	
	// ========================================FIM_PARTIDA========================================//

	public void fimDePartida() {
		mAtorNetGames.desconectar();
		fecharImagemTabuleiro();
		mMensagens.resetConectar();
		mMensagens.mostrarConectar();
		
	}

	public void conexaoPerdida() {
		mMensagens.mostrarConexaoPerdida();
	}
}
