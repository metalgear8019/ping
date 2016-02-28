package edu.citu.ping.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Back;
import edu.citu.ping.Ping;
import edu.citu.ping.accessors.TableAccessor;
import edu.citu.ping.utils.ListenerGenerator;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class SettingsScreen implements BaseScreen {

    private Ping game;
    private Stage stage;

    private Table table;

    public SettingsScreen(Ping g) {
        game = g;
        stage = new Stage(new StretchViewport(Ping.WIDTH, Ping.HEIGHT));
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        /*if (game.musicOn) {
            buttonLabel = "Turn Off Music";
        } else {
            buttonLabel = "Turn On Music";
        }*/

        /*musicSwitchButton = new TextButton(buttonLabel, skin);
        musicSwitchButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button) {
                if (game.musicOn) {
                    game.musicOn = false;
                    musicSwitchButton.setText("Turn On Music");
                    game.musicToPlay.stop();
                } else {
                    game.musicOn = true;
                    musicSwitchButton.setText("Turn Off Music");
                    game.musicToPlay.play();
                }
            }
        });*/

        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(ListenerGenerator.goToScreen(new MainMenuScreen(game)));

        table = new Table();
        table.setFillParent(true);
        /*table.add(musicSwitchButton).width(200).height(75);
        table.row();*/
        table.add(backButton).pad(10).width(200).height(75);

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
