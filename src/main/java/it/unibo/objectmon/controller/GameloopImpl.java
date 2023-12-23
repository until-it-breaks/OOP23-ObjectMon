package it.unibo.objectmon.controller;

/**
 * A simple game loop implementation based on time elapsed since last cycle.
 */
public final class GameloopImpl implements Runnable, Gameloop {

    private static final int FPS = 60;
    private static final long SECOND_IN_MILLIS = 1_000_000_000;

    @Override
    public void run() {
        final double drawInterval = (double) SECOND_IN_MILLIS / FPS;
        double delta = 0.0;
        long lastTime = System.nanoTime();
        long currenTime;

        while (true) {
            currenTime = System.nanoTime();
            delta += (currenTime - lastTime) / drawInterval;
            lastTime = currenTime;

            if (delta >= 1) {
                update();
                delta--;
            }
        }
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void start() {
        this.run();
    }
}
