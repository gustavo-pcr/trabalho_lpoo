package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Jogador extends Entity {

    public int vidas = 3;
    public int velocidade = 10;

    public Jogador(int x, int y) {
        super(x, y, 40, 40);
    }

    public void mover(int dx, int dy) {
        x += dx;
        y += dy;

        if (x < 0) x = 0;
        if (x > 760) x = 760;
        if (y < 0) y = 0;
        if (y > 560) y = 560;
    }

    @Override
    public void update() {
        // Não usado, movimento via KeyBindings
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
