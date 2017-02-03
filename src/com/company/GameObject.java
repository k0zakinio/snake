package com.company;

import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected InputManager im;
    protected OutOfBounds outOfBounds;

    public GameObject(int x, int y, ID id, InputManager inputManager) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.im = inputManager;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void checkBounds();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
