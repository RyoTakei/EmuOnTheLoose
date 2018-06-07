package org.pltw.examples.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import org.pltw.examples.util.Constants;

/**
 * Project Lead The Way, 2016.
 */
public class WorldModel {

    public Sprite[][] sampleMap =
            new Sprite[Constants.SAMPLE_MAP_HEIGHT][Constants.SAMPLE_MAP_WIDTH];
    private float tempSpriteX, tempSpriteY;
    private Sprite tempSprite;

    public WorldModel() {
        initSampleMap();
    }

    private void initSampleMap() {
        for (int i = 0; i < Constants.SAMPLE_MAP_HEIGHT; i++) { //for each row in the map
            for (int j = 0; j < Constants.SAMPLE_MAP_WIDTH; j++){ // for each column in the map
                if (i != j || i != 0) {
                    tempSpriteX = 0-i*Constants.X_PADDING_TO_NEXT_TILE +
                            j*Constants.X_PADDING_TO_NEXT_TILE;
                    // Case: i or j indicate a wall sprite (value of 0)
                    if (i == Constants.WALL_ROW || j == Constants.WALL_COL) {
                        setupWallSprite(i, j);
                    }
                    // Case: i and j are both non-0 indicates a floor tile sprite
                    else {
                        /* ToDo add conditionals, methods, and method calls like the one below
                        per the instructions in Part IV of Activity 4.1.1 */
                        blueFloorTile();

                        tempSprite.setSize(Constants.TILE_WIDTH, Constants.TILE_HEIGHT);
                        tempSpriteY = -0.0f-i*Constants.Y_PADDING_TO_NEXT_TILE -
                                j*Constants.Y_PADDING_TO_NEXT_TILE;
                    }

                    tempSprite.setPosition(tempSpriteX,tempSpriteY);
                    sampleMap[i][j] = tempSprite;
                }
            }
        }
    }

    private void blueFloorTile() {
        tempSprite = new Sprite(Assets.instance.roomTiles.tileBlue);
    }

    private void setupWallSprite(int i, int j){
            tempSprite = new Sprite(Assets.instance.roomTiles.wall1Blank);

            // Right side wall sprites must be flipped
            if (i == Constants.WALL_ROW) {
                tempSprite.flip(true, false); // flip along the Y axis
                tempSpriteY = - j*Constants.Y_PADDING_TO_NEXT_TILE;
            }
            else {
                tempSpriteX = tempSpriteX + Constants.WALL_TILE_WIDTH;
                tempSpriteY = -i*Constants.Y_PADDING_TO_NEXT_TILE +
                        j*Constants.Y_PADDING_TO_NEXT_TILE;
            }

            tempSprite.setSize(Constants.WALL_TILE_WIDTH, Constants.WALL_TILE_HEIGHT);
    }

}
