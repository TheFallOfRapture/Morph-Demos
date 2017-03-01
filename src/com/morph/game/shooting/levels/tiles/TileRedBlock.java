package com.morph.game.shooting.levels.tiles;

import com.morph.engine.graphics.Texture;
import com.morph.engine.tiles.Tile;

public class TileRedBlock extends Tile {

	public TileRedBlock(int x, int y, float tileSize) {
		super(x, y, tileSize, new Texture("textures/redBlock.png"), "TileRedBlock");
	}

}
