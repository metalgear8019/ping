package edu.citu.ping.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class LabelGenerator {
    public static Label get(String text, Color color, String fontStyle, int fontSize) {
        return get(text, color, getFont(fontStyle, fontSize));
    }

    public static Label get(String text, Color color, BitmapFont font) {
        return get(text, new Label.LabelStyle(font, color));
    }

    public static Label get(String text, Label.LabelStyle labelStyle) {
        return new Label(text, labelStyle);
    }

    public static BitmapFont getFont(String fontStyle, int fontSize) {
        // setting font size
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = fontSize;

        // setting font style
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontStyle));
        BitmapFont titleFont = generator.generateFont(parameter);
        generator.dispose();

        return titleFont;
    }
}
