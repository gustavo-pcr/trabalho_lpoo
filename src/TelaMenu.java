import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaMenu extends JPanel {

    private JogoFrame frame;

    public TelaMenu(JogoFrame frame) {
        this.frame = frame;
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JButton btnJogar = new JButton("Jogar");
        btnJogar.setBounds(300, 200, 200, 50);
        btnJogar.addActionListener((ActionEvent e) -> frame.trocarParaJogo());

        add(btnJogar);
    }
}
