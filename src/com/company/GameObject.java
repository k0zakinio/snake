package com.company;

import java.awt.*;
import java.util.List;

public abstract class GameObject {

    int x, y;
    InputManager im;
    OutOfBounds outOfBounds;
    private boolean isEdible;
    private boolean isInteractable;

    GameObject(int x, int y, InputManager inputManager, boolean isEdible, boolean isInteractable) {
        this.x = x;
        this.y = y;
        this.im = inputManager;
        this.isEdible = isEdible;
        this.isInteractable = isInteractable;
    }

    public abstract void tick(boolean renderPlayer);
    public abstract void render(Graphics g);
    public abstract void checkBounds();

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    boolean isCollidingAndEdible(List<GameObject> object) {
        for(GameObject obj : object) {
            boolean notThisObject = !obj.equals(this);
            if(notThisObject) {
                boolean sameposition = obj.x == this.x && obj.y == this.y;
                if(sameposition && this.isEdible && this.isInteractable && obj.isInteractable) {
                    return true;
                }
            }
        }
        return false;
    }
}
