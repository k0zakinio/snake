package com.company;

import java.awt.*;

public class Player extends GameObject {

    Player(int x, int y, InputManager im) {
        super(x, y, im, false, true);
    }

    @Override
    public void tick(boolean playerTick) {
        if(playerTick) {
            checkInput();
        }
        checkBounds();
    }

    private void checkInput() {
        if (im.up) this.y -= 10;
        if (im.down) this.y += 10;
        if (im.right) this.x += 10;
        if (im.left) this.x -= 10;
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
