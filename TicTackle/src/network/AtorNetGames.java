package network;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Lance;
import model.Tabuleiro;
import controller.Controle;

public class AtorNetGames implements OuvidorProxy {

    private Proxy mProxy;
    private Tabuleiro mTabuleiro;
    private Controle mControle;
    private boolean mIsPartidaCancelada;
    
    public AtorNetGames(Controle controle){
    	mProxy = Proxy.getInstance();
        mProxy.addOuvinte(this);
    	mControle = controle;
    }
    
    public void setTabuleiro(Tabuleiro tabuleiro){
    	mTabuleiro = tabuleiro;
    }

    public int conectar(String enderecoServ, String nomeJogador) {
        try {
            mProxy.conectar(enderecoServ, nomeJogador);
            return 200;
        } catch (JahConectadoException ex) {
            return 201;

        } catch (NaoPossivelConectarException ex) {
            return 404;

        } catch (ArquivoMultiplayerException ex) {
            return 500;
        }
    }
    
//    public void reiniciarPartida() throws NaoConectadoException{
//        try {
//            mProxy.reiniciarPartida();
//        } catch (NaoJogandoException ex) {
//            Logger.getLogger(AtorNetGames.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void enviarJogada(Lance lance) {
        try {
            mProxy.enviaJogada(lance);

        } catch (NaoJogandoException ex) {

        }
    }
    
    public void encerrarPartida() throws NaoJogandoException {
            	
         try {
        	 //JOptionPane.showMessageDialog(null, "Obrigado por jogar nosso jogo :)");
        	 mProxy.finalizarPartida();
        	 //System.exit(0);

         } catch (NaoConectadoException ex) {
        	 System.err.println("Erro: " + ex);
         }
    }

    public int iniciarPartida() {
        try {
            mProxy.iniciarPartida(new Integer(2));
            return 200;
           
        } catch (NaoConectadoException ex) {
            return 404;          
        }
    }

    public void desconectar() {
        try {
            mProxy.desconectar();
        } catch (NaoConectadoException e) {
        }
    }

    public String getAdversario(String idUsuario) {
        String aux1 = mProxy.obterNomeAdversario(new Integer(1));
        String aux2 = mProxy.obterNomeAdversario(new Integer(2));

        if (aux1.equals(idUsuario)) {
            return aux2;
        } else {
            return aux1;
        }
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
    	mControle.criarJogo();
    }

    @Override
    public void finalizarPartidaComErro(String message) {
    }

    @Override
    public void receberMensagem(String msg) {
    }

    @Override
    public void tratarConexaoPerdida() {
    	//mControle.conexaoPerdida();
    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {
        /**
         * @not used;
         */
    }

    public boolean temAdversario() {
        return !this.mProxy.obterNomeAdversarios().isEmpty();  
    }

	@Override
	public void receberJogada(Jogada jogada) {
						
		if(((Lance) jogada).isPartidaDesistida()){
			mControle.partidaCancelada();
		} 
		else if(((Lance) jogada).isVencedorExiste()){
			mTabuleiro.realizarLanceOponente(((Lance) jogada).getPrePos(), ((Lance) jogada).getPosPos());
			mControle.informarPerdedor();
		}else {
			mTabuleiro.setDaVezJogador(true);
			mControle.mostraDaVezTabuleiro(true);
			mTabuleiro.realizarLanceOponente(((Lance) jogada).getPrePos(), ((Lance) jogada).getPosPos());
		}
	}
}
