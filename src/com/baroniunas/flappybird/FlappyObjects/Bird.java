package com.baroniunas.flappybird.FlappyObjects;

import com.baroniunas.flappybird.FlappyBird;
import com.baroniunas.flappybird.GameApplication.Renderable;
import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.List;

public class Bird extends Renderable {
    public final Rectangle rect;
    private final int startingPosY;
    private int ticks;
    private int birdMotion;

    public Bird(FlappyBird app) {
        super(app, List.of(GameState.START_SCREEN, GameState.IN_GAME));
        int centerPosX = app.windowWidth / 2;
        int centerPosY = app.windowHeight / 2;
        int rectWidth = 20;
        int rectHeight = 20;
        int startingPosX = centerPosX - (rectWidth / 2);
        startingPosY = centerPosY - (rectHeight / 2);
        rect = new Rectangle(startingPosX, startingPosY, rectWidth, rectHeight);
    }

    public void resetPosition() {
        rect.y = startingPosY;
        birdMotion = 0;
    }

    public void updatePosition() {
        int maxSpeed = 15;
        int increaseDelta = 2;

        ticks++;
        boolean doIncreaseDownwardSpeed = ticks % 2 == 0 && birdMotion < maxSpeed;
        if (doIncreaseDownwardSpeed) {
            birdMotion += increaseDelta;
        }
        rect.y += birdMotion;
    }

    public void jump() {
        int motionDelta = 8;

        if (birdMotion > 0) {
            birdMotion = 0;
        }
        birdMotion -= motionDelta;
    }

    public void checkPosition() {
        int GROUND_POS_Y = 120;
        boolean hitTheGround = rect.y > app.windowHeight - GROUND_POS_Y;
        boolean hitTheCeiling = rect.y < 0;
        if (hitTheGround || hitTheCeiling) {
            app.gameOver();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red.darker());
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }

    public boolean pipeIsHit(Rectangle pipe) {
        return rect.intersects(pipe);
    }

    public boolean pipeIsPassed(Rectangle pipe) {
        boolean isUpperPipe = pipe.y == 0;
        return isUpperPipe && rect.x + rect.width / 2 > pipe.x + pipe.width / 2 - 10 && rect.x + rect.width / 2 < pipe.x + pipe.width / 2 + 10;
    }
}
