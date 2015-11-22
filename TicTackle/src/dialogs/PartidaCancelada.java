package dialogs;

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

public class PartidaCancelada extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private Controle mControle;

	/**
	 * Create the dialog.
	 */
	public PartidaCancelada(Controle controle) {
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

		JLabel lblPartidaCanceladaPelo = new JLabel(
				"Partida cancelada pelo oponente");
		lblPartidaCanceladaPelo.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
		lblPartidaCanceladaPelo.setBounds(54, 64, 423, 43);
		contentPanel.add(lblPartidaCanceladaPelo);

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

}
