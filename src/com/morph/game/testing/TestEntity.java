package com.morph.game.testing;

import com.morph.engine.core.Game;
import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;

public class TestEntity extends EntityRectangle {
	public TestEntity(Game game, float x, float y, float width, float height, Color color, Shader<?> shader) {
		super(x, y, width, height, color, shader, null, false);
	}
}
