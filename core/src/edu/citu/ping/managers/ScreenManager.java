package edu.citu.ping.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import edu.citu.ping.Ping;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class ScreenManager {
    private static ScreenManager INSTANCE;
    private Ping game;

    public interface Callback {
        public void onSwap(Game g, Screen nextScreen);
        public void onSwapFinish(Game g, Screen nextScreen);
    }

    public ScreenManager(Ping g) {
        game = g;
    }

    public static ScreenManager initialize(Ping g) {
        INSTANCE = new ScreenManager(g);
        return INSTANCE;
    }

    public static ScreenManager get() {
        return INSTANCE;
    }

    /**
     * Switches current screen to another screen
     * Automatically plays getOutroTween() of current & getIntroTween() of next
     * @param callback
     * @param nextScreen
     * @return this
     */
    public ScreenManager swap(final Callback callback, Screen nextScreen) {
        callback.onSwap(game, nextScreen);
        game.getScreen().dispose();
        game.setScreen(nextScreen);
        callback.onSwapFinish(game, nextScreen);
        return this;
    }

    public Screen peek() {
        return game.getScreen();
    }
}
