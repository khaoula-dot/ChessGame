package io.github.some_example_name.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import io.github.some_example_name.Main;

public class MenuScreen extends ScreenAdapter {
    private final Main game;
    private SpriteBatch batch;
    private BitmapFont font;

    private Rectangle playBtn, optBtn, quitBtn;

    public MenuScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        float w = 260, h = 50;
        float cx = (Gdx.graphics.getWidth() - w) / 2f;
        float top = Gdx.graphics.getHeight() * 0.65f;

        playBtn = new Rectangle(cx, top, w, h);
        optBtn  = new Rectangle(cx, top - 80, w, h);
        quitBtn = new Rectangle(cx, top - 160, w, h);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.12f, 0.12f, 0.16f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.justTouched()) {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY(); // inversion Y
            if (playBtn.contains(x, y)) game.startGame();
            else if (optBtn.contains(x, y)) game.goToOptions();
            else if (quitBtn.contains(x, y)) Gdx.app.exit();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) Gdx.app.exit();

        batch.begin();
        font.getData().setScale(2f);
        font.draw(batch, "CHESS GAME", Gdx.graphics.getWidth()/2f - 90, Gdx.graphics.getHeight()*0.85f);

        font.getData().setScale(1.5f);
        drawButtonText("Jouer", playBtn);
        drawButtonText("Options", optBtn);
        drawButtonText("Quitter", quitBtn);

        font.getData().setScale(1f);
        font.draw(batch, "Clique sur un bouton (ou ESC pour quitter)", 20, 30);
        batch.end();
    }

    private void drawButtonText(String text, Rectangle r) {
        font.draw(batch, "[ " + text + " ]", r.x + 60, r.y + 35);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
