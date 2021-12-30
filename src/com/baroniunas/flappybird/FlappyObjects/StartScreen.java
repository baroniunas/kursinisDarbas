package com.baroniunas.flappybird.FlappyObjects;

import com.baroniunas.flappybird.FlappyBird;
import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.List;

public class StartScreen extends TextScreen {
    public StartScreen(FlappyBird app) {
        super(app, List.of(GameState.START_SCREEN));
    }

    @Override
    public void render(Graphics g) {
        String textContents = "Click to start";
        int textPositionX = 140;
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
