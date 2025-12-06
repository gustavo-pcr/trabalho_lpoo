import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaGameOver extends JPanel {

    private JogoFrame frame;

    public TelaGameOver(JogoFrame frame, int pontos) {
        this.frame = frame;
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel("Fim de Jogo! Pontos: " + pontos);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(250, 150, 400, 50);
        add(label);

        JButton btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setBounds(300, 250, 200, 50);
        btnReiniciar.addActionListener((ActionEvent e) -> frame.trocarParaJogo());
        add(btnReiniciar);

        JButton btnMenu = new JButton("Menu");
        btnMenu.setBounds(300, 320, 200, 50);
        btnMenu.addActionListener((ActionEvent e) -> frame.trocarParaMenu());
        add(btnMenu);
    }
}
