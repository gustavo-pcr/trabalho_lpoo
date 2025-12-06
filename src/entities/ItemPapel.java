package entities;

import java.awt.Color;
import java.awt.Graphics;

public class ItemPapel extends Item {

    public ItemPapel(int x, int y) {
        super(x, y, 20, 20, 8);
    }

    @Override
    public void update() {
        mover();
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}
