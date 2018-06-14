package org.pltw.examples.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import org.pltw.examples.util.Constants;

/**
 * Created by wdumas on 10/14/2015.
 */
public class WorldModel {

    public Sprite[][] sampleMap =
            new Sprite[Constants.HEIGHT][Constants.WIDTH];
    private float tempSpriteX, tempSpriteY;
    private Sprite tempSprite;

    public WorldModel() {
        initSampleMap();
    }

    private void initSampleMap() {
        for (int i = 0; i < Constants.HEIGHT; i++) { //for each row in the map
            for (int j = 0; j < Constants.WIDTH; j++){ // for each column in the map
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
                        initSampleMap1(i, j);

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

    private void blackFloorTile() {
        tempSprite = new Sprite(Assets.instance.roomTiles.tileBlack);
    }

    private void woodFloorTile(){
        tempSprite = new Sprite(Assets.instance.roomTiles.tileWood);
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

    private void oddRowStripeFloor(int i, int j) {
        if (i % 2 != 0) {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileBlack);
        } else {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileBlue);
        }
    }
    private void oddColStripeFloor(int i, int j) {
        if (j % 2 != 0) {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileBlack);
        } else {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileBlue);
        }
    }

    private void checker(int i, int j) {
        if ((i + j) % 2 == 0) {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileBlack);
        } else {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileBlue);
        }
    }

    private void num8(int i, int j) {
        if ((i + j) % 3 == 0) {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileBlue);
        } else if (((Constants.SAMPLE_MAP_HEIGHT - i) + (Constants.SAMPLE_MAP_WIDTH - j)) % 3 == 0) {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileBlack);
        } else {
            tempSprite = new Sprite(Assets.instance.roomTiles.tileWood);
        }
    }

    private void initSampleMap1(int i, int j) {
        int[][] map = LevelLoader.load();
        if (map[i][j] == 1) {
            woodFloorTile();
        } else {
            blueFloorTile();
        }
    }
}
