package com.fate.game.tetris.entities;

import com.fate.engine.core.Game;
import com.fate.engine.core.TileWorld;
import com.fate.engine.entities.Entity;
import com.fate.game.tetris.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Fernando on 2/11/2017.
 */
public class TetrisWorld extends TileWorld {
    private List<Piece> pieces;

    public TetrisWorld(Game game, int width, int height, float tileSize) {
        super(game, width, height, tileSize);
        this.pieces = new ArrayList<>();
    }

    public boolean addPiece(Piece p) {
        pieces.add(p);
        return addEntityGrid(p, p.getX(), p.getY());
    }

    public boolean removePiece(Piece p) {
        pieces.remove(p);
        for (int y = 0; y < p.getHeight(); y++) {
            for (int x = 0; x < p.getWidth(); x++) {
                if (p.getEntity(x, y) != null)
                    if (!removeEntity(x + p.getX(), y + p.getY()))
                        return false;
            }
        }

        return true;
    }

    public boolean translatePiece(Piece p, int dx, int dy) {
        if (!pieces.contains(p))
            return false;

        boolean success = true;
        lazyMoveEntityGrid(p, p.getX() + dx, p.getY() + dy);

        p.translate(dx, dy);

        return success;
    }

    public boolean moveIfValid(Piece p, int dx, int dy) {
        removePiece(p);
        p.translate(dx, dy);
        if (this.areEmpty(p.getBlockLocations())) {
            addPiece(p);
            return true;
        }
        p.translate(-dx, -dy);
        addPiece(p);

        return false;
    }

    public boolean moveIfValid(Piece p, Piece newP) {
        removePiece(p);
        if (this.areEmpty(newP.getBlockLocations())) {
            addPiece(newP);
            return true;
        }
        addPiece(p);

        return false;
    }

    public void moveToBottom(Piece p) {
        removePiece(p);
        while (areEmpty(p.getBlockLocations())) {
            p.translate(0, 1);
        }
        p.translate(0, -1);
        addPiece(p);
    }

    public List<Integer> checkForFilledRows() {
        List<Integer> filledRows = IntStream.range(0, getHeight()).boxed().collect(Collectors.toList());

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if (getEntity(x, y) == null) {
                    filledRows.remove((Integer)y);
                    break;
                }
            }
        }

        return filledRows;
    }

    public List<Integer> checkForEmptyRows() {
        List<Integer> filledRows = IntStream.range(0, getHeight()).boxed().collect(Collectors.toList());

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if (getEntity(x, y) != null) {
                    filledRows.remove((Integer)y);
                    break;
                }
            }
        }

        return filledRows;
    }

    public List<Integer> checkForEmptyRows(int startRow) {
        List<Integer> filledRows = IntStream.range(startRow, getHeight()).boxed().collect(Collectors.toList());

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if (getEntity(x, y) != null) {
                    filledRows.remove((Integer)y);
                    break;
                }
            }
        }

        return filledRows;
    }

    public void clearRow(int row) {
        for (int i = 0; i < getWidth(); i++) {
            removeEntity(i, row);
        }
    }

    public void lowerAllPieces(int offset) {
        for (Entity e : getEntities()) {
            translateEntity(e, 0, offset);
        }
    }

    public void fillEmptyRows() {
        List<Integer> emptyRows = checkForEmptyRows();
        fillEmptyRows(emptyRows);
    }

    public void fillEmptyRows(List<Integer> emptyRows) {
        for (int row : emptyRows) {
            int newRow = row - 1;
            for (int y = newRow; y >= 0; y--) {
                for (int x = 0; x < getWidth(); x++) {
                    if (getEntity(x, y) != null)
                        translateEntity(x, y, 0, 1);
                }
            }
        }

        List<Integer> remaining = checkForEmptyRows(emptyRows.get(0));
        if (remaining.size() != 0)
            fillEmptyRows(remaining);
    }

    public boolean anyFilledColumns() {
        for (int x = 0; x < getWidth(); x++) {
            if (getEntity(x, 0) != null) {
                return true;
            }
        }

        return false;
    }
}
