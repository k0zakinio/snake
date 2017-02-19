package com.company;

import java.awt.*;
import java.util.List;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected InputManager im;
    protected OutOfBounds outOfBounds;
    public boolean isEdible;
    private boolean isInteractable;

    public GameObject(int x, int y, ID id, InputManager inputManager, boolean isEdible, boolean isInteractable) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.im = inputManager;
        this.isEdible = isEdible;
        this.isInteractable = isInteractable;
    }

    public abstract void tick(boolean renderPlayer);
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

    public boolean isCollidingAndEdible(List<GameObject> object) {
        for(GameObject obj : object) {
            boolean notEquals = !obj.equals(this);
            if(notEquals) {
                boolean sameposition = obj.x == this.x && obj.y == this.y;
                if(sameposition && this.isEdible && this.isInteractable && obj.isInteractable) {
                    return true;
                }
            }
        }
        return false;
    }
}
