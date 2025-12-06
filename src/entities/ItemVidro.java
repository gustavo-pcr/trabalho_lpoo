package entities;

import java.awt.Color;
import java.awt.Graphics;

public class ItemVidro extends Item {

    public ItemVidro(int x, int y) {
        super(x, y, 20, 20, 15);
    }

    @Override
    public void update() {
        mover();
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, width, height);
    }
}
