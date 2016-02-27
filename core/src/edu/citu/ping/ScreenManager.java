package edu.citu.ping;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class ScreenManager {
    private static ScreenManager INSTANCE;
    private Game game;

    public interface Callback {
        public void onSwitch(Game g, Screen nextScreen);
        public void onSwitchFinish(Game g, Screen nextScreen);
    }

    public ScreenManager(Game g) {
        game = g;
    }

    public static void initialize(Game g) {
        INSTANCE = new ScreenManager(g);
    }

    public static ScreenManager get() {
        return INSTANCE;
    }

    public ScreenManager setScreen(final Callback callback, Screen nextScreen) {
        callback.onSwitch(game, nextScreen);
        game.getScreen().dispose();
        game.setScreen(nextScreen);
        callback.onSwitchFinish(game, nextScreen);
        return INSTANCE;
    }

    public Screen getScreen() {
        return INSTANCE.getScreen();
    }
}
