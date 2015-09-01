package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import model.ImagePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame {

	private JPanel contentPane;
	private final Border RAISED_LEVEL = BorderFactory.createRaisedBevelBorder();
	private final Border LOWERED_LEVEL = BorderFactory
			.createLoweredBevelBorder();
	private final CompoundBorder BORDER_COMPOUND = BorderFactory
			.createCompoundBorder(RAISED_LEVEL, LOWERED_LEVEL);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBorder(BORDER_COMPOUND);

		ImagePanel position_1_1 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/tictackle2.gif")), 1);
		position_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_1_1.setBackground(Color.RED);
		position_1_1.setBounds(17, 11, 103, 100);
		position_1_1.setBorder(BORDER_COMPOUND);
		contentPane.add(position_1_1);

		ImagePanel position_1_2 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/tictackle1.gif")), 0);
		position_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_1_2.setBackground(Color.BLUE);
		position_1_2.setBounds(137, 11, 100, 100);
		position_1_2.setBorder(BORDER_COMPOUND);
		contentPane.add(position_1_2);

		ImagePanel position_1_3 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/tictackle2.gif")), 1);
		position_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_1_3.setBackground(Color.RED);
		position_1_3.setBounds(254, 11, 100, 100);
		position_1_3.setBorder(BORDER_COMPOUND);
		contentPane.add(position_1_3);

		ImagePanel position_1_4 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/tictackle1.gif")), 0);
		position_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_1_4.setBackground(Color.BLUE);
		position_1_4.setBounds(371, 11, 100, 100);
		position_1_4.setBorder(BORDER_COMPOUND);
		contentPane.add(position_1_4);

		ImagePanel position_2_1 = new ImagePanel(
				new ImageIcon("images/tic.png").getImage(), -1);
		position_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_2_1.setBackground(Color.LIGHT_GRAY);
		position_2_1.setBounds(17, 123, 103, 100);
		position_2_1.setBorder(BORDER_COMPOUND);
		contentPane.add(position_2_1);

		ImagePanel position_2_2 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/vazio.png")), -1);
		position_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_2_2.setBackground(Color.LIGHT_GRAY);
		position_2_2.setBounds(137, 123, 100, 100);
		position_2_2.setBorder(BORDER_COMPOUND);
		contentPane.setLayout(null);
		contentPane.add(position_2_2);

		ImagePanel position_2_3 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/vazio.png")), -1);
		position_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_2_3.setBackground(Color.LIGHT_GRAY);
		position_2_3.setBounds(254, 123, 100, 100);
		position_2_3.setBorder(BORDER_COMPOUND);
		contentPane.add(position_2_3);

		ImagePanel position_2_4 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/vazio.png")), -1);
		position_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_2_4.setBackground(Color.LIGHT_GRAY);
		position_2_4.setBounds(371, 123, 100, 100);
		position_2_4.setBorder(BORDER_COMPOUND);
		contentPane.add(position_2_4);

		ImagePanel position_3_1 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/vazio.png")), -1);
		position_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_3_1.setBackground(Color.LIGHT_GRAY);
		position_3_1.setBounds(18, 235, 100, 100);
		position_3_1.setBorder(BORDER_COMPOUND);
		contentPane.add(position_3_1);

		ImagePanel position_3_2 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/vazio.png")), -1);
		position_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_3_2.setBackground(Color.LIGHT_GRAY);
		position_3_2.setBounds(136, 235, 100, 100);
		position_3_2.setBorder(BORDER_COMPOUND);
		contentPane.add(position_3_2);

		ImagePanel position_3_3 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/vazio.png")), -1);
		position_3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_3_3.setBackground(Color.LIGHT_GRAY);
		position_3_3.setBounds(254, 235, 100, 100);
		position_3_3.setBorder(BORDER_COMPOUND);
		contentPane.add(position_3_3);

		ImagePanel position_3_4 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/vazio.png")), -1);
		position_3_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_3_4.setBackground(Color.LIGHT_GRAY);
		position_3_4.setBounds(372, 235, 100, 100);
		position_3_4.setBorder(BORDER_COMPOUND);

		contentPane.add(position_3_4);

		ImagePanel position_4_1 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/tictackle1.gif")), 0);
		position_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_4_1.setBackground(Color.BLUE);
		position_4_1.setBounds(18, 347, 100, 100);
		position_4_1.setBorder(BORDER_COMPOUND);

		contentPane.add(position_4_1);

		ImagePanel position_4_2 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/tictackle2.gif")), 1);
		position_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_4_2.setBackground(Color.RED);
		position_4_2.setBounds(136, 347, 100, 100);
		position_4_2.setBorder(BORDER_COMPOUND);

		contentPane.add(position_4_2);

		ImagePanel position_4_3 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/tictackle1.gif")), 0);
		position_4_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_4_3.setBackground(Color.BLUE);
		position_4_3.setBounds(254, 347, 100, 100);
		position_4_3.setBorder(BORDER_COMPOUND);

		contentPane.add(position_4_3);

		ImagePanel position_4_4 = new ImagePanel(Toolkit.getDefaultToolkit()
				.getImage(Game.class.getResource("/images/tictackle2.gif")), 1);
		position_4_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		position_4_4.setBackground(Color.RED);
		position_4_4.setBounds(372, 347, 100, 100);
		position_4_4.setBorder(BORDER_COMPOUND);
		contentPane.add(position_4_4);

		JPanel panel = new JPanel();
		panel.setBounds(12, 475, 467, 39);
		panel.setLayout(null);

		JButton btnComoJogar = new JButton("Como Jogar?");
		btnComoJogar.setBounds(165, 5, 122, 29);
		panel.add(btnComoJogar);
		contentPane.add(panel);

		JButton button_desistir_partida = new JButton("Desistir da Partida");
		button_desistir_partida.setBounds(297, 5, 159, 29);
		panel.add(button_desistir_partida);

		JButton btnReiniciarPartida = new JButton("Reiniciar Partida");
		btnReiniciarPartida.setBounds(10, 5, 145, 29);
		panel.add(btnReiniciarPartida);
		button_desistir_partida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

	public static Image loadImage(String name) {
		String filename = "images/" + name;
		return new ImageIcon(filename).getImage();
	}
}
