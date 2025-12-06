import javax.swing.*;

public class JogoFrame extends JFrame {

    public JogoFrame() {
        setTitle("EcoCity Runner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setSize(util.Constants.WIDTH, util.Constants.HEIGHT); // força tamanho
        setResizable(false);
        setLocationRelativeTo(null); // centraliza na tela
        trocarParaMenu();
        setVisible(true);

    }

    public void trocarParaJogo() {
        setContentPane(new TelaJogo(this));
        revalidate();
        repaint();
        SwingUtilities.invokeLater(() -> getContentPane().requestFocusInWindow());
    }

    public void trocarParaGameOver(int pontos) {
        setContentPane(new TelaGameOver(this, pontos));
        revalidate();
        repaint();
        SwingUtilities.invokeLater(() -> getContentPane().requestFocusInWindow());
    }

    public void trocarParaMenu() {
        setContentPane(new TelaMenu(this));
        revalidate();
        repaint();
        SwingUtilities.invokeLater(() -> getContentPane().requestFocusInWindow());
    }
}
