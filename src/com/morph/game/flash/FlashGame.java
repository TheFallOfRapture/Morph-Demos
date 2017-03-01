package com.morph.game.flash;

import com.morph.engine.core.Game;
import com.morph.engine.core.TileWorld;
import com.morph.engine.core.TiledGame;
import com.morph.engine.entities.Entity;
import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.GLRenderingEngine;
import com.morph.engine.graphics.Texture;
import com.morph.engine.graphics.components.RenderData;
import com.morph.engine.input.Keyboard;
import com.morph.engine.math.Matrix4f;
import com.morph.engine.math.MatrixUtils;
import com.morph.engine.math.Vector2f;
import com.morph.engine.util.EntityGenUtils;
import com.morph.game.flash.util.LevelUtil;
import com.morph.game.shooting.levels.tiles.BlockEntity;

import java.util.Random;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Created by Fernando on 1/19/2017.
 */
public class FlashGame extends TiledGame {
    private final float WORLD_SIZE = 50f;
    private Entity testPlayer;

    public FlashGame(int width, int height, float fps, boolean fullscreen) {
        super(width, height, 27, 20, 2.5f, "Flash", fps, fullscreen);
    }

    @Override
    public void initGame() {
        renderingEngine.setClearColor(new Color(0, 0, 0, 0));
        float ratio = (float) width / (float) height;
        GLRenderingEngine.setProjectionMatrix(MatrixUtils.getOrthographicProjectionMatrix(WORLD_SIZE, 0, 0, WORLD_SIZE * ratio, -1, 1));

        TileWorld w = getWorld();

        System.out.println(LevelUtil.readFile("./levels/testLevel.txt"));

        LevelUtil.readLevel("levels/testLevel.txt", w);

//        for (int i = 0; i < 27; i++) {
//            for (int j = 0; j < 20; j++) {
//                Entity e = EntityGenUtils.createEntityRectangle(1, 1, false);
//                String tex = "textures/lightHorizontal.png";
//
//                if (i == 0) {
//                    if (j == 0) {
//                        tex = "textures/lightCornerBL.png";
//                    } else if (j == 19) {
//                        tex = "textures/lightCornerTL.png";
//                    } else {
//                        tex = "textures/lightVertical.png";
//                    }
//                }
//
//                if (i == 26) {
//                    if (j == 0) {
//                        tex = "textures/lightCornerBR.png";
//                    } else if (j == 19) {
//                        tex = "textures/lightCornerTR.png";
//                    } else {
//                        tex = "textures/lightVertical.png";
//                    }
//                }
//
//                if (i != 0 && i != 26 && j != 0 && j != 19)
//                    tex = "textures/lightHorizontal.png";
//
//                e.getComponent(RenderData.class).setTexture(new Texture(tex));
//                w.addEntity(e, i, j);
//            }
//        }
//                w.addEntity(new BlockEntity(new Vector2f(0, 0), 1, new Color((float)Math.random(), (float)Math.random(), (float)Math.random()), false), i, j);

        testPlayer = new BlockEntity(new Vector2f(0, 0), 1, new Color(0, 0, 1), false);
        w.addEntity(testPlayer, 0, 0);
    }

    @Override
    public void preGameUpdate() {

    }

    @Override
    public void fixedGameUpdate(float dt) {

    }

    @Override
    public void postGameUpdate() {

    }

    @Override
    public void handleInput() {
        TileWorld w = getWorld();

        if (Keyboard.isKeyPressed(GLFW_KEY_W)) {
            w.translateEntity(testPlayer, 0, 1);
        }

        if (Keyboard.isKeyPressed(GLFW_KEY_S)) {
            w.translateEntity(testPlayer, 0, -1);
        }
        if (Keyboard.isKeyPressed(GLFW_KEY_A)) {
            w.translateEntity(testPlayer, -1, 0);
        }

        if (Keyboard.isKeyPressed(GLFW_KEY_D)) {
            w.translateEntity(testPlayer, 1, 0);
        }

    }
}
