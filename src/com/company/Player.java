package com.company;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id, InputManager im) {
        super(x, y, id, im);
    }

    @Override
    public void tick() {
        checkInput();
        checkBounds();
    }

    private void checkInput() {
        if (im.upPressed) this.y -= 10;
        if (im.downPressed) this.y += 10;
        if (im.rightPressed) this.x += 10;
        if (im.leftPressed) this.x -= 10;
    }


    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 18, 18);
    }

    @Override
    public void checkBounds() {
        this.outOfBounds = OutOfBounds.fromGameObject(this);
    }

}
