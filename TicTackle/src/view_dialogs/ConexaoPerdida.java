package view_dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import controller.Controle;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConexaoPerdida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private Controle mControle;

	/**
	 * Create the dialog.
	 */
	public ConexaoPerdida(Controle controle) {
		setPanel();
		setListeners();
		mControle = controle;
	}
	
	public void setPanel(){
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 531, 232);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel titulo_conexao_perdida = new JLabel(
				"Conexão perdida! Tente conectar novamente.");
		titulo_conexao_perdida.setFont(new Font("Lithos Pro", Font.PLAIN, 16));
		titulo_conexao_perdida.setBounds(54, 64, 423, 43);
		contentPanel.add(titulo_conexao_perdida);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

	}
	
	public void setListeners(){
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mControle.fimDePartida();
				dispose();
			}
		});
	}

	public void fecharConecaoPerdida() {
		dispose();
	}

}
