/**
 * Project Lead The Way, 2016.
 */

package org.pltw.examples.game;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import org.pltw.examples.util.Constants;

public class WorldController extends InputAdapter {

	private static final String TAG = WorldController.class.getName();

	public WorldController () {
		init();
	}

	private void init () {
		Gdx.input.setInputProcessor(this);
	}

}
