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

public class DesistirPartida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Border RAISED_LEVEL = BorderFactory.createRaisedBevelBorder();
	private final Border LOWERED_LEVEL = BorderFactory
			.createLoweredBevelBorder();
	private final CompoundBorder BORDER_COMPOUND = BorderFactory
			.createCompoundBorder(RAISED_LEVEL, LOWERED_LEVEL);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DesistirPartida dialog = new DesistirPartida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DesistirPartida() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(BORDER_COMPOUND);
		contentPanel.setLayout(null);
		{
			JLabel lblVocRealmenteDeseja = new JLabel("<html>Você realmente deseja <br>"
					+ " desistir da partida?<html>", SwingConstants.CENTER);
			lblVocRealmenteDeseja.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
			lblVocRealmenteDeseja.setBounds(72, 85, 313, 87);
			contentPanel.add(lblVocRealmenteDeseja);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("SIM");
				okButton.setActionCommand("SIM");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("NÃO");
				cancelButton.setActionCommand("NÃO");
				buttonPane.add(cancelButton);
			}
		}
	}

}
