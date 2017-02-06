package com.company;

import java.awt.*;

public class Blob extends GameObject{

    public Blob(int x, int y, ID id, InputManager im, boolean isEdible) {
        super(x,y,id, im, isEdible);
    }

    @Override
    public void tick(boolean renderPlayer) {
        checkBounds();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 18, 18);
    }

    @Override
    public void checkBounds() {
        this.outOfBounds = OutOfBounds.fromGameObject(this);
    }
}
