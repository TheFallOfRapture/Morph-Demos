package com.morph.game.shooting.entities.powerups;

import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;
import com.morph.engine.graphics.Texture;
import com.morph.game.shooting.entities.components.powerups.SpeedBoost;

public class SpeedBoostEntity extends EntityRectangle {
	public SpeedBoostEntity(float x, float y, Shader<?> shader) {
		super(x, y, 3, 3, new Color(1, 1, 1), shader, new Texture("textures/lightningSpeed.png"), true);
		addComponent(new SpeedBoost(2));
	}
}
