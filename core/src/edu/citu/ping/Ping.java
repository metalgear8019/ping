package edu.citu.ping;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import edu.citu.ping.accessors.CameraAccessor;
import edu.citu.ping.accessors.PaddleAccessor;
import edu.citu.ping.accessors.TableAccessor;
import edu.citu.ping.actors.Paddle;
import edu.citu.ping.literals.Constants;
import edu.citu.ping.managers.ScreenManager;
import edu.citu.ping.managers.SettingsManager;

public class Ping extends Game {
	public SpriteBatch batch;

	// managers
	public ScreenManager screens;
	public AssetManager assets;
	public TweenManager tweens;

	// default dimensions
	public static final int WIDTH=800;
	public static final int HEIGHT=480;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		initialize();
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	private void initialize() {
		setupScreenManager();
		setupTweenManager();
		setupAssetManager();
		setupSettingsManager();
	}

	private void setupScreenManager() {
		screens = ScreenManager.initialize(this);
	}

	private void setupTweenManager() {
		tweens = new TweenManager();
		Tween.registerAccessor(Camera.class, new CameraAccessor());
		Tween.registerAccessor(Table.class, new TableAccessor());
		Tween.registerAccessor(Paddle.class, new PaddleAccessor());
	}

	private void setupAssetManager() {
		assets = new AssetManager();
		assets.load(Constants.ATLAS_TEXTURE, TextureAtlas.class);
		assets.load(Constants.SFX_PING, Sound.class);
		assets.load(Constants.BGM_001, Music.class);
		assets.load(Constants.BGM_002, Music.class);
	}

	private void setupSettingsManager() {
		SettingsManager.initialize(this);
	}
}
