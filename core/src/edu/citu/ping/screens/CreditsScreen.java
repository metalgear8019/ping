package edu.citu.ping.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Back;
import edu.citu.ping.Ping;
import edu.citu.ping.accessors.TableAccessor;
import edu.citu.ping.literals.Constants;
import edu.citu.ping.utils.LabelGenerator;
import edu.citu.ping.utils.ListenerGenerator;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class CreditsScreen implements BaseScreen {

    private Ping game;
    private Stage stage;

    private Table table;

    private TextButton backButton;

    public CreditsScreen(Ping g) {
        game = g;
        stage = new Stage(new StretchViewport(Ping.WIDTH, Ping.HEIGHT));
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        backButton = new TextButton("Back", skin);

        table = new Table();
        table.setFillParent(true);
        table.setX(-800);
        table.add(LabelGenerator.getLabel(Constants.LBL_CREDITS_HEADER, skin));
        for (String s : Constants.LBL_CREDITS_DEVELOPERS) {
            table.row();
            table.add(LabelGenerator.getLabel(s, skin));
        }
        table.row();
        table.add(LabelGenerator.getLabel(" ", skin));
        table.row();
        table.add(LabelGenerator.getLabel(Constants.LBL_CREDITS_SPECIAL_THANKS, skin));
        for (String s : Constants.LBL_CREDITS_SPONSORS) {
            table.row();
            table.add(LabelGenerator.getLabel(s, skin));
        }
        table.row();
        table.add(backButton).width(200).height(75).pad(50);

        stage.addActor(table);
    }

    @Override
    public Tween getIntroTween() {
        return Tween
                .to(table, TableAccessor.POSITION_XY, .8f)
                .targetRelative(800, 0)
                .ease(Back.OUT);
    }

    @Override
    public Tween getOutroTween() {
        return Tween
                .to(table, TableAccessor.POSITION_X, .8f)
                .targetRelative(800)
                .ease(Back.IN);
    }

    @Override
    public void show() {
        backButton.addListener(ListenerGenerator.goToScreen(new MainMenuScreen(game)));
        Gdx.input.setInputProcessor(stage);
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
        stage.dispose();
    }
}
