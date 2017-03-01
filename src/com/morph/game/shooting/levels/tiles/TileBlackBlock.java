package com.morph.game.shooting.levels.tiles;

import com.morph.engine.graphics.Texture;
import com.morph.engine.tiles.Tile;

public class TileBlackBlock extends Tile {
	public TileBlackBlock(int x, int y, float tileSize) {
		super(x, y, tileSize, new Texture("textures/blackBlock.png"), "Black Block");
	}
}
