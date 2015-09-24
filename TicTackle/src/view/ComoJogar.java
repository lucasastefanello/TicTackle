package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComoJogar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Border RAISED_LEVEL = BorderFactory.createRaisedBevelBorder();
	private final Border LOWERED_LEVEL = BorderFactory
			.createLoweredBevelBorder();
	private final CompoundBorder BORDER_COMPOUND = BorderFactory
			.createCompoundBorder(RAISED_LEVEL, LOWERED_LEVEL);
	private JButton okButton;

	/**
	 * Create the dialog.
	 */
	public ComoJogar() {
		setPanel();
		setListener();
	}
	
	public void setPanel(){

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(BORDER_COMPOUND);
		contentPanel.setLayout(null);

		JLabel label_description = new JLabel(
				"<html>O jogo Tic Tackle é composto de um tabuleiro com 16 posições "
						+ "onde cada jogador terá quatro peças e para vencer a partida "
						+ "deve formar um linha reta ou diagonal com três, das quatro peças</html>",
				SwingConstants.CENTER);
		label_description.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
		label_description.setBounds(20, 29, 410, 181);
		contentPanel.add(label_description);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	}

	public void setListener(){
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();			
			}
		});
	}
}
