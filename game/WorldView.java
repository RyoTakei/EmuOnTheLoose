/**
 * Project Lead The Way, 2016.
 */

package org.pltw.examples.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import org.pltw.examples.util.Constants;

public class WorldView implements Disposable {

	private static final String TAG = WorldView.class.getName();

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;
    private WorldModel worldModel;

	public WorldView(WorldController worldController, WorldModel worldModel) {
		this.worldController = worldController;
        this.worldModel = worldModel;
		init();
	}

	private void init () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		camera.position.set(0, 0, 0);
		camera.update();
	}

	public void render () {
		renderTestObjects();
	}

	private void renderTestObjects () {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
        for (int i = 0; i < Constants.SAMPLE_MAP_HEIGHT; i++){
            for (int j = 0; j < Constants.SAMPLE_MAP_WIDTH; j++) {
                if (worldModel.sampleMap[i][j] != null) {
                    worldModel.sampleMap[i][j].draw(batch);
                }
            }
        }
		batch.end();
	}

	public void resize (int width, int height) {
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
		camera.update();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

}
