package edu.citu.ping.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
import edu.citu.ping.actors.Ball;
import edu.citu.ping.actors.ParticleEmitter;
import edu.citu.ping.managers.ScreenManager;
import edu.citu.ping.managers.SettingsManager;
import edu.citu.ping.utils.LabelGenerator;
import edu.citu.ping.utils.ListenerGenerator;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class MainMenuScreen implements BaseScreen {

    private Ping game;
    private Stage stage;

    // actors
    private Ball ball;
    private Table table;
    private ParticleEmitter particleEmitter;

    public MainMenuScreen(Ping g) {
        game = g;
        particleEmitter = new ParticleEmitter();

        stage = new Stage(new StretchViewport(Ping.WIDTH, Ping.HEIGHT));
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        TextButton textButton = new TextButton("2-Player \n First to Five", skin);
        TextButton settingsButton = new TextButton("Settings", skin);
        TextButton creditsButton = new TextButton("Credits", skin);

        textButton.addListener(ListenerGenerator.goToScreen(new GameScreen(game)));
        // settingsButton.addListener(ListenerGenerator.goToScreen(new SettingsScreen(game)));
        // creditsButton.addListener(ListenerGenerator.goToScreen(new CreditsScreen(game)));

        table = new Table();
        table.setFillParent(true);
        table.setX(-800f);
        table.add(LabelGenerator.get("PING!", Color.WHITE, SettingsManager.get().getTitleFont())).pad(30);
        table.row();
        table.add(textButton).width(200).height(75);
        table.row();
        table.add(settingsButton).width(200).height(75);
        table.row();
        table.add(creditsButton).width(200).height(75);

        stage.addActor(table);
    }

    @Override
    public Tween getIntroTween() {
        return Tween
                .to(table, TableAccessor.POSITION_XY, .8f)
                .targetRelative(800, 0)
                .ease(Back.OUT)
                .setCallback(new TweenCallback() {
                    @Override
                    public void onEvent(int type, BaseTween<?> source) {
                        ball = new Ball();
                        particleEmitter.setState("emit");
                    }
                });
    }

    @Override
    public Tween getOutroTween() {
        return Tween.to(table, TableAccessor.POSITION_X, .8f)
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

        normalUpdate(delta);
    }

    private void normalUpdate(float delta) {
        game.tweens.update(delta);
        updateBallMovement(delta);
        particleEmitter.update(ball, delta);
        stage.act(delta);
        batchDraw();
        stage.draw();
    }

    private void updateBallMovement(float deltaTime) {
        if (!(ball == null)) {
            ball.moveX(deltaTime);
            checkForWallCollision();
            ball.moveY(deltaTime);
            checkForCeilingCollision();
        }
    }

    private void batchDraw() {
        game.batch.setProjectionMatrix(stage.getCamera().combined);
        game.batch.begin();
        particleEmitter.drawParticles(game.batch);
        if (!(ball == null)) {
            game.batch.draw(ball.getTexture(), ball.x, ball.y);
        }
        game.batch.end();
    }

    private void checkForCeilingCollision() {
        if (ball.getTop() > Ping.HEIGHT) {
            ball.reverseDirectionY();
            ball.setTop(Ping.HEIGHT);
        } else if (ball.getBottom() < 0) {
            ball.reverseDirectionY();
            ball.setBottom(0f);
        }
    }

    private void checkForWallCollision() {
        if (ball.getRight() > Ping.WIDTH) {
            ball.reverseDirectionX();
            ball.setRight(Ping.WIDTH);
        } else if (ball.getX() < 0) {
            ball.reverseDirectionX();
            ball.setX(0);
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
