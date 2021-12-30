package com.baroniunas.flappybird.GameApplication;

import com.baroniunas.flappybird.GameState;

public class GameApplication {
    public final int windowWidth, windowHeight;
    public final String windowTitle;
    public GameState gameState;
    public int score = 0;
    protected GameWorld world;

    public GameApplication(int windowWidth, int windowHeight, String windowTitle, GameState initialState) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.windowTitle = windowTitle;
        this.gameState = initialState;
        world = new GameWorld();
    }

    public void startNewGame() {
        this.gameState = GameState.IN_GAME;
        score = 0;
    }

    public void gameOver() {
        this.gameState = GameState.GAME_OVER;
    }
}
