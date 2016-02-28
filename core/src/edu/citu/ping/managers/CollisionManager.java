package edu.citu.ping.managers;

import com.badlogic.gdx.Game;

import edu.citu.ping.Ping;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class CollisionManager {
    private static CollisionManager INSTANCE;
    private Ping game;

    public CollisionManager(Ping g) {
        game = g;
    }

    public static CollisionManager initialize(Ping g) {
        INSTANCE = new CollisionManager(g);
        return INSTANCE;
    }

    public static CollisionManager get() {
        return INSTANCE;
    }
}
