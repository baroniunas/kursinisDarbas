package com.baroniunas.flappybird.GameApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameWorld {
    private final ArrayList<Renderable> objects;

    public GameWorld() {
        objects = new ArrayList<>();
    }

    public void add(Renderable object) {
        objects.add(object);
    }

    public List<Renderable> getObjectsInCurrentGameState() {
        return objects.stream().filter(obj -> obj.existsInStates.contains(obj.app.gameState)).collect(Collectors.toList());
    }
}
