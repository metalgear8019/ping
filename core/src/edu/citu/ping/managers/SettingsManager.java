package edu.citu.ping.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import edu.citu.ping.literals.Constants;
import edu.citu.ping.utils.LabelGenerator;
import edu.citu.ping.utils.TextureGenerator;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class SettingsManager {
    private static SettingsManager INSTANCE;
    private Game game;

    private BitmapFont titleFont;
    private BitmapFont scoreFont;
    private BitmapFont loadingFont;

    private Texture ballTexture;
    private Texture netTexture;
    private Texture paddleTexture; // for classic ping pong
    private Texture snakeHeadTexture;
    private Texture snakeTailTexture;

    private Texture[] particles;

    public SettingsManager(Game g, boolean useDefaultValues) {
        game = g;
        particles = new Texture[3];
        if (useDefaultValues) {
            titleFont = LabelGenerator.getFont(Constants.FONT_LIBERATION_MONO, 50);
            scoreFont = LabelGenerator.getFont(Constants.FONT_LIBERATION_MONO, 55);
            loadingFont = LabelGenerator.getFont(Constants.FONT_LIBERATION_MONO, 30);

            ballTexture = TextureGenerator.generateRectangle(12, 12, Color.WHITE);
            netTexture = TextureGenerator.generateRectangle(2, 2, Color.WHITE);
            paddleTexture = TextureGenerator.generateRectangle(10, 100, Color.WHITE);
            snakeHeadTexture = TextureGenerator.generateBorderedRectangle(10, 10, 3, Color.WHITE, Color.BLACK);
            snakeTailTexture = TextureGenerator.generateRectangle(10, 10, Color.WHITE);

            particles[0] = TextureGenerator.generateRectangle(2, 2, Color.YELLOW);
            particles[1] = TextureGenerator.generateRectangle(3, 3, Color.YELLOW);
            particles[2] = TextureGenerator.generateRectangle(4, 4, Color.ORANGE);
        }
    }

    public static SettingsManager initialize(Game g) {
        return initialize(g, true);
    }

    public static SettingsManager initialize(Game g, boolean useDefaultValues) {
        INSTANCE = new SettingsManager(g, useDefaultValues);
        return INSTANCE;
    }

    public static SettingsManager get() {
        return INSTANCE;
    }

    public SettingsManager setTitleFont(BitmapFont tf) {
        titleFont = tf;
        return this;
    }

    public SettingsManager setScoreFont(BitmapFont sf) {
        scoreFont = sf;
        return this;
    }

    public SettingsManager setLoadingFont(BitmapFont lf) {
        loadingFont = lf;
        return this;
    }

    public SettingsManager setTitleFont(String fontStyle, int fontSize) {
        return setTitleFont(LabelGenerator.getFont(fontStyle, fontSize));
    }

    public SettingsManager setScoreFont(String fontStyle, int fontSize) {
        return setScoreFont(LabelGenerator.getFont(fontStyle, fontSize));
    }

    public SettingsManager setLoadingFont(String fontStyle, int fontSize) {
        return setLoadingFont(LabelGenerator.getFont(fontStyle, fontSize));
    }

    public SettingsManager setBallTexture(Texture bt) {
        ballTexture = bt;
        return this;
    }

    public SettingsManager setNetTexture(Texture nt) {
        netTexture = nt;
        return this;
    }

    public SettingsManager setPaddleTexture(Texture pt) {
        paddleTexture = pt;
        return this;
    }

    public SettingsManager setSnakeHeadTexture(Texture sht) {
        snakeHeadTexture = sht;
        return this;
    }

    public SettingsManager setSnakeTailTexture(Texture stt) {
        snakeTailTexture = stt;
        return this;
    }

    public SettingsManager setParticles(Texture s, Texture m, Texture l) {
        particles[0] = s;
        particles[1] = m;
        particles[2] = l;
        return this;
    }

    public BitmapFont getTitleFont() {
        return titleFont;
    }

    public BitmapFont getScoreFont() {
        return scoreFont;
    }

    public BitmapFont getLoadingFont() {
        return loadingFont;
    }

    public Texture getBallTexture() {
        return ballTexture;
    }

    public Texture getNetTexture() {
        return netTexture;
    }

    public Texture getPaddleTexture() {
        return paddleTexture;
    }

    public Texture getSnakeHeadTexture() {
        return snakeHeadTexture;
    }

    public Texture getSnakeTailTexture() {
        return snakeTailTexture;
    }

    public Texture[] getParticles() {
        return particles;
    }
}
