package io.github.some_example_name;

import com.badlogic.gdx.Game;
import io.github.some_example_name.screens.EndScreen;
import io.github.some_example_name.screens.GameScreen;
import io.github.some_example_name.screens.MenuScreen;
import io.github.some_example_name.screens.OptionsScreen;
import io.github.some_example_name.utils.Assets;

public class Main extends Game {
    public Assets assets;

    @Override
    public void create() {
        assets = new Assets();
        assets.load();
        assets.finishLoading();

        setScreen(new MenuScreen(this));
    }

    public void startGame() {
        setScreen(new GameScreen(this));
    }

    public void goToOptions() {
        setScreen(new OptionsScreen(this));
    }

    public void goToMenu() {
        setScreen(new MenuScreen(this));
    }

    public void showEnd(boolean win, int score) {
        setScreen(new EndScreen(this, win, score));
    }

    @Override
    public void dispose() {
        super.dispose();
        if (assets != null) assets.dispose();
    }
}
