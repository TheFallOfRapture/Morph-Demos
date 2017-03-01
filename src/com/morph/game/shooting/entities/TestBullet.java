package com.morph.game.shooting.entities;

import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;
import com.morph.engine.graphics.Texture;
import com.morph.engine.physics.components.Velocity2D;

public class TestBullet extends EntityRectangle {
	public TestBullet(float x, float y, Shader<?> shader) {
		super(x, y, 0.5f, 0.5f, new Color(1, 1, 1), shader, new Texture("textures/testTexture.png"), false);
		addComponent(new Velocity2D());
	}
}
