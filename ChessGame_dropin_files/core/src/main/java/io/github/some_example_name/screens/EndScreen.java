package io.github.some_example_name.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.some_example_name.Main;

public class EndScreen extends ScreenAdapter {
    private final Main game;
    private final boolean win;
    private final int score;

    private SpriteBatch batch;
    private BitmapFont font;

    public EndScreen(Main game, boolean win, int score) {
        this.game = game;
        this.win = win;
        this.score = score;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) game.startGame();
        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) game.goToMenu();

        Gdx.gl.glClearColor(0.10f, 0.10f, 0.14f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.getData().setScale(2f);
        font.draw(batch, win ? "TU AS GAGNE !" : "TU AS PERDU !", 60, Gdx.graphics.getHeight() * 0.70f);

        font.getData().setScale(1.4f);
        font.draw(batch, "Score: " + score, 60, Gdx.graphics.getHeight() * 0.60f);

        font.getData().setScale(1.1f);
        font.draw(batch, "ENTER = rejouer", 60, Gdx.graphics.getHeight() * 0.45f);
        font.draw(batch, "M = menu", 60, Gdx.graphics.getHeight() * 0.40f);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
