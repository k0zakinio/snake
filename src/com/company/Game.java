package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean running = false;
    public static final int WIDTH = 640, HEIGHT = 480;

    private Handler handler;
    boolean upPressed;
    boolean downPressed;
    boolean rightPressed;
    boolean leftPressed;

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public Game() {
        InputManager inputManager = new InputManager();
        MyKeyListener myKeyListener = new MyKeyListener(inputManager);
        Player player = new Player(150, 150, ID.Player, inputManager);
        addKeyListener(myKeyListener);
        new Window(WIDTH, HEIGHT, "My shitty game!", this);
        handler = new Handler();
        handler.addObject(player);
        handler.addObject(new Glitter(0, 0, ID.Glitter, inputManager));
        handler.addObject(new Glitter(300, 100, ID.Glitter, inputManager));
        handler.addObject(new Glitter(150, 200, ID.Glitter, inputManager));
        handler.addObject(new Glitter(40, 300, ID.Glitter, inputManager));
        handler.addObject(new Glitter(150, 400, ID.Glitter, inputManager));
        handler.addObject(new Blob(150, 200, ID.Blob, inputManager));
    }

    public static void main(String[] args) {
        new Game();
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta > 1) {
                tick();
                delta--;
            }
            if(running) {
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
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
