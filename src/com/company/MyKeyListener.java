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
                inputManager.upPressed = true;
            }
                break;
            case VK_DOWN: {
                System.out.println("DOWN PRESSED");
                inputManager.downPressed = true;
            }
                break;
            case VK_RIGHT: {
                System.out.println("RIGHT PRESSED");
                inputManager.rightPressed = true;
            }
                break;
            case VK_LEFT: {
                System.out.println("LEFT PRESSED");
                inputManager.leftPressed = true;
            }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case VK_UP: inputManager.upPressed = false;
                break;
            case VK_DOWN: inputManager.downPressed = false;
                break;
            case VK_RIGHT: inputManager.rightPressed = false;
                break;
            case VK_LEFT: inputManager.leftPressed = false;
                break;
        }
    }
}
