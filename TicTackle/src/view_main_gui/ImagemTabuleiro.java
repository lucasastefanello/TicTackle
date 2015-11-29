package view_main_gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
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
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;

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
	
	private JPanel panel;
	private JButton btn_como_jogar;
	private JButton btn_desistir_partida;
	private Controle mControle;
	private JLabel cor_jogador;
	private JLabel jogador_da_vez;
	private JLabel label;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ImagemTabuleiro frame = new ImagemTabuleiro(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	/**
	 * Create the frame.
	 */
	public ImagemTabuleiro(Controle controle, String cor) {
		initialize();
		setProperties();
		addListeners();
		setVisible(true);
		mostraDaVezTabuleiro(cor);
		mControle = controle;
	}

	public void initialize(){
		
		container = new JPanel();
				
		position_1_1 = new Posicao(1, 1, 1);
		position_1_1.setLayout(null);

		position_1_2 = new Posicao( 0, 1, 2);
		position_1_2.setLayout(null);

		position_1_3 = new Posicao( 1, 1, 3);
		position_1_3.setLayout(null);

		position_1_4 = new Posicao( 0, 1, 4);
		position_1_4.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		position_1_4.setLayout(null);
		
		position_2_1 = new Posicao( -1, 2, 1);
		position_2_1.setLayout(null);

		position_2_2 = new Posicao( -1, 2, 2);
		position_2_2.setLayout(null);

		position_2_3 = new Posicao( -1, 2, 3);
		position_2_3.setLayout(null);

		position_2_4 = new Posicao( -1, 2, 4);
		position_2_4.setLayout(null);

		position_3_1 = new Posicao( -1, 3, 1);
		position_3_1.setLayout(null);

		position_3_2 = new Posicao( -1, 3, 2);
		position_3_2.setLayout(null);

		position_3_3 = new Posicao( -1, 3, 3);
		position_3_3.setLayout(null);

		position_3_4 = new Posicao( -1, 3, 4);
		position_3_4.setLayout(null);

		position_4_1 = new Posicao( 0, 4, 1);
		position_4_1.setLayout(null);

		position_4_2 = new Posicao( 1, 4, 2);
		position_4_2.setLayout(null);

		position_4_3 = new Posicao( 0, 4, 3);
		position_4_3.setLayout(null);

		position_4_4 = new Posicao( 1, 4, 4);
		position_4_4.setLayout(null);
		
		panel = new JPanel();
		
		btn_como_jogar = new JButton("Como Jogar?");

		btn_desistir_partida = new JButton("Desistir da Partida");
	}
	
	public void setProperties(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 700, 650);
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setBorder(BORDER_COMPOUND);
		
		position_1_1.setBackground(Color.RED);
		position_1_1.setBounds(35, 119, 103, 100);
		position_1_1.setBorder(BORDER_COMPOUND);
		container.add(position_1_1);
		
		position_1_2.setBackground(Color.BLUE);
		position_1_2.setBounds(155, 119, 100, 100);
		position_1_2.setBorder(BORDER_COMPOUND);
		container.add(position_1_2);
		
		position_1_3.setBackground(Color.RED);
		position_1_3.setBounds(272, 119, 100, 100);
		position_1_3.setBorder(BORDER_COMPOUND);
		container.add(position_1_3);
		
		position_1_4.setBackground(Color.BLUE);
		position_1_4.setBounds(389, 119, 100, 100);
		position_1_4.setBorder(BORDER_COMPOUND);
		container.add(position_1_4);
		
		position_2_1.setBackground(Color.LIGHT_GRAY);
		position_2_1.setBounds(35, 231, 103, 100);
		position_2_1.setBorder(BORDER_COMPOUND);
		container.add(position_2_1);
		
		position_2_2.setBackground(Color.LIGHT_GRAY);
		position_2_2.setBounds(155, 231, 100, 100);
		position_2_2.setBorder(BORDER_COMPOUND);
		container.setLayout(null);
		container.add(position_2_2);
		
		position_2_3.setBackground(Color.LIGHT_GRAY);
		position_2_3.setBounds(272, 231, 100, 100);
		position_2_3.setBorder(BORDER_COMPOUND);
		container.add(position_2_3);
		
		position_2_4.setBackground(Color.LIGHT_GRAY);
		position_2_4.setBounds(389, 231, 100, 100);
		position_2_4.setBorder(BORDER_COMPOUND);
		container.add(position_2_4);
		
		position_3_1.setBackground(Color.LIGHT_GRAY);
		position_3_1.setBounds(36, 343, 100, 100);
		position_3_1.setBorder(BORDER_COMPOUND);
		container.add(position_3_1);
		
		position_3_2.setBackground(Color.LIGHT_GRAY);
		position_3_2.setBounds(154, 343, 100, 100);
		position_3_2.setBorder(BORDER_COMPOUND);
		container.add(position_3_2);
		
		position_3_3.setBackground(Color.LIGHT_GRAY);
		position_3_3.setBounds(272, 343, 100, 100);
		position_3_3.setBorder(BORDER_COMPOUND);
		container.add(position_3_3);
		
		position_3_4.setBackground(Color.LIGHT_GRAY);
		position_3_4.setBounds(390, 343, 100, 100);
		position_3_4.setBorder(BORDER_COMPOUND);
		container.add(position_3_4);
		
		position_4_1.setBackground(Color.BLUE);
		position_4_1.setBounds(36, 455, 100, 100);
		position_4_1.setBorder(BORDER_COMPOUND);
		container.add(position_4_1);
		
		position_4_2.setBackground(Color.RED);
		position_4_2.setBounds(154, 455, 100, 100);
		position_4_2.setBorder(BORDER_COMPOUND);
		container.add(position_4_2);
		
		position_4_3.setBackground(Color.BLUE);
		position_4_3.setBounds(272, 455, 100, 100);
		position_4_3.setBorder(BORDER_COMPOUND);
		container.add(position_4_3);
		
		position_4_4.setBackground(Color.RED);
		position_4_4.setBounds(390, 455, 100, 100);
		position_4_4.setBorder(BORDER_COMPOUND);
		container.add(position_4_4);

		panel.setBounds(30, 583, 467, 39);
		panel.setLayout(null);
		panel.add(btn_como_jogar);
		container.add(panel);
		
		btn_como_jogar.setBounds(78, 5, 122, 29);
		
		btn_desistir_partida.setBounds(228, 5, 159, 29);
		panel.add(btn_desistir_partida);
		
		JLabel titulo_jogador_da_vez = new JLabel("Jogador Da Vez:");
		titulo_jogador_da_vez.setBounds(531, 141, 118, 16);
		container.add(titulo_jogador_da_vez);
		
		jogador_da_vez = new JLabel("");
		jogador_da_vez.setBounds(531, 190, 103, 33);
		jogador_da_vez.setOpaque(true);
		container.add(jogador_da_vez);
		
		JLabel titulo_cor_jogador = new JLabel("Sua cor é:");
		titulo_cor_jogador.setBounds(531, 319, 118, 16);
		container.add(titulo_cor_jogador);
		
		cor_jogador = new JLabel("");
		cor_jogador.setBounds(531, 361, 103, 33);
		cor_jogador.setOpaque(true);
		container.add(cor_jogador);
		
		label = new JLabel("Tic Tackle");
		label.setForeground(new Color(0, 204, 102));
		label.setFont(new Font("Lithos Pro", Font.PLAIN, 40));
		label.setBounds(155, 25, 219, 57);
		container.add(label);
		
				
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
				mControle.desistirPartida();
			}
		});
		
		btn_como_jogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mControle.comoJogar();
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
			
			if(mControle.realizarLanceControle(prePos, position)){
				mControle.setPosicoesParaTabuleiro(getPosicoes());
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

	public void mostraCorJogadorTabuleiro(String cor){
		if(cor.equals("vermelho")) {
			cor_jogador.setBackground(Color.RED);
			cor_jogador.repaint();
		}else {
			cor_jogador.setBackground(Color.BLUE);
			cor_jogador.repaint();
		}
	}
	
	public void mostraDaVezTabuleiro(String cor) {
		
		if(cor.equals("vermelho")) {
			jogador_da_vez.setBackground(Color.RED);
			jogador_da_vez.repaint();
		}else {
			jogador_da_vez.setBackground(Color.BLUE);
			jogador_da_vez.repaint();
		}
	}
}
