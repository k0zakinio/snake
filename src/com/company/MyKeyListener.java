package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class MyKeyListener implements KeyListener {

    InputManager inputManager;

    public MyKeyListener(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case VK_UP: {
                System.out.println("UP PRESSED");
                inputManager.up = true;
                inputManager.down = false;
                inputManager.right = false;
                inputManager.left = false;
            }
                break;
            case VK_DOWN: {
                System.out.println("DOWN PRESSED");
                inputManager.down = true;
                inputManager.right = false;
                inputManager.left = false;
                inputManager.up = false;            }
                break;
            case VK_RIGHT: {
                System.out.println("RIGHT PRESSED");
                inputManager.right = true;
                inputManager.down = false;
                inputManager.left = false;
                inputManager.up = false;
            }
                break;
            case VK_LEFT: {
                System.out.println("LEFT PRESSED");
                inputManager.left = true;
                inputManager.down = false;
                inputManager.right = false;
                inputManager.up = false;
            }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
