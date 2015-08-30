import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComoJogar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel description_game;

    public ComoJogar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        description_game = new JLabel("<html>O jogo Tic Tackle é composto de um tabuleiro com 16 posições,<br>" +
                "onde cada jogador terá quatro peças e para vencer a partida <br>" +
                "deve formar um linha reta ou diagonal com três, das quatro peças.</html>", SwingConstants.CENTER);
    }

    private void onOK() {
// add your code here
        dispose();
    }
}
