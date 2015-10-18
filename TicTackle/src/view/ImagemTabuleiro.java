package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import controller.Controle;
import model.Posicao;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class ImagemTabuleiro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container;
	private final Border RAISED_LEVEL = BorderFactory.createRaisedBevelBorder();
	private final Border LOWERED_LEVEL = BorderFactory
			.createLoweredBevelBorder();
	private final CompoundBorder BORDER_COMPOUND = BorderFactory
			.createCompoundBorder(RAISED_LEVEL, LOWERED_LEVEL);
	
	protected Posicao position_1_1;
	protected Posicao position_1_2;
	protected Posicao position_1_3;
	protected Posicao position_1_4;
	protected Posicao position_2_1;
	protected Posicao position_2_2;
	protected Posicao position_2_3;
	protected Posicao position_2_4;
	protected Posicao position_3_1;
	protected Posicao position_3_2;
	protected Posicao position_3_3;
	protected Posicao position_3_4;
	protected Posicao position_4_1;
	protected Posicao position_4_2;
	protected Posicao position_4_3;
	protected Posicao position_4_4;
	
	protected Posicao prePos;
	
	protected int contarCliques;
	
	protected Controle controle;
	private JPanel panel;
	private JButton btn_como_jogar;
	private JButton btn_desistir_partida;
	private JButton btn_reiniciar_partida;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImagemTabuleiro frame = new ImagemTabuleiro();
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
	public ImagemTabuleiro() {
		initialize();
		setProperties();
		addListeners();
		setVisible(true);
	}

	public void initialize(){
		
		container = new JPanel();
		
		controle = new Controle();
		
		position_1_1 = new Posicao(loadImage("circle.png"), 1, 1, 1);
		position_1_1.setLayout(null);

		position_1_2 = new Posicao(loadImage("cross.png"), 0, 1, 2);
		position_1_2.setLayout(null);

		position_1_3 = new Posicao(loadImage("circle.png"), 1, 1, 3);
		position_1_3.setLayout(null);

		position_1_4 = new Posicao(loadImage("cross.png"), 0, 1, 4);
		position_1_4.setLayout(null);
		
		position_2_1 = new Posicao(loadImage("empty.png"), -1, 2, 1);
		position_2_1.setLayout(null);

		position_2_2 = new Posicao(loadImage("empty.png"), -1, 2, 2);
		position_2_2.setLayout(null);

		position_2_3 = new Posicao(loadImage("empty.png"), -1, 2, 3);
		position_2_3.setLayout(null);

		position_2_4 = new Posicao(loadImage("empty.png"), -1, 2, 4);
		position_2_4.setLayout(null);

		position_3_1 = new Posicao(loadImage("empty.png"), -1, 3, 1);
		position_3_1.setLayout(null);

		position_3_2 = new Posicao(loadImage("empty.png"), -1, 3, 2);
		position_3_2.setLayout(null);

		position_3_3 = new Posicao(loadImage("empty.png"), -1, 3, 3);
		position_3_3.setLayout(null);

		position_3_4 = new Posicao(loadImage("empty.png"), -1, 3, 4);
		position_3_4.setLayout(null);

		position_4_1 = new Posicao(loadImage("cross.png"), 0, 4, 1);
		position_4_1.setLayout(null);

		position_4_2 = new Posicao(loadImage("circle.png"), 1, 4, 2);
		position_4_2.setLayout(null);

		position_4_3 = new Posicao(loadImage("cross.png"), 0, 4, 3);
		position_4_3.setLayout(null);

		position_4_4 = new Posicao(loadImage("circle.png"), 1, 4, 4);
		position_4_4.setLayout(null);
		
		panel = new JPanel();
		
		btn_como_jogar = new JButton("Como Jogar?");
		
		btn_reiniciar_partida = new JButton("Reiniciar Partida");

		btn_desistir_partida = new JButton("Desistir da Partida");

	}
	
	public void setProperties(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 493, 549);
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setBorder(BORDER_COMPOUND);
		
		position_1_1.setBackground(Color.RED);
		position_1_1.setBounds(17, 11, 103, 100);
		position_1_1.setBorder(BORDER_COMPOUND);
		container.add(position_1_1);
		
		position_1_2.setBackground(Color.BLUE);
		position_1_2.setBounds(137, 11, 100, 100);
		position_1_2.setBorder(BORDER_COMPOUND);
		container.add(position_1_2);
		
		position_1_3.setBackground(Color.RED);
		position_1_3.setBounds(254, 11, 100, 100);
		position_1_3.setBorder(BORDER_COMPOUND);
		container.add(position_1_3);
		
		position_1_4.setBackground(Color.BLUE);
		position_1_4.setBounds(371, 11, 100, 100);
		position_1_4.setBorder(BORDER_COMPOUND);
		container.add(position_1_4);
		
		position_2_1.setBackground(Color.LIGHT_GRAY);
		position_2_1.setBounds(17, 123, 103, 100);
		position_2_1.setBorder(BORDER_COMPOUND);
		container.add(position_2_1);
		
		position_2_2.setBackground(Color.LIGHT_GRAY);
		position_2_2.setBounds(137, 123, 100, 100);
		position_2_2.setBorder(BORDER_COMPOUND);
		container.setLayout(null);
		container.add(position_2_2);
		
		position_2_3.setBackground(Color.LIGHT_GRAY);
		position_2_3.setBounds(254, 123, 100, 100);
		position_2_3.setBorder(BORDER_COMPOUND);
		container.add(position_2_3);
		
		position_2_4.setBackground(Color.LIGHT_GRAY);
		position_2_4.setBounds(371, 123, 100, 100);
		position_2_4.setBorder(BORDER_COMPOUND);
		container.add(position_2_4);
		
		position_3_1.setBackground(Color.LIGHT_GRAY);
		position_3_1.setBounds(18, 235, 100, 100);
		position_3_1.setBorder(BORDER_COMPOUND);
		container.add(position_3_1);
		
		position_3_2.setBackground(Color.LIGHT_GRAY);
		position_3_2.setBounds(136, 235, 100, 100);
		position_3_2.setBorder(BORDER_COMPOUND);
		container.add(position_3_2);
		
		position_3_3.setBackground(Color.LIGHT_GRAY);
		position_3_3.setBounds(254, 235, 100, 100);
		position_3_3.setBorder(BORDER_COMPOUND);
		container.add(position_3_3);
		
		position_3_4.setBackground(Color.LIGHT_GRAY);
		position_3_4.setBounds(372, 235, 100, 100);
		position_3_4.setBorder(BORDER_COMPOUND);
		container.add(position_3_4);
		
		position_4_1.setBackground(Color.BLUE);
		position_4_1.setBounds(18, 347, 100, 100);
		position_4_1.setBorder(BORDER_COMPOUND);
		container.add(position_4_1);
		
		position_4_2.setBackground(Color.RED);
		position_4_2.setBounds(136, 347, 100, 100);
		position_4_2.setBorder(BORDER_COMPOUND);
		container.add(position_4_2);
		
		position_4_3.setBackground(Color.BLUE);
		position_4_3.setBounds(254, 347, 100, 100);
		position_4_3.setBorder(BORDER_COMPOUND);
		container.add(position_4_3);
		
		position_4_4.setBackground(Color.RED);
		position_4_4.setBounds(372, 347, 100, 100);
		position_4_4.setBorder(BORDER_COMPOUND);
		container.add(position_4_4);

		panel.setBounds(12, 475, 467, 39);
		panel.setLayout(null);
		panel.add(btn_como_jogar);
		container.add(panel);

		btn_como_jogar.setBounds(165, 5, 122, 29);
		
		btn_desistir_partida.setBounds(297, 5, 159, 29);
		panel.add(btn_desistir_partida);

		btn_reiniciar_partida.setBounds(10, 5, 145, 29);
		panel.add(btn_reiniciar_partida);
		
		
	}

	public void addListeners(){
		
		position_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_1_1.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_1_1);
			}
		});
		
		position_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_1_2.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_1_2);
			}
		});
		
		position_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_1_3.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_1_3);
			}
		});
		
		position_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_1_4.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_1_4);
			}
		});
		
		position_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_2_1.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_2_1);
			}
		});
		
		position_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_2_2.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_2_2);
			}
		});
		
		position_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_2_3.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_2_3);
			}
		});
		
		position_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_2_4.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_2_4);
			}
		});
		
		position_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_3_1.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_3_1);
			}
		});
		
		position_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_3_2.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_3_2);
			}
		});
		
		position_3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_3_3.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_3_3);
			}
		});
		
		position_3_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_3_4.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_3_4);
			}
		});
		
		position_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_4_1.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_4_1);
			}
		});
		
		position_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_4_2.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_4_2);
			}
		});
		
		position_4_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_4_3.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_4_3);
			}
		});
		
		position_4_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Type "+ position_4_4.getType() + " / countCicks = " + contarCliques + "\n");
				solicitaJogada(position_4_4);
			}
		});
		
		btn_desistir_partida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controle.desistirPartida();
			}
		});
		
		btn_reiniciar_partida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controle.reiniciarPartida();
			}
		});
		
		btn_como_jogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controle.comoJogar();
			}
		});
	
	}
	
	public static Image loadImage(String name) {
		String filename = "src/images/" + name;
		File file = new File(filename);
		Image image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
		return image;
	}
	
	public void solicitaJogada(Posicao position){
		
		if(position.getType() != -1){
			prePos = position;
			contarCliques++;
			
			if(prePos == position && contarCliques == 2){
				contarCliques--;
			}
		}
		
		if(contarCliques == 1 && position.getType() == -1){
			contarCliques ++;
		}
		
		if(contarCliques == 2){
			contarCliques = 0;
			
			if(controle.realizarLanceControle(prePos, position)){
				controle.getPosicoesGame(getPosicoes());
			}
		}
	}
	
	public Posicao[] getPosicoes(){
		
		Posicao [] posicoes = new Posicao[16];

		posicoes[0] = position_1_1;
		posicoes[1] = position_1_2;
		posicoes[2] = position_1_3;
		posicoes[3] = position_1_4;
		posicoes[4] = position_2_1;
		posicoes[5] = position_2_2;
		posicoes[6] = position_2_3;
		posicoes[7] = position_2_4;
		posicoes[8] = position_3_1;
		posicoes[9] = position_3_2;
		posicoes[10] = position_3_3;
		posicoes[11] = position_3_4;
		posicoes[12] = position_4_1;
		posicoes[13] = position_4_2;
		posicoes[14] = position_4_3;
		posicoes[15] = position_4_4;
		
		return posicoes;
	}
	
	public void dismiss(){
		dispose();
	}
}
