/*******************************************************************************
 * Copyright 2013 Andreas Oehlke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

/**
 * Project Lead The Way, 2016.
 */

package org.pltw.examples.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

import org.pltw.examples.util.Constants;

public class Assets implements Disposable, AssetErrorListener {

	public static final String TAG = Assets.class.getName();

	public static final Assets instance = new Assets();
    public AssetRoomTiles roomTiles;

	private AssetManager assetManager;

	// singleton
	private Assets() {
	}

    public class AssetRoomTiles {
        public final AtlasRegion tileBlue;
        public final AtlasRegion wall1Blank;
        public final AtlasRegion wall1Window;
        public final AtlasRegion tileBlack;
        public final AtlasRegion wall2Blank;
        // ToDo Add more AtlasRegions per Activity 4.1.1 Part IV

        public AssetRoomTiles (TextureAtlas atlas) {
            tileBlue = atlas.findRegion("tileBlue");
            wall1Blank = atlas.findRegion("wall1Blank");
            wall1Window = atlas.findRegion("wall1Window");
            tileBlack = atlas.findRegion("tileBlack");
            wall2Blank = atlas.findRegion("wall2Blank");
            // ToDo Initialize AtlasRegions from atlas per Activity 4.1.1 Part IV
        }
    }

	public void init (AssetManager assetManager) {
		this.assetManager = assetManager;
		assetManager.setErrorListener(this);
		assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
		assetManager.finishLoading();

		Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
		for (String a : assetManager.getAssetNames()) {
			Gdx.app.debug(TAG, "asset: " + a);
		}

		TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);

		for (Texture t : atlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}

        roomTiles = new AssetRoomTiles(atlas);
	}

	@Override
	public void dispose () {
		assetManager.dispose();

	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", (Exception)throwable);
		
	}

}
