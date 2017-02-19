package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean running = false;
    public static final int WIDTH = 640, HEIGHT = 480;

    private Handler handler;

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Game() {
        InputManager inputManager = new InputManager();
        MyKeyListener myKeyListener = new MyKeyListener(inputManager);
        addKeyListener(myKeyListener);
        new Window(WIDTH, HEIGHT, "My shitty game!", this);
        handler = new Handler(inputManager);
        handler.addObject(new Player(150, 150, inputManager));
        handler.addObject(new Glitter(0, 0, inputManager));
        handler.addObject(new Glitter(300, 100, inputManager));
        handler.addObject(new Glitter(150, 200, inputManager));
        handler.addObject(new Glitter(40, 300, inputManager));
        handler.addObject(new Glitter(150, 400, inputManager));
        handler.addObject(new Blob(150, 200, inputManager));
    }

    public static void main(String[] args) {
        new Game();
    }


    public void run() {
        long lastTime = System.nanoTime();

        double movementTick = 5.0;
        double ns2 = 1000000000 / movementTick;
        double delta2 = 0;

        double amountOfTicks = 30;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            delta2 += (now - lastTime) / ns2;
            lastTime = now;
            while (delta > 1) {
                if (delta2 > 1) {
                    tick(true);
                    delta2--;
                    delta--;
                } else tick(false);
                delta--;
            }
            if (running) {
                render();
            }

            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(boolean playerTick) {
        handler.tick(playerTick);
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }
}
