package edu.citu.ping.screens;

import com.badlogic.gdx.Screen;

import aurelienribon.tweenengine.Tween;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public interface BaseScreen extends Screen {
    Tween getIntroTween();
    Tween getOutroTween();
}
