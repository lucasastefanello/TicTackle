package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;


public class ComecarPartida extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ComecarPartida dialog = new ComecarPartida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ComecarPartida() {
		setBounds(100, 100, 555, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblOOpenenteDeseja = new JLabel("Tudo pronto! Vamos começar?");
			lblOOpenenteDeseja.setBounds(105, 63, 345, 25);
			lblOOpenenteDeseja.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
			contentPanel.add(lblOOpenenteDeseja);
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
