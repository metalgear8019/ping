package edu.citu.ping.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class TextureGenerator {
    public static final int DIVISION_HORIZONTAL = 1;
    public static final int DIVISION_VERTICAL = 2;
    public static final int DIVISION_SLASH_FORWARD = 3;
    public static final int DIVISION_SLASH_BACKWARD = 4;

    public static Texture generateBorderedRectangle(int width, int height, int borderSize, Color main, Color border) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(border);
        pixmap.fill();
        pixmap.setColor(main);
        pixmap.fillRectangle(borderSize, borderSize, width - borderSize, height - borderSize);
        return new Texture(pixmap);
    }

    public static Texture generateSplitRectangle(int width, int height, Color color1, Color color2, int division) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        switch (division) {
            case DIVISION_HORIZONTAL:
                pixmap.setColor(color1);
                pixmap.fillRectangle(0, 0, width, height / 2);
                pixmap.setColor(color2);
                pixmap.fillRectangle(0, height / 2, width, height / 2);
                break;
            case DIVISION_VERTICAL:
                pixmap.setColor(color1);
                pixmap.fillRectangle(0, 0, width / 2, height);
                pixmap.setColor(color2);
                pixmap.fillRectangle(width / 2, 0, width / 2, height);
                break;
            case DIVISION_SLASH_FORWARD:
                pixmap.setColor(color1);
                pixmap.fillTriangle(0, 0, width, 0, 0, height);
                pixmap.setColor(color2);
                pixmap.fillTriangle(width, height, width, 0, 0, height);
                break;
            case DIVISION_SLASH_BACKWARD:
                pixmap.setColor(color1);
                pixmap.fillTriangle(0, 0, width, height, 0, height);
                pixmap.setColor(color2);
                pixmap.fillTriangle(0, 0, width, height, width, 0);
                break;
            default:
                pixmap.setColor(color2);
                pixmap.fill();
        }

        return new Texture(pixmap);
    }

    public static Texture generateRectangle(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        return new Texture(pixmap);
    }
}
