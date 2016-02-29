package edu.citu.ping.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by metalgear8019 on 2/28/16.
 */
public class LabelGenerator {
    public static Label getLabel(String text, Color color, String fontStyle, int fontSize) {
        return getLabel(text, color, getFont(fontStyle, fontSize));
    }

    public static Label getLabel(String text, Color color, BitmapFont font) {
        return getLabel(text, new Label.LabelStyle(font, color));
    }

    public static Label getLabel(String text, Label.LabelStyle labelStyle) {
        return new Label(text, labelStyle);
    }

    public static Label getLabel(String text, Skin skin) {
        return new Label(text, skin);
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
