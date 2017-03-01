package com.morph.game.flappybird;

import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;

public class Obstacle extends EntityRectangle {
	public Obstacle(float x, float y, float width, float height, Shader<?> shader) {
		super(x, y, width, height, new Color(0.133f, 1, 0.133f, 1), shader, null, false);
	}
}
