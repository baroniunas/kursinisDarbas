package com.baroniunas.flappybird.GameApplication.TestGameWorld;

import com.baroniunas.flappybird.GameApplication.GameApplication;
import com.baroniunas.flappybird.GameApplication.GameWorld;
import com.baroniunas.flappybird.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestGetObjectsInCurrentGameState {
    GameWorld world;

    @BeforeEach
    void setUp() {
        world = new GameWorld();
    }

    @Test
    void testReturnsEmptyListIfNoObjectsWereAdded() {
        var returned_objects = world.getObjectsInCurrentGameState();

        var expected_objects = List.of();
        assertEquals(expected_objects, returned_objects);
    }

    @Test
    void testReturnsEmptyListIfNoObjectsMatchCurrentGameState() {
        var app = new GameApplication(0, 0, "", GameState.IN_GAME);
        var obj_a = new RenderableMock(app, List.of(GameState.START_SCREEN));
        var obj_b = new RenderableMock(app, List.of(GameState.GAME_OVER, GameState.START_SCREEN));
        var obj_c = new RenderableMock(app, List.of(GameState.GAME_OVER));
        world.add(obj_a);
        world.add(obj_b);
        world.add(obj_c);

        var returned_objects = world.getObjectsInCurrentGameState();

        var expected_objects = List.of();
        assertEquals(expected_objects, returned_objects);
    }

    @Test
    void testReturnsOnlyObjectsThatMatchCurrentGameState() {
        var app = new GameApplication(0, 0, "", GameState.IN_GAME);
        var obj_a = new RenderableMock(app, List.of(GameState.IN_GAME));
        var obj_b = new RenderableMock(app, List.of(GameState.GAME_OVER, GameState.IN_GAME));
        var obj_c = new RenderableMock(app, List.of(GameState.GAME_OVER));
        world.add(obj_a);
        world.add(obj_b);
        world.add(obj_c);

        var returned_objects = world.getObjectsInCurrentGameState();

        var expected_objects = List.of(obj_a, obj_b);
        assertEquals(expected_objects, returned_objects);
    }
}