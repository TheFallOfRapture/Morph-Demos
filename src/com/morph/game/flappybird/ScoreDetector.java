package com.morph.game.flappybird;

import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;
import com.morph.engine.graphics.components.RenderData;

public class ScoreDetector extends EntityRectangle {
	public ScoreDetector(FlappyBirdGame game, float x, float y, float width, float height, Shader<?> shader) {
		super(x, y, width, height, new Color(0, 0, 0, 1), shader, null, true);
		this.clearComponents(RenderData.class);
	}
}
