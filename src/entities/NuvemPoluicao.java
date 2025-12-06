package entities;

import java.awt.Color;
import java.awt.Graphics;

public class NuvemPoluicao extends Obstaculo {

    private int dx = 2;

    public NuvemPoluicao(int x, int y) {
        super(x, y, 50, 30, 1);
    }

    @Override
    public void update() {
        x += dx;
        if (x < 0 || x > 750) dx = -dx; // vai e volta
        y += 2;
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(new Color(128,128,128,180)); // cinza semi-transparente
        g.fillRect(x, y, width, height);
    }
}
