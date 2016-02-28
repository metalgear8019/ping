package edu.citu.ping.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Back;
import edu.citu.ping.Ping;
import edu.citu.ping.accessors.TableAccessor;
import edu.citu.ping.managers.SettingsManager;
import edu.citu.ping.utils.LabelGenerator;
import edu.citu.ping.utils.ListenerGenerator;

/**
 * Created by metalgear8019 on 2/29/16.
 */
public class GameEndScreen implements BaseScreen {

    private Ping game;
    private Stage stage;

    private Table table;

    public GameEndScreen(Ping g) {
        game = g;
        stage = new Stage(new StretchViewport(Ping.WIDTH, Ping.HEIGHT));
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        TextButton menuButton = new TextButton("Main Menu", skin);
        menuButton.addListener(ListenerGenerator.goToScreen(new MainMenuScreen(game)));

        Label player1ScoreLabel = new Label(
                "Ping Total Wins: " + String.valueOf(game.states.p1.getScore()), skin);
        Label player2ScoreLabel = new Label(
                "Pong Total Wins: " + String.valueOf(game.states.p2.getScore()), skin);

        table = new Table();
        table.setFillParent(true);
        table.setX(-800);
        table.add(LabelGenerator.get(game.states.winner.name, Color.WHITE, SettingsManager.get().getTitleFont()));
        table.row();
        table.add(player1ScoreLabel);
        table.row();
        table.add(player2ScoreLabel);
        table.row();
        table.add(menuButton).pad(20).width(200).height(75);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.075f, 0.059f, 0.188f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.tweens.update(delta);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        // game.musicToPlay.stop();
    }

    @Override
    public Tween getIntroTween() {
        return Tween.to(table, TableAccessor.POSITION_XY, .8f)
                .targetRelative(800, 0)
                .ease(Back.OUT);
    }

    @Override
    public Tween getOutroTween() {
        return Tween.to(table, TableAccessor.POSITION_X, .8f)
                .targetRelative(800)
                .ease(Back.IN);
    }
}