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

public class ComecarPartida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Create the dialog.
	 */
	public ComecarPartida() {
		setPanel();
		setListeners();
	}
	
	public void setPanel(){
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 555, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblOOpenenteDeseja = new JLabel("Tudo pronto! Vamos começar?");
		lblOOpenenteDeseja.setBounds(105, 63, 345, 25);
		lblOOpenenteDeseja.setFont(new Font("Lithos Pro", Font.PLAIN, 20));
		contentPanel.add(lblOOpenenteDeseja);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("SIM");
		
		okButton.setActionCommand("SIM");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("CANCELAR");
		cancelButton.setActionCommand("CANCELAR");
		buttonPane.add(cancelButton);
	}
	
	public void setListeners(){
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ImagemTabuleiro(); // talvez passando algo como parametro? jogadores?
			}
		});
		
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Conectar(); // reinicia todo o processo
			}
		});
		
		
	}

}
