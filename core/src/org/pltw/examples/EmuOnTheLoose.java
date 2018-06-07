package org.pltw.examples;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import org.pltw.examples.game.WorldController;
import org.pltw.examples.game.WorldModel;
import org.pltw.examples.game.WorldView;
import com.badlogic.gdx.assets.AssetManager;
import org.pltw.examples.game.Assets;

public class EmuOnTheLoose implements ApplicationListener {

    private static final String TAG = EmuOnTheLoose.class.getName();

    private WorldController worldController;
    private WorldView worldView;
    private WorldModel worldModel;

    private boolean paused;

    @Override
    public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Assets.instance.init(new AssetManager());
        worldController = new WorldController();
        worldModel = new WorldModel();
        worldView = new WorldView(worldController, worldModel);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0x95 / 255.0f, 0x95 / 255.0f, 0x95 / 255.0f, 0xff / 255.0f); //grey
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen
        worldView.render();
    }

    @Override
    public void resize (int width, int height) {
        worldView.resize(width, height);
    }

    @Override
    public void pause () {
        paused = true;
    }

    @Override
    public void resume () {
        paused = false;
    }

    @Override
    public void dispose () {
        worldView.dispose();
        Assets.instance.dispose();
    }

}
