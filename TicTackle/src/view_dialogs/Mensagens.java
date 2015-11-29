package view_dialogs;

import network.Conectar;
import controller.Controle;

public class Mensagens {

	private Controle mControle;
	
	private Conectar mConectar;
	private ComoJogar mComoJogar;
	private DesistirPartida mDesistirPartida;
	private InformarVencedor mInformarVencedor;
	private PartidaCancelada mPartidaCancelada;
	private InformarPerdedor mInformarPerdedor;
	private ConexaoPerdida mConexaoPerdida;

	public Mensagens(Controle controle){
		mControle = controle;
	}
	
	public void mostrarConectar(){
		mConectar = new Conectar(mControle);
	}
	
	public void esconderConectar(){
		if(mConectar != null){
			mConectar.fecharConectar();
		}
	}
	
	public void mostrarErroConectar(){
		if(mConectar != null){
			mConectar.showErroConexao();
		}
	}
	
	public void mostrarEspera(){
		if(mConectar != null){
			mConectar.showWait();
		}
	}
	
	public void mostrarConexaoJaEstabelecida(){
		if(mConectar != null){
			mConectar.showConexaoJaEstabelecida();
		}
	}
	
	public void mostrarErroPropriedades(){
		if(mConectar != null){
			mConectar.showErroPropriedades();
		}
	}

	public void mostrarComoJogar(){
		mComoJogar = new ComoJogar();
	}
	
	public void mostrarDesistirPartida(){
		mDesistirPartida = new DesistirPartida(mControle);
	}
	
	public void mostrarPartidaCancelada(){
		mPartidaCancelada = new PartidaCancelada(mControle);
	}
	
	public void mostrarVencedor(){
		mInformarVencedor = new InformarVencedor(mControle);
	}
	
	public void mostrarPerdedor(){
		mInformarPerdedor = new InformarPerdedor(mControle);
	}

	public void resetConectar() {
		mConectar.resetCampos();
	}
	
	public void fecharConectar(){
		mConectar.fecharConectar();
	}
	
	public void mostrarConexaoPerdida(){
		mConexaoPerdida = new ConexaoPerdida(mControle);
	}
}
