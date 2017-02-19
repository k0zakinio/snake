package com.company;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.company.Game.HEIGHT;
import static com.company.Game.WIDTH;
import static com.company.OutOfBounds.*;

public class Handler {

    private List<GameObject> gameObjects = new ArrayList<>();

    void tick(boolean playerTick) {
        for(GameObject tempObject : gameObjects) {
            tempObject.tick(playerTick);
            if(tempObject.outOfBounds != NONE) wrapObject(tempObject);
        }
        removeCollidingObjects();
    }

    private void removeCollidingObjects()  {
        List<GameObject> toRemove = gameObjects.stream().filter(obj -> obj.isCollidingAndEdible(gameObjects)).collect(Collectors.toList());
        if(toRemove.size() > 0) System.out.println("toRemove = " + toRemove);
        gameObjects.removeAll(toRemove);
    }

    void render(Graphics g) {
        for (GameObject tempObject : gameObjects) {
            tempObject.render(g);
        }
    }

    private void wrapObject(GameObject tempObject) {
        if(tempObject.outOfBounds == NORTH) tempObject.setY(HEIGHT);
        if(tempObject.outOfBounds == SOUTH) tempObject.setY(0);
        if(tempObject.outOfBounds == WEST) tempObject.setX(WIDTH);
        if(tempObject.outOfBounds == EAST) tempObject.setX(0);
    }

    void addObject(GameObject object) {
        this.gameObjects.add(object);
    }

}
