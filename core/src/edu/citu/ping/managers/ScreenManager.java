package edu.citu.ping.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import edu.citu.ping.Ping;
import edu.citu.ping.screens.BaseScreen;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class ScreenManager {
    private static ScreenManager INSTANCE;
    private Ping game;

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
     * @param nextScreen
     * @return this
     */
    public ScreenManager swap(final BaseScreen nextScreen) {

        game.getScreen().getOutroTween().setCallback(new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                game.getScreen().dispose();
                game.setScreen(nextScreen);

                nextScreen.getIntroTween().start(game.tweens);
            }
        }).start(game.tweens);

        return this;
    }

    public Screen peek() {
        return game.getScreen();
    }
}
