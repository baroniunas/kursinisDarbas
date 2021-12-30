package com.baroniunas.flappybird.GameApplication;

import com.baroniunas.flappybird.GameState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameUIApplication extends GameApplication implements ActionListener, MouseListener {
    private final Renderer renderer;

    public GameUIApplication(int windowWidth, int windowHeight, String windowTitle, GameState initialState) {
        super(windowWidth, windowHeight, windowTitle, initialState);
        JFrame jFrameWindow = new JFrame();
        int DELAY_MS = 20;
        Timer timer = new Timer(DELAY_MS, this);
        renderer = new Renderer();
        jFrameWindow.add(renderer);
        jFrameWindow.setTitle(windowTitle);
        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameWindow.setSize(this.windowWidth, this.windowHeight);
        jFrameWindow.setResizable(false);
        jFrameWindow.setVisible(true);
        jFrameWindow.addMouseListener(this);
        timer.start();
    }

    public static void main(String[] args) {
        new GameUIApplication(400, 400, "UI Application", GameState.START_SCREEN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.render(world.getObjectsInCurrentGameState());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
