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

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getVelocityX() {
        return xVel;
    }

    public void setVelocityX(float xVel) {
        this.xVel = xVel;
    }

    public void addVelocityX(float xVel) {
        this.xVel += xVel;
    }

    public float getVelocityY() {
        return yVel;
    }

    public void setVelocityY(float yVel) {
        this.yVel = yVel;
    }

    public void addVelocityY(float yVel) {
        this.yVel += yVel;
    }

    public void reverseDirectionX() {
        xVel *= -1;
    }

    public void reverseDirectionY() {
        yVel *= -1;
    }

    public void resetPosition() {
        this.x = Ping.WIDTH / 2;
        this.y = Ping.HEIGHT / 2;
    }

    // TODO: below are copy pasted, to be refactored
    public void resetVelocityX(int direction) {
        xVel = -1 * VELOCITY_DEFAULT * direction;
    }

    public void resetVelocityY(int direction) {
        yVel = -1 * VELOCITY_DEFAULT * direction;
    }

    public float getCombinedVelocity(float delta) {
        double velSquared = Math.pow(xVel, 2) + Math.pow(yVel, 2);
        return (float) Math.sqrt(velSquared) * delta;
    }

    public void moveX(float deltaTime) {
        this.x += this.xVel * deltaTime;
    }

    public void moveY(float deltaTime) {
        this.y -= this.yVel * deltaTime;
    }

    public void dispose() {
        texture.dispose();
    }

    public float getTop() {
        return this.y + this.height;
    }

    public void setTop(float posY) {
        this.y = posY - this.height;
    }

    public void setBottom(float posY) {
        this.y = posY;
    }

    public float getBottom() {
        return getY();
    }

    public float getRight() {
        return this.x + this.width;
    }

    public void setRight(float posX) {
        this.x = posX - this.width;
    }

}
