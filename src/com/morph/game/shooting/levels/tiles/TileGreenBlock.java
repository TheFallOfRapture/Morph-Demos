package com.morph.game.shooting.levels.tiles;

import com.morph.engine.graphics.Texture;
import com.morph.engine.tiles.Tile;

public class TileGreenBlock extends Tile {
	public TileGreenBlock(int x, int y, float tileSize) {
		super(x, y, tileSize, new Texture("textures/greenBlock.png"), "TileGreenBlock");
	}
}
