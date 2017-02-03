package com.company;

public enum OutOfBounds {
    NORTH, EAST, SOUTH, WEST, NONE;

    static OutOfBounds fromGameObject(GameObject object) {
        if(object.getY() < 0) return NORTH;
        if(object.getY() > Game.HEIGHT) return SOUTH;
        if(object.getX() < 0) return WEST;
        if(object.getX() > Game.WIDTH) return EAST;
        return NONE;
    }
}
