package edu.citu.ping.screens;

import aurelienribon.tweenengine.Tween;
import edu.citu.ping.Ping;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class CreditsScreen implements BaseScreen {

    private Ping game;

    public CreditsScreen(Ping g) {
        game = g;
    }

    @Override
    public Tween getIntroTween() {
        return null;
    }

    @Override
    public Tween getOutroTween() {
        return null;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
