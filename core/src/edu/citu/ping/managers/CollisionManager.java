package edu.citu.ping.managers;

import com.badlogic.gdx.Game;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class CollisionManager {
    private static CollisionManager INSTANCE;
    private Game game;

    public CollisionManager(Game g) {
        game = g;
    }

    public static CollisionManager initialize(Game g) {
        INSTANCE = new CollisionManager(g);
        return INSTANCE;
    }

    public static CollisionManager get() {
        return INSTANCE;
    }
}
