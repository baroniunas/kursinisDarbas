package com.baroniunas.flappybird;

import com.baroniunas.flappybird.FlappyObjects.*;
import com.baroniunas.flappybird.GameApplication.GameUIApplication;

import java.awt.event.MouseEvent;

public class FlappyBird extends GameUIApplication {
    private static FlappyBird single_instance = null;
    private final Bird bird = new Bird(this);
    private final Pipes pipes = new Pipes(this, bird);

    public FlappyBird() {
        super(800, 800, "Basic Flappy Bird", GameState.START_SCREEN);
        world.add(new Background(this));
        world.add(pipes);
        world.add(bird);
        world.add(new StartScreen(this));
        world.add(new GameOverScreen(this));
        world.add(new ScoreIndicator(this));
    }

    public static FlappyBird getInstance() {
        // Singleton (Creational Design Pattern)
        if (single_instance == null) {
            single_instance = new FlappyBird();
        }
        return single_instance;
    }

    public static void main(String[] args) {
        FlappyBird app = FlappyBird.getInstance();
    }

    @Override
    public void startNewGame() {
        super.startNewGame();
        bird.resetPosition();
        pipes.resetPosition();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.gameState != GameState.IN_GAME) {
            startNewGame();
            return;
        }

        bird.jump();
    }
}
