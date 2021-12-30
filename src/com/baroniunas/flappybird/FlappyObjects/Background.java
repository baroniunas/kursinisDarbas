package com.baroniunas.flappybird.FlappyObjects;

import com.baroniunas.flappybird.FlappyBird;
import com.baroniunas.flappybird.GameApplication.Renderable;
import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.List;

public class Background extends Renderable {
    public Background(FlappyBird app) {
        super(app, List.of(GameState.values()));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, app.windowWidth, app.windowHeight);

        g.setColor(Color.orange);
        g.fillRect(0, app.windowHeight - 100, app.windowWidth, 100);

        g.setColor(Color.green);
        g.fillRect(0, app.windowHeight - 100, app.windowWidth, 15);
    }


    @Override
    public void checkPosition() {

    }

    @Override
    public void updatePosition() {

    }
}
