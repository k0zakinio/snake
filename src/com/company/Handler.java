package com.company;

import java.awt.*;
import java.util.ArrayList;

import static com.company.Game.HEIGHT;
import static com.company.Game.WIDTH;
import static com.company.OutOfBounds.*;

public class Handler {

    ArrayList<GameObject> object = new ArrayList<>();
    InputManager inputManager;

    public void tick() {
        for(GameObject tempObject : object) {
            tempObject.tick();
            if(tempObject.outOfBounds != NONE) wrapObject(tempObject);
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    private void wrapObject(GameObject tempObject) {
        if(tempObject.outOfBounds == NORTH) tempObject.setY(HEIGHT);
        if(tempObject.outOfBounds == SOUTH) tempObject.setY(0);
        if(tempObject.outOfBounds == WEST) tempObject.setX(WIDTH);
        if(tempObject.outOfBounds == EAST) tempObject.setX(0);
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        System.out.println("removed object");
        this.object.remove(object);
    }

}
