package com.baroniunas.flappybird.GameApplication;

import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.List;


public abstract class Renderable {
    public final GameApplication app;
    public final List<GameState> existsInStates;

    public Renderable(GameApplication app, List<GameState> existsInStates) {
        this.app = app;
        this.existsInStates = existsInStates;
    }

    public abstract void updatePosition();

    public abstract void checkPosition();

    public abstract void render(Graphics g);

    public final void updateAndRender(Graphics g) {
        // Template (Behavioral Design Pattern)
        updatePosition();
        checkPosition();
        render(g);
    }
}
