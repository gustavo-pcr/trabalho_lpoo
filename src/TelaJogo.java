import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import entities.*;
import util.Constants;

public class TelaJogo extends JPanel implements ActionListener {

    private Jogador jogador;
    private ArrayList<Item> itens;
    private ArrayList<Obstaculo> obstaculos;
    private Timer timer;
    private Timer timerTempo;
    private Random random;
    private int pontos = 0;
    private int tempo = 60;
    private JogoFrame frame;

    public TelaJogo(JogoFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        setBackground(Constants.BACKGROUND_COLOR);

        jogador = new Jogador(380, 500);
        itens = new ArrayList<>();
        obstaculos = new ArrayList<>();
        random = new Random();

        timer = new Timer(16, this);
        timer.start();

        timerTempo = new Timer(1000, e -> tempo--);
        timerTempo.start();

        configurarControles();

        SwingUtilities.invokeLater(() -> requestFocusInWindow());
    }

    private void configurarControles() {
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = this.getInputMap(condition);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "mover_esquerda");
        actionMap.put("mover_esquerda", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.mover(-jogador.velocidade, 0);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "mover_direita");
        actionMap.put("mover_direita", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.mover(jogador.velocidade, 0);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("UP"), "mover_cima");
        actionMap.put("mover_cima", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.mover(0, -jogador.velocidade);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "mover_baixo");
        actionMap.put("mover_baixo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.mover(0, jogador.velocidade);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (tempo <= 0 || jogador.vidas <= 0) {
            timer.stop();
            timerTempo.stop();
            frame.trocarParaGameOver(pontos);
            return;
        }

        // Criar itens aleatórios
        int randItem = random.nextInt(100);
        if (randItem < 5) itens.add(new ItemVidro(random.nextInt(780), 0));
        else if (randItem < 10) itens.add(new ItemPapel(random.nextInt(780), 0));
        else if (randItem < 15) itens.add(new ItemPlastico(random.nextInt(780), 0));
        else if (randItem < 17) itens.add(new ItemMetal(random.nextInt(780), 0));

        // Criar obstáculos aleatórios
        int randObs = random.nextInt(100);
        if (randObs < 2) obstaculos.add(new Carro(random.nextInt(740), 0));
        else if (randObs < 6) obstaculos.add(new Lixeira(random.nextInt(750), 0));
        else if (randObs < 8) obstaculos.add(new NuvemPoluicao(random.nextInt(750), 0));

        itens.forEach(Item::update);
        obstaculos.forEach(Obstaculo::update);

        // Colisão com itens
        itens.removeIf(item -> {
            if (item.getBounds().intersects(jogador.getBounds())) {
                pontos += item.getPontos();
                return true;
            }
            return false;
        });

        // Colisão com obstáculos
        obstaculos.removeIf(obs -> {
            if (obs.getBounds().intersects(jogador.getBounds())) {
                jogador.vidas--;
                return true;
            }
            return false;
        });

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        jogador.desenhar(g);
        itens.forEach(i -> i.desenhar(g));
        obstaculos.forEach(o -> o.desenhar(g));

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Pontos: " + pontos, 10, 20);
        g.drawString("Vidas: " + jogador.vidas, 10, 40);
        g.drawString("Tempo: " + tempo, 10, 60);
    }
}
