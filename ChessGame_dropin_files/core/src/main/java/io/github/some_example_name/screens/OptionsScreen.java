package io.github.some_example_name.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.some_example_name.Main;
import io.github.some_example_name.managers.AudioManager;

public class OptionsScreen extends ScreenAdapter {
    private final Main game;
    private SpriteBatch batch;
    private BitmapFont font;

    public OptionsScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) game.goToMenu();
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) game.goToMenu();

        if (Gdx.input.isKeyJustPressed(Input.Keys.PLUS) || Gdx.input.isKeyJustPressed(Input.Keys.EQUALS)) {
            AudioManager.setVolume(AudioManager.getVolume() + 0.1f);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.MINUS)) {
            AudioManager.setVolume(AudioManager.getVolume() - 0.1f);
        }

        Gdx.gl.glClearColor(0.10f, 0.10f, 0.14f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.getData().setScale(2f);
        font.draw(batch, "OPTIONS", 40, Gdx.graphics.getHeight() - 60);

        font.getData().setScale(1.2f);
        int v = (int)(AudioManager.getVolume() * 100);
        font.draw(batch, "Volume: " + v + "%", 40, Gdx.graphics.getHeight() - 130);
        font.draw(batch, "Appuie sur + pour augmenter, - pour diminuer", 40, Gdx.graphics.getHeight() - 170);
        font.draw(batch, "BACKSPACE ou ESC pour revenir au menu", 40, Gdx.graphics.getHeight() - 210);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
