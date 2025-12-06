package entities;

import java.awt.Graphics;

public abstract class Item extends Entity {

    protected int pontos;

    public Item(int x, int y, int width, int height, int pontos) {
        super(x, y, width, height);
        this.pontos = pontos;
    }

    public int getPontos() {
        return pontos;
    }

    public void mover() {
        y += 2; // velocidade padrão
    }
}
