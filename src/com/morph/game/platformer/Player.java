package com.morph.game.platformer;

import com.morph.engine.core.Game;
import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;

public class Player extends EntityRectangle {
	public Player(Game game, int x, int y, int width, int height, Shader shader) {
		super(x, y, width, height, new Color(1, 1, 1, 1), shader, null, false);
	}
}
