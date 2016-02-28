package edu.citu.ping.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import edu.citu.ping.managers.ScreenManager;
import edu.citu.ping.screens.BaseScreen;

/**
 * Created by metalgear8019 on 2/29/16.
 */
public class ListenerGenerator {
    public static ClickListener goToScreen(final BaseScreen nextScreen) {
        return new ClickListener() {
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button) {
                Gdx.app.debug(nextScreen.getClass().getSimpleName(), "Switching screen on touch up");
                Gdx.input.setInputProcessor(null);
                ScreenManager.get().swap(nextScreen);
            }
        };
    }
}
