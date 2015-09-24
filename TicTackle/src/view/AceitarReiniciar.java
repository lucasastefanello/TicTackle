package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AceitarReiniciar extends JDialog {

	private final JPanel container = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private String jogadorVermelho;
	private String jogadorAzul;

	/**
	 * Create the dialog.
	 */
	public AceitarReiniciar(String jogadorVermelho, String jogadorAzul) {
		this.jogadorVermelho = jogadorVermelho;
		this.jogadorAzul = jogadorAzul;
		
		setPanel();
		setListeners();
	}

	public void setPanel() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		setBounds(100, 100, 555, 212);
		getContentPane().setLayout(new BorderLayout());
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(container, BorderLayout.CENTER);
		container.setLayout(null);

		JLabel lblOOpenenteDeseja = new JLabel(
				"O openente deseja reiniciar a partida!");
		lblOOpenenteDeseja.setBounds(63, 63, 429, 25);
		lblOOpenenteDeseja.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
		container.add(lblOOpenenteDeseja);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("SIM");
		okButton.setActionCommand("SIM");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("NÃO");
		cancelButton.setActionCommand("NÃO");
		buttonPane.add(cancelButton);
	}

	public void setListeners() {
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Reiniciar(jogadorVermelho, jogadorAzul);
			}
		});
		
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();			
			}
		});
	}
}
