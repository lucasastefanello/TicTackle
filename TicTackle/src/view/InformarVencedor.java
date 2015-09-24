package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

public class InformarVencedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Border RAISED_LEVEL = BorderFactory.createRaisedBevelBorder();
	private final Border LOWERED_LEVEL = BorderFactory
			.createLoweredBevelBorder();
	private final CompoundBorder BORDER_COMPOUND = BorderFactory
			.createCompoundBorder(RAISED_LEVEL, LOWERED_LEVEL);
	private static String name;

	
	/**
	 * Create the dialog.
	 */
	public InformarVencedor(String name) {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.name = name;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(BORDER_COMPOUND);
		contentPanel.setLayout(null);
		
		JLabel lblOJogadorTal = new JLabel("O jogador "+ name + " venceu a partida!");
		lblOJogadorTal.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
		lblOJogadorTal.setBounds(41, 92, 368, 54);
		contentPanel.add(lblOJogadorTal);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
