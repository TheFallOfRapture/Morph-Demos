package com.morph.game.shooting.entities.powerups;

import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;
import com.morph.engine.graphics.Texture;
import com.morph.game.shooting.entities.components.powerups.JumpBoost;

public class JumpBoostEntity extends EntityRectangle {
	public JumpBoostEntity(float x, float y, Shader<?> shader) {
		super(x, y, 2, 2, new Color(1, 1, 1), shader, new Texture("textures/smallerSpringJump.png"), true);
		addComponent(new JumpBoost(1.5f));
	}
}
