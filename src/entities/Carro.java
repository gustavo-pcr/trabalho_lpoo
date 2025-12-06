package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Carro extends Obstaculo {

    public Carro(int x, int y) {
        super(x, y, 60, 30, 1); // dano 1 vida
    }

    @Override
    public void update() {
        mover();
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
