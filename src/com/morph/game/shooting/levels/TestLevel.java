package com.morph.game.shooting.levels;

import com.morph.engine.core.Game;
import com.morph.game.shooting.entities.powerups.SpeedBoostEntity;
import com.morph.game.shooting.entities.powerups.JumpBoostEntity;
import com.morph.game.shooting.graphics.shaders.BasicTexturedShader;
import com.morph.game.shooting.levels.tiles.TileBlueBlock;
import com.morph.game.shooting.levels.tiles.TileGreenBlock;
import com.morph.game.shooting.levels.tiles.TileRedBlock;

public class TestLevel extends PlatformerLevel {
	private static int width = 40;
	private static int height = 30;
	
	public TestLevel(Game game) {
		super(game, 1f, width, height, new BasicTexturedShader());
		
		for (int i = 0; i < width; i++) {
			setTile(new TileBlueBlock(i, 0, tilemap.getTileSize()));
			setTile(new TileBlueBlock(i, height - 1, tilemap.getTileSize()));
		}
		
		for (int i = 0; i < height; i++) {
			setTile(new TileRedBlock(0, i, tilemap.getTileSize()));
			setTile(new TileRedBlock(width - 1, i, tilemap.getTileSize()));
		}
		
		setTile(new TileGreenBlock(0, 0, tilemap.getTileSize()));
		setTile(new TileGreenBlock(width - 1, 0, tilemap.getTileSize()));
		setTile(new TileGreenBlock(width - 1, height - 1, tilemap.getTileSize()));
		setTile(new TileGreenBlock(0, height - 1, tilemap.getTileSize()));
		
		addEntity(new SpeedBoostEntity(25, 5, shader));
		addEntity(new JumpBoostEntity(5, 25, shader));
	}
}
