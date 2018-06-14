package org.pltw.examples.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import org.pltw.examples.EmuOnTheLoose;
import org.pltw.examples.util.Constants;

import java.util.Arrays;
import java.util.Scanner;


public class LevelLoader {
    public static int[][] load() {
        Scanner scanner = null;
        int[][] arr = new int[Constants.HEIGHT][Constants.WIDTH];

        try {
            scanner = new Scanner(Gdx.files.internal("412floorMap.txt").readString());

            for (int i = 0; i < Constants.HEIGHT; i++) {
                int j = 0;
                for (String str: scanner.nextLine().split(" ")){
                    arr[i][j++] = Integer.parseInt(str);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Gdx.app.error(EmuOnTheLoose.class.getName(), e.getMessage());
        } finally {
            if (scanner != null) scanner.close();
        }
        return arr;
    }

}
