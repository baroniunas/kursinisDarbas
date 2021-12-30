package com.baroniunas.flappybird.GameApplication;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Renderer extends JPanel {
    List<Renderable> objects;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (Objects.isNull(objects)) {
            return;
        }
        for (Renderable object : objects) {
            object.updateAndRender(g);
        }
    }

    public void render(List<Renderable> objects) {
        this.objects = objects;
        repaint();
    }
}
