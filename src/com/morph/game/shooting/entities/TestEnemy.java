package com.morph.game.shooting.entities;

import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;
import com.morph.engine.graphics.Texture;
import com.morph.engine.physics.components.Velocity2D;

public class TestEnemy extends EntityRectangle {
	public TestEnemy(float x, float y, float width, float height, Color color, Shader<?> shader) {
		super(x, y, width, height, color, shader, new Texture("textures/4Head.png"), false);
		addComponent(new Velocity2D());
	}
}
