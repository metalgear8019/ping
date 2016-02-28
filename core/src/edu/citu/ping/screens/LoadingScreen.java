package edu.citu.ping.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import aurelienribon.tweenengine.Tween;
import edu.citu.ping.literals.Constants;
import edu.citu.ping.managers.ScreenManager;
import edu.citu.ping.managers.SettingsManager;
import edu.citu.ping.utils.LabelGenerator;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class LoadingScreen implements BaseScreen {

    private Game game;
    private Stage stage;

    // all actors
    private ProgressBar progressBar; // for loading
    private Table table; // layout actor

    public LoadingScreen(Game g) {
        game = g;
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        progressBar = new ProgressBar(0, 100, 1, false, skin);
        progressBar.setAnimateDuration(1f);
        progressBar.setAnimateInterpolation(Interpolation.sine);
        table.add(LabelGenerator.get(Constants.LBL_LOADING, Color.WHITE, SettingsManager.get().getLoadingFont()));
        table.row();
        table.add(progressBar).left();

        stage.addActor(table);
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
