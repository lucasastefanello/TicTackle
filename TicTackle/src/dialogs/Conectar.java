package dialogs;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controle;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Conectar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_nome;
	private JTextField textFieldServer;
	private final Border RAISED_LEVEL = BorderFactory.createRaisedBevelBorder();
	private final Border LOWERED_LEVEL = BorderFactory
			.createLoweredBevelBorder();
	private final CompoundBorder BORDER_COMPOUND = BorderFactory
			.createCompoundBorder(RAISED_LEVEL, LOWERED_LEVEL);
	private JButton okButton;
	private JButton cancelButton;
	private Controle mControle;
	private JLabel lblConectar;
	private JLabel esperar;
	private JLabel label_server;
	private JLabel label_nome;
	private JLabel erroConexao;
	private JLabel erroPropriedade;
	private JLabel conexaoEstabelecida;


	/**
	 * Create the dialog.
	 */
	public Conectar(Controle controle) {
		mControle = controle;
		setPanel();
		setListeners();
	}

	public void setPanel(){
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		setBounds(100, 100, 533, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(BORDER_COMPOUND);
		contentPanel.setLayout(null);

		label_nome = new JLabel("Nome:");
		label_nome.setBounds(236, 161, 61, 16);
		contentPanel.add(label_nome);

		textField_nome = new JTextField();
		textField_nome.setBounds(127, 189, 278, 28);
		contentPanel.add(textField_nome);
		textField_nome.setColumns(10);

		label_server = new JLabel("Server:");
		label_server.setBounds(236, 241, 61, 16);
		contentPanel.add(label_server);

		textFieldServer = new JTextField();
		textFieldServer.setBounds(127, 262, 278, 28);
		contentPanel.add(textFieldServer);
		textFieldServer.setColumns(10);

		JLabel lblTicTackle = new JLabel("Tic Tackle");
		lblTicTackle.setForeground(new Color(0, 204, 102));
		lblTicTackle.setFont(new Font("Lithos Pro", Font.PLAIN, 40));
		lblTicTackle.setBounds(144, 27, 235, 57);
		contentPanel.add(lblTicTackle);

		lblConectar = new JLabel("Conectar");
		lblConectar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblConectar.setBounds(224, 96, 85, 28);
		contentPanel.add(lblConectar);
		
		esperar = new JLabel("Aguarde outro jogador se conectar...");
		esperar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		esperar.setBounds(224, 96, 85, 28);
		contentPanel.add(esperar);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(6, 313, 521, 39);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(null);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(159, 5, 86, 29);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		okButton = new JButton("OK");
		okButton.setBounds(279, 5, 75, 29);
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		erroConexao = new JLabel("Impossível conectar. Tente reiniciar o servidor");
		erroConexao.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		erroConexao.setBounds(224, 96, 85, 28);
		contentPanel.add(erroConexao);
		erroConexao.setVisible(false);
		
		erroPropriedade = new JLabel("Nenhum arquivo de propriedades foi encontrado");
		erroPropriedade.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		erroPropriedade.setBounds(224, 96, 85, 28);
		contentPanel.add(erroPropriedade);
		erroPropriedade.setVisible(false);
		
		conexaoEstabelecida = new JLabel("Nenhum arquivo de propriedades foi encontrado");
		conexaoEstabelecida.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		conexaoEstabelecida.setBounds(224, 96, 85, 28);
		contentPanel.add(conexaoEstabelecida);
		conexaoEstabelecida.setVisible(false);
		
		repaint();
	}
	
	public void setListeners(){
		
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mControle.conectarComServidor(textFieldServer.getText(), textField_nome.getText());
			}
		});
		
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void showWait(){
		textField_nome.setVisible(false);
		textFieldServer.setVisible(false);
		label_nome.setVisible(false);
		label_server.setVisible(false);
		
		erroPropriedade.setVisible(false);
		conexaoEstabelecida.setVisible(false);
		erroConexao.setVisible(false);
		
		esperar.setVisible(true);	
	}
	
	public void showErroConexao(){
		textField_nome.setVisible(false);
		textFieldServer.setVisible(false);
		label_nome.setVisible(false);
		label_server.setVisible(false);
		
		esperar.setVisible(false);	
		erroPropriedade.setVisible(false);
		conexaoEstabelecida.setVisible(false);

		erroConexao.setVisible(true);
	}
	
	public void showErroPropriedades() {
		textField_nome.setVisible(false);
		textFieldServer.setVisible(false);
		label_nome.setVisible(false);
		label_server.setVisible(false);
		
		conexaoEstabelecida.setVisible(false);
		erroConexao.setVisible(false);
		esperar.setVisible(false);
		
		erroPropriedade.setVisible(true);
	}

	public void showConexaoJaEstabelecida() {
		textField_nome.setVisible(false);
		textFieldServer.setVisible(false);
		label_nome.setVisible(false);
		label_server.setVisible(false);
		
		erroPropriedade.setVisible(false);
		erroConexao.setVisible(false);
		esperar.setVisible(false);
				
		conexaoEstabelecida.setVisible(true);
	}
	
	public void dismiss(){
		this.dispose();
	}

	public void resetCampos() {
		textField_nome.setVisible(true);
		textFieldServer.setVisible(true);
		label_nome.setVisible(true);
		label_server.setVisible(true);
		
		erroPropriedade.setVisible(false);
		erroConexao.setVisible(false);
		esperar.setVisible(false);
		conexaoEstabelecida.setVisible(false);
	}

}
