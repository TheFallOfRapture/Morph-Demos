package com.morph.game.shooting.levels;

import com.morph.engine.entities.Entity;
import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Texture;
import com.morph.game.shooting.graphics.shaders.BasicTexturedShader;

public class TestEntityLevel extends Level {
	public TestEntityLevel() {
		super();
		
		Entity test = new EntityRectangle(20, 0.5f, 40, 10, new Color(1, 1, 1), new BasicTexturedShader(), new Texture("textures/greenBlock.png"), false);
		addEntity(test);
	}
}
