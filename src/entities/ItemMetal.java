package entities;

import java.awt.Color;
import java.awt.Graphics;

public class ItemMetal extends Item {

    public ItemMetal(int x, int y) {
        super(x, y, 20, 20, 20);
    }

    @Override
    public void update() {
        mover();
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
    }
}
