package entities;

import java.awt.Graphics;

public abstract class Obstaculo extends Entity {

    protected int dano;

    public Obstaculo(int x, int y, int width, int height, int dano) {
        super(x, y, width, height);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    public void mover() {
        y += 2; // velocidade padrão
    }

    @Override
    public abstract void update();

    @Override
    public abstract void desenhar(Graphics g);
}
