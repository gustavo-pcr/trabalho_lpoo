package entities;

import java.awt.Color;
import java.awt.Graphics;

public class ItemPlastico extends Item {

    public ItemPlastico(int x, int y) {
        super(x, y, 20, 20, 10);
    }

    @Override
    public void update() {
        mover();
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, width, height);
    }
}
