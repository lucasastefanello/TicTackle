package model;

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

import controller.Controle;

public class AtorNetGames implements OuvidorProxy {

    private Proxy mProxy;
    private boolean mStatusConexao;
    private Tabuleiro mTabuleiro;
    private Controle mControle;
    

    public AtorNetGames() {
        mProxy = Proxy.getInstance();
        mProxy.addOuvinte(this);
        mTabuleiro = new Tabuleiro();
    }
    
    public AtorNetGames(Controle controle){
    	mControle = controle;
    }

    public int conectar(String enderecoServ, String nomeJogador) {
        try {
            mProxy.conectar(enderecoServ, nomeJogador);
            this.mStatusConexao = true;
            //controlador.setVez();
             JOptionPane.showMessageDialog(null, "Conexão estabelecida.");
            return 200;
        } catch (JahConectadoException ex) {
            JOptionPane.showMessageDialog(null, "Já existe uma conexão estabelecida.");
            return 201;

        } catch (NaoPossivelConectarException ex) {
            JOptionPane.showMessageDialog(null, "Impossível conectar. \nTente reiniciar o servidor.");
            return 404;

        } catch (ArquivoMultiplayerException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo de propriedades foi encontrado.");
            return 500;
        }

    }
    
    public void reiniciarPartida() throws NaoConectadoException{
        try {
            mProxy.reiniciarPartida();
        } catch (NaoJogandoException ex) {
            Logger.getLogger(AtorNetGames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarJogada(Jogada lance) {
        try {
            mProxy.enviaJogada(lance);

        } catch (NaoJogandoException ex) {

        }
    }
    
    public void encerrarPartida() throws NaoJogandoException {
        
         try {
         JOptionPane.showMessageDialog(null, "Obrigado por jogar nosso jogo :)");
         mProxy.finalizarPartida();
         System.exit(0);

         } catch (NaoConectadoException ex) {
         System.err.println("Erro: " + ex);
         }
    }

    @Override
   public void receberJogada(Jogada jogada){
       
        
    }

    public int iniciarPartida() {
        try {
            mProxy.iniciarPartida(new Integer(2));
            JOptionPane.showMessageDialog(null, "Conectado, \nAguarde outro jogador entrar na sala");
            //controlador.setVez();
            return 200;
           
        } catch (NaoConectadoException ex) {
           JOptionPane.showMessageDialog(null, "Impossível conectar. \nTente reiniciar o servidor.");
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
      
    }

    @Override
    public void finalizarPartidaComErro(String message) {
        JOptionPane.showMessageDialog(null, "O conexão com outro jogador foi perdida, você venceu");
        System.exit(0);
    }

    @Override
    public void receberMensagem(String msg) {
    }

    @Override
    public void tratarConexaoPerdida() {
        /**
         * @not used;
         */
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
}
