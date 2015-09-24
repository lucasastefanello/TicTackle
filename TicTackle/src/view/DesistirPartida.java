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

public class DesistirPartida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Border RAISED_LEVEL = BorderFactory.createRaisedBevelBorder();
	private final Border LOWERED_LEVEL = BorderFactory
			.createLoweredBevelBorder();
	private final CompoundBorder BORDER_COMPOUND = BorderFactory
			.createCompoundBorder(RAISED_LEVEL, LOWERED_LEVEL);
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Create the dialog.
	 */
	public DesistirPartida() {
		setPanel();
		setListeners();
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

		JLabel lblVocRealmenteDeseja = new JLabel(
				"<html>Você realmente deseja <br>"
						+ " desistir da partida?<html>", SwingConstants.CENTER);
		lblVocRealmenteDeseja.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
		lblVocRealmenteDeseja.setBounds(72, 85, 313, 87);
		contentPanel.add(lblVocRealmenteDeseja);

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
	
	public void setListeners(){
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Conectar();
				dispose();
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
