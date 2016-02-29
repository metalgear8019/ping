package edu.citu.ping.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Back;
import edu.citu.ping.Ping;
import edu.citu.ping.accessors.TableAccessor;
import edu.citu.ping.literals.Constants;
import edu.citu.ping.managers.ScreenManager;
import edu.citu.ping.managers.SettingsManager;
import edu.citu.ping.utils.LabelGenerator;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class LoadingScreen implements BaseScreen {

    private Ping game;
    private Stage stage;

    // all actors
    private ProgressBar progressBar; // for loading
    private Table table; // layout actor

    public LoadingScreen(Ping g) {
        game = g;
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        progressBar = new ProgressBar(0, 100, 1, false, skin);
        progressBar.setAnimateDuration(1f);
        progressBar.setAnimateInterpolation(Interpolation.sine);
        table.add(LabelGenerator.getLabel(Constants.LBL_LOADING, Color.WHITE, SettingsManager.get().getLoadingFont()));
        table.row();
        table.add(progressBar).left();

        stage.addActor(table);
    }

    private boolean isLoadingDone() {
        Gdx.app.debug(this.getClass().getSimpleName(), "Currently checking loading progress...");
        return (game.assets.update()) && (progressBar.getValue() == progressBar.getVisualValue()) && (game.tweens.size() == 0);
    }

    @Override
    public Tween getIntroTween() {
        return null;
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

    }

    @Override
    public void render(float delta) {
        // paint background
        Gdx.gl.glClearColor(0.075f, 0.059f, 0.188f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // update assets & tween movements
        game.assets.update();
        game.tweens.update(delta);

        // redraw progress bar
        float progress = game.assets.getProgress() * 100;
        progressBar.setValue(progress);

        // redraw stage that contains all actors
        stage.act(delta);
        stage.draw();

        if (isLoadingDone()) {
            Gdx.app.debug(this.getClass().getSimpleName(), "Now switching screens...");
            ScreenManager.get().swap(new MainMenuScreen(game));
        }
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
