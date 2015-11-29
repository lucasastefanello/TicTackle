package network;

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
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

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
	private JLabel campo_obrigatorio;


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

		setBounds(100, 100, 533, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(BORDER_COMPOUND);
		contentPanel.setLayout(null);

		label_nome = new JLabel("Nome:");
		label_nome.setBounds(246, 161, 41, 16);
		contentPanel.add(label_nome);

		textField_nome = new JTextField();
		textField_nome.setBounds(127, 189, 278, 28);
		contentPanel.add(textField_nome);
		textField_nome.setColumns(10);

		label_server = new JLabel("Server:");
		label_server.setBounds(243, 241, 46, 16);
		contentPanel.add(label_server);

		textFieldServer = new JTextField();
		textFieldServer.setBounds(127, 262, 278, 28);
		contentPanel.add(textFieldServer);
		textFieldServer.setColumns(10);

		JLabel lblTicTackle = new JLabel("Tic Tackle");
		lblTicTackle.setForeground(new Color(0, 204, 102));
		lblTicTackle.setFont(new Font("Lithos Pro", Font.PLAIN, 40));
		lblTicTackle.setBounds(157, 27, 219, 57);
		contentPanel.add(lblTicTackle);

		lblConectar = new JLabel("Conectar");
		lblConectar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblConectar.setBounds(224, 96, 85, 28);
		contentPanel.add(lblConectar);
		
		esperar = new JLabel("Aguarde outro jogador se conectar...");
		esperar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		esperar.setBounds(86, 135, 429, 28);
		esperar.setVisible(false);
		contentPanel.add(esperar);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(6, 333, 521, 39);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		okButton = new JButton("OK");
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		erroConexao = new JLabel("<html>Impossível conectar. Verifique sua conexão <br>    e se o endereço do servidor está correto.</html>");
		erroConexao.setHorizontalAlignment(SwingConstants.CENTER);
		erroConexao.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		erroConexao.setBounds(59, 136, 414, 64);
		contentPanel.add(erroConexao);
		erroConexao.setVisible(false);
		
		erroPropriedade = new JLabel("Nenhum arquivo de propriedades foi encontrado");
		erroPropriedade.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		erroPropriedade.setBounds(31, 135, 484, 28);
		contentPanel.add(erroPropriedade);
		erroPropriedade.setVisible(false);
		
		conexaoEstabelecida = new JLabel("Já existe uma conexão estabelecida");
		conexaoEstabelecida.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		conexaoEstabelecida.setBounds(91, 135, 374, 28);
		contentPanel.add(conexaoEstabelecida);
		
		campo_obrigatorio = new JLabel("Todos os campos são obrigatórios");
		campo_obrigatorio.setBounds(157, 305, 219, 16);
		contentPanel.add(campo_obrigatorio);
		campo_obrigatorio.setVisible(false);
		conexaoEstabelecida.setVisible(false);
		
		repaint();
	}
	
	public void setListeners(){
		
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField_nome.getText().equalsIgnoreCase("") || !textFieldServer.getText().equalsIgnoreCase("")){
					mControle.conectarComServidor(textFieldServer.getText(), textField_nome.getText());
					showWait();
				}else{
					campo_obrigatorio.setVisible(true);
				}
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
		lblConectar.setVisible(false);
		
		erroPropriedade.setVisible(false);
		conexaoEstabelecida.setVisible(false);
		erroConexao.setVisible(false);
		campo_obrigatorio.setVisible(false);

		esperar.setVisible(true);	
		
		okButton.setVisible(false);
	}
	
	public void showErroConexao(){
		textField_nome.setVisible(false);
		textFieldServer.setVisible(false);
		label_nome.setVisible(false);
		label_server.setVisible(false);
		lblConectar.setVisible(false);
		campo_obrigatorio.setVisible(false);

		esperar.setVisible(false);	
		erroPropriedade.setVisible(false);
		conexaoEstabelecida.setVisible(false);

		erroConexao.setVisible(true);
		
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetCampos();
			}
		});
		
	}
	
	public void showErroPropriedades() {
		textField_nome.setVisible(false);
		textFieldServer.setVisible(false);
		label_nome.setVisible(false);
		label_server.setVisible(false);
		lblConectar.setVisible(false);
		campo_obrigatorio.setVisible(false);

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
		lblConectar.setVisible(false);
		campo_obrigatorio.setVisible(false);

		erroPropriedade.setVisible(false);
		erroConexao.setVisible(false);
		esperar.setVisible(false);
				
		conexaoEstabelecida.setVisible(true);
	}
	
	public void fecharConectar(){
		this.dispose();
	}

	public void resetCampos() {
		setListeners();
		textField_nome.setVisible(true);
		textFieldServer.setVisible(true);
		label_nome.setVisible(true);
		label_server.setVisible(true);
		lblConectar.setVisible(true);

		campo_obrigatorio.setVisible(false);

		erroPropriedade.setVisible(false);
		erroConexao.setVisible(false);
		esperar.setVisible(false);
		conexaoEstabelecida.setVisible(false);
	}
}
