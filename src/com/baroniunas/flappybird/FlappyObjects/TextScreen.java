package com.baroniunas.flappybird.FlappyObjects;

import com.baroniunas.flappybird.FlappyBird;
import com.baroniunas.flappybird.GameApplication.Renderable;
import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.List;

public abstract class TextScreen extends Renderable {
    public final Font TEXT_FONT = new Font("serif", Font.BOLD, 80);
    public final Color TEXT_COLOR = Color.white;

    public TextScreen(FlappyBird app, List<GameState> existsInStates) {
        super(app, existsInStates);
    }

    protected int calculatePositionY() {
        return app.windowHeight / 2 - 50;
    }
}
