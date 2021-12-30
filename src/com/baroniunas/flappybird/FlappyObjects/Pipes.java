package com.baroniunas.flappybird.FlappyObjects;

import com.baroniunas.flappybird.FlappyBird;
import com.baroniunas.flappybird.GameApplication.Renderable;
import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pipes extends Renderable {
    private final Bird bird;
    private final ArrayList<Rectangle> pipes;
    private final Random random;

    public Pipes(FlappyBird app, Bird bird) {
        super(app, List.of(GameState.IN_GAME, GameState.GAME_OVER));
        this.bird = bird;
        this.random = new Random();
        pipes = new ArrayList<>();
        resetPosition();
    }

    public void resetPosition() {
        pipes.clear();
        addPipe(true);
        addPipe(true);
        addPipe(true);
        addPipe(true);
    }

    private void addPipe(boolean startingPipe) {
        int space = 300;
        int pipeSpacing = 300;
        int largePipeSpacing = 600;
        int verticalBufferSize = 100;
        int pipeWidth = 100;
        int pipeHeight = 50 + random.nextInt(300);

        int x, y, height;
        if (startingPipe) {
            x = app.windowWidth + pipeWidth + pipes.size() * pipeSpacing;
            y = app.windowHeight - pipeHeight - verticalBufferSize;
            pipes.add(new Rectangle(x, y, pipeWidth, pipeHeight));

            x = app.windowWidth + pipeWidth + (pipes.size() - 1) * pipeSpacing;
            height = app.windowHeight - pipeHeight - space;
            pipes.add(new Rectangle(x, 0, pipeWidth, height));
        } else {
            x = pipes.get(pipes.size() - 1).x + largePipeSpacing;
            y = app.windowHeight - pipeHeight - verticalBufferSize;
            pipes.add(new Rectangle(x, y, pipeWidth, pipeHeight));

            x = pipes.get(pipes.size() - 1).x;
            height = app.windowHeight - pipeHeight - space;
            pipes.add(new Rectangle(x, 0, pipeWidth, height));
        }
    }

    public void checkPosition() {
        for (Rectangle pipe : pipes) {
            if (pipe.x + pipe.width < 0) {
                pipes.remove(pipe);
                if (pipe.y == 0) {
                    addPipe(false);
                }
            }
        }
    }

    public void updatePosition() {
        int pipeMovement = 10;
        for (Rectangle pipe : pipes) {
            pipe.x -= pipeMovement;
        }

        checkBirdPosition();
        updateScore();
    }

    private void updateScore() {
        for (Rectangle pipe : pipes) {
            if (bird.pipeIsPassed(pipe) && app.gameState == GameState.IN_GAME) {
                app.score++;
            }
        }
    }

    private void checkBirdPosition() {
        for (Rectangle pipe : pipes) {
            if (bird.pipeIsHit(pipe)) {
                app.gameOver();
                break;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        for (Rectangle pipe : pipes) {
            g.setColor(Color.green.darker());
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }
    }
}
