package controller;

import dialogs.ComoJogar;
import dialogs.Mensagens;
import view.ImagemTabuleiro;
import model.AtorNetGames;
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

	public Controle(){
		mAtorNetGames = new AtorNetGames(this);
		mMensagens = new Mensagens(this);
		mMensagens.mostrarConectar();
	}

	// ========================================REALIZAR_LANCE========================================//

	
	public boolean realizarLanceControle(Posicao prePos, Posicao posPos){
		return mTabuleiro.realizarLanceTabuleiro(prePos, posPos);
	}
	
	public void getPosicoesGame(Posicao [] posicoes){
		mTabuleiro.getPosicoes(posicoes);
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
				mMensagens.mostrarConexaoJaEstabelecida();
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
			mJogador = new Jogador(nomeJogador, "vermelho");
			mTabuleiro = new Tabuleiro(mJogador, mAtorNetGames, this);
			mTabuleiro.setDaVezJogador(false);			
		}else{
			mJogador = new Jogador(nomeJogador, "azul");
			mTabuleiro = new Tabuleiro(mJogador, mAtorNetGames, this);
			mTabuleiro.setDaVezJogador(true);
		}
		
		mAtorNetGames.setTabuleiro(mTabuleiro);
	}
	
	public void criarJogo(){
		new ImagemTabuleiro(this, mJogador.getCor());
	}
	
	// ========================================MOSTRAR_DA_VEZ========================================//
	
	public void mostraDaVezTabuleiro(){
		mImagemTabuleiro.mostraDaVezTabuleiro(mJogador.getCor());
	}
	
	// ========================================PARTIDA_CANCELADA========================================//

	public void partidaCancelada() {
		mMensagens.mostrarPartidaCancelada();
		fimDePartida();
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
		
		fecharImagemTabuleiro();
		mMensagens.resetConectar();
		mMensagens.mostrarConectar();
		
	}
}
