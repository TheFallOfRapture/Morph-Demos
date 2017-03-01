package com.fate.game.tetris;

import com.fate.engine.core.Game;
import com.fate.engine.graphics.Color;
import com.fate.engine.graphics.GLRenderingEngine;
import com.fate.engine.input.Keyboard;
import com.fate.engine.math.MatrixUtils;
import com.fate.engine.util.Timer;
import com.fate.game.tetris.entities.TetrisWorld;
import com.fate.game.tetris.pieces.Piece;
import com.fate.game.tetris.pieces.PieceFactory;
import org.lwjgl.glfw.GLFW;

import java.util.List;

/**
 * Created by Fernando on 2/10/2017.
 */
public class TetrisGame extends Game {
    private static final int WIDTH = 10, HEIGHT = 20;
    private static final float TILE_SIZE = 1;
    private static final int WORLD_SIZE = 20;
    private Piece nextPiece;
    private TetrisWorld w;

    private boolean gameLost = false;

    private float dropInterval = 1.0f; // Time in seconds that a piece takes to drop one level
    private Timer dropTimer;

    private int score = 0;

    public TetrisGame(int width, int height, float fps, boolean fullscreen) {
        super(width, height, "Tetris", fps, fullscreen);
        this.world = new TetrisWorld(this, WIDTH, HEIGHT, TILE_SIZE);
    }

    public TetrisWorld getWorld() {
        return (TetrisWorld) world;
    }

    @Override
    public void initGame() {
        renderingEngine.setClearColor(new Color(0.1f, 0.1f, 0.1f, 1));
        float ratio = (float) width / (float) height;
        GLRenderingEngine.setProjectionMatrix(MatrixUtils.getOrthographicProjectionMatrix(WORLD_SIZE, 0, 0, WORLD_SIZE * ratio, -1, 1));
        w = getWorld();
        w.setXOffset(8.33f);

//        EntityGrid[] pieces = new EntityGrid[7];
//        for (int i = 0; i < 7; i++) {
//            Piece p = PieceFactory.getPiece(i);
//            p.setPosition(2, i * 3);
//            w.addPiece(p);
//        }

        nextPiece = PieceFactory.getPiece(PieceFactory.PieceType.RANDOM);
//        nextPiece.setPosition(5, 0);
        w.addPiece(nextPiece);

        dropTimer = new Timer(dropInterval, this::timerTick);
        dropTimer.start();
    }

    @Override
    public void preGameUpdate() {

    }

    @Override
    public void fixedGameUpdate(float dt) {
        dropTimer.step(dt);
    }

    @Override
    public void postGameUpdate() {

    }

    private void timerTick() {
        if (!w.moveIfValid(nextPiece, 0, 1)) {
            nextPiece = PieceFactory.getPiece(PieceFactory.PieceType.RANDOM);
            resolveFilledRows();

            if (w.anyFilledColumns()) {
                System.out.println("You lose! Score: " + score);
                gameLost = true;
                dropTimer.stop();
            } else
                w.addPiece(nextPiece);
        }
    }

    private void resolveFilledRows() {
        List<Integer> filledRows = w.checkForFilledRows();

        if (filledRows.size() > 0) {
            for (int row : filledRows) {
                w.clearRow(row);
            }

            int points = ((50 + ((filledRows.size() - 1) * 10)));
            score += points;
            System.out.println("Scored " + points + " points! New Score: " + score);
            w.fillEmptyRows(filledRows);
        }
    }

    @Override
    public void handleInput() {
        if (Keyboard.isKeyPressed(GLFW.GLFW_KEY_A) && !gameLost) {
            w.moveIfValid(nextPiece, -1, 0);
        }

        if (Keyboard.isKeyPressed(GLFW.GLFW_KEY_D) && !gameLost) {
            w.moveIfValid(nextPiece, 1, 0);
        }

        if (Keyboard.isKeyPressed(GLFW.GLFW_KEY_LEFT) && !gameLost) {
            Piece newPiece = nextPiece.rotateLeft();
            if (w.moveIfValid(nextPiece, newPiece))
                nextPiece = newPiece;
        }

        if (Keyboard.isKeyPressed(GLFW.GLFW_KEY_RIGHT) && !gameLost) {
            Piece newPiece = nextPiece.rotateRight();
            if (w.moveIfValid(nextPiece, newPiece))
                nextPiece = newPiece;
        }

        if (Keyboard.isKeyPressed(GLFW.GLFW_KEY_SPACE) && !gameLost) {
            w.moveToBottom(nextPiece);
        }

        if (Keyboard.isKeyPressed(GLFW.GLFW_KEY_S) && !gameLost) {
            dropInterval = 0.05f;
            dropTimer.setInterval(dropInterval);
        }

        if (Keyboard.isKeyReleased(GLFW.GLFW_KEY_S) && !gameLost) {
            dropInterval = 1.0f;
            dropTimer.setInterval(dropInterval);
        }
    }
}
