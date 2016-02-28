package edu.citu.ping.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import javax.xml.soap.Text;

import edu.citu.ping.Ping;
import edu.citu.ping.managers.SettingsManager;
import edu.citu.ping.utils.TextureGenerator;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class Ball extends Rectangle {
    // sprite of actor
    private Texture texture;

    // velocity of actor
    private float xVel;
    private float yVel;

    // actor defaults
    public static final float VELOCITY_DEFAULT = -200f; // goes to the left or up

    public Ball() {
        this(VELOCITY_DEFAULT, VELOCITY_DEFAULT);
    }

    public Ball(Texture t) {
        this(t, VELOCITY_DEFAULT, VELOCITY_DEFAULT);
    }

    public Ball(float xv, float yv) {
        this(SettingsManager.get().getBallTexture(), xv, yv);
    }

    public Ball(Texture t, float xv, float yv) {
        texture = t;
        width = t.getWidth();
        height = t.getHeight();
        xVel = xv;
        yVel = yv;
        resetPosition();
    }

    public void resetPosition() {
        this.x = Ping.WIDTH / 2;
        this.y = Ping.HEIGHT / 2;
    }
}
