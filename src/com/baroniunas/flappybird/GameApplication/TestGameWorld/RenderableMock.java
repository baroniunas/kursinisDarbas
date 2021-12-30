package com.baroniunas.flappybird.GameApplication.TestGameWorld;

import com.baroniunas.flappybird.GameApplication.GameApplication;
import com.baroniunas.flappybird.GameApplication.Renderable;
import com.baroniunas.flappybird.GameState;

import java.awt.*;
import java.util.List;

public class RenderableMock extends Renderable {
    public RenderableMock(GameApplication app, List<GameState> existsInStates) {
        super(app, existsInStates);
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public void checkPosition() {
    }

    @Override
    public void updatePosition() {
    }
}
