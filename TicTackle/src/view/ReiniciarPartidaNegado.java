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

public class ReiniciarPartidaNegado extends JDialog {

	private final JPanel container = new JPanel();
	private JButton okButton;
	private JLabel messageRestart;

	/**
	 * Create the dialog.
	 */
	public ReiniciarPartidaNegado() {
	
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

		messageRestart = new JLabel(
				"O oponente não deseja reiniciar a partida.");
		messageRestart.setBounds(63, 63, 429, 25);
		messageRestart.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
		container.add(messageRestart);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	}

	public void setListeners() {
		
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();			
			}
		});
	}
}
