package com.morph.game.flash.util;

import com.morph.engine.core.TileWorld;
import com.morph.engine.entities.Entity;
import com.morph.engine.graphics.Texture;
import com.morph.engine.graphics.components.RenderData;
import com.morph.engine.util.EntityGenUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Fernando on 1/19/2017.
 */
public class LevelUtil {
    public static void readLevel(String filename, TileWorld world) {
        String level = readFile(filename);
        char[] chars = level.toCharArray();

        int x = 0;
        int y = 0;
        for (char c : chars) {
            Entity e = EntityGenUtils.createEntityRectangle(1, 1, false);
            switch (c) {
                case 'X':
                    e.getComponent(RenderData.class).setTexture(new Texture("textures/redMan.png"));
                    world.addEntity(e, x, y);
                    x++;
                    break;
                case '4':
                    e.getComponent(RenderData.class).setTexture(new Texture("textures/deadInside.png"));
                    world.addEntity(e, x, y);
                    x++;
                    break;
                case 'H':
                    e.getComponent(RenderData.class).setTexture(new Texture("textures/blueMan.png"));
                    world.addEntity(e, x, y);
                    x++;
                    break;
                case 'e':
                    e.getComponent(RenderData.class).setTexture(new Texture("textures/friendlyBlueMan.png"));
                    world.addEntity(e, x, y);
                    x++;
                    break;
                case 'a':
                    e.getComponent(RenderData.class).setTexture(new Texture("textures/interestingBlueMan.png"));
                    world.addEntity(e, x, y);
                    x++;
                    break;
                case 'd':
                    e.getComponent(RenderData.class).setTexture(new Texture("textures/4Head.png"));
                    world.addEntity(e, x, y);
                    x++;
                    break;
                case ' ':
                    x++;
                    break;
                case '\n':
                    x = 0;
                    y++;
                    break;
            }
        }
    }

    public static String readFile(String filename) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(LevelUtil.class.getClassLoader().getResourceAsStream(filename)));) {
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }
}
