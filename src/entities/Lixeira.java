package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Lixeira extends Obstaculo {

    public Lixeira(int x, int y) {
        super(x, y, 50, 50, 1);
    }

    @Override
    public void update() {
        mover();
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(new Color(139,69,19)); // marrom
        g.fillRect(x, y, width, height);
    }
}
