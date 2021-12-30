package com.baroniunas.flappybird.FlappyObjects;

import com.baroniunas.flappybird.FlappyBird;
import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.List;

public class ScoreIndicator extends TextScreen {
    public ScoreIndicator(FlappyBird app) {
        super(app, List.of(GameState.IN_GAME, GameState.GAME_OVER));
    }

    @Override
    public void render(Graphics g) {
        String textContents = String.valueOf(app.score);
        int textPositionX = app.windowWidth / 2 - 25;
        int textPositionY = 100;
        g.setColor(TEXT_COLOR);
        g.setFont(TEXT_FONT);
        g.drawString(textContents, textPositionX, textPositionY);
    }

    @Override
    public void checkPosition() {

    }

    @Override
    public void updatePosition() {

    }
}
