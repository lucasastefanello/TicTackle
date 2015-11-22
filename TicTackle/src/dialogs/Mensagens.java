package dialogs;

import controller.Controle;

public class Mensagens {

	private Controle mControle;
	
	private Conectar mConectar;
	private ComecarPartida mComecarPartida;
	private ComoJogar mComoJogar;
	private DesistirPartida mDesistirPartida;
	private InformarVencedor mInformarVencedor;
	private PartidaCancelada mPartidaCancelada;
	private InformarPerdedor mInformarPerdedor;

	public Mensagens(Controle controle){
		mControle = controle;
	}
	
	public void mostrarConectar(){
		mConectar = new Conectar(mControle);
	}
	
	public void esconderConectar(){
		if(mConectar != null){
			mConectar.dismiss();
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
	
	public void mostrarComecarPartida(){
		mComecarPartida = new ComecarPartida(mControle);
	}
	
	public void mostrarComoJogar(){
		mComoJogar = new ComoJogar();
	}
	
	public void mostrarDesistirPartida(){
		mDesistirPartida = new DesistirPartida(mControle);
	}
	
	public void mostrarPartidaCancelada(){
		mPartidaCancelada = new PartidaCancelada();
	}
	
	public void mostrarVencedor(){
		mInformarVencedor = new InformarVencedor(mControle);
	}
	
	public void mostrarPerdedor(){
		mInformarPerdedor = new InformarPerdedor();
	}

	public void resetConectar() {
		mConectar.resetCampos();
	}
}
