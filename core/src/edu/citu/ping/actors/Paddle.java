package edu.citu.ping.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import edu.citu.ping.Ping;
import edu.citu.ping.managers.SettingsManager;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class Paddle extends Rectangle {
    // sprite of actor
    private Texture texture;

    // state of actor
    private boolean tweening;

    public Paddle(int xPos) {
        this(SettingsManager.get().getPaddleTexture(), xPos);
    }

    public Paddle(Texture t, int xPos) {
        texture = t;
        tweening = false;

        width = texture.getWidth();
        height = texture.getHeight();
        x = xPos;
        y = (Ping.HEIGHT / 2) - (height / 2);
    }

    public boolean isTweening() {
        return tweening;
    }

    public void setTweening(boolean tweening) {
        this.tweening = tweening;
    }

    public void setCenterY(float posY) {
        this.y = posY - (this.height / 2);
    }

    public float getTop() {
        return this.y + this.height;
    }

    public void setTop(float posY) {
        this.y = posY - this.height;
    }

    public float getCenterY() {
        return y + (height / 2);
    }
}