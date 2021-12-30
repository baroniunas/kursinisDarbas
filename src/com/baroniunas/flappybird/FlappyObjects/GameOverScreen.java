package com.baroniunas.flappybird.FlappyObjects;

import com.baroniunas.flappybird.FlappyBird;
import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.List;

public class GameOverScreen extends TextScreen {
    public GameOverScreen(FlappyBird app) {
        super(app, List.of(GameState.GAME_OVER));
    }

    @Override
    public void render(Graphics g) {
        String textContents = "Game Over";
        int textPositionX = 160;
        int textPositionY = this.calculatePositionY();
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
