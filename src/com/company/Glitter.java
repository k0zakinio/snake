package com.company;

import java.awt.*;

public class Glitter extends GameObject {

    public Glitter(int x, int y, InputManager im) {
        super(x, y, im, false, false);
    }

    @Override
    public void tick(boolean renderPlayer) {
        checkBounds();
        moveRight();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 3, 3);
    }

    @Override
    public void checkBounds() {
        this.outOfBounds = OutOfBounds.fromGameObject(this);
    }

    public void moveRight() {
        x += 10;
    }
}
