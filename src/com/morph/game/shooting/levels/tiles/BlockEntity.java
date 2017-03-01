package com.morph.game.shooting.levels.tiles;

import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Texture;
import com.morph.engine.math.Vector2f;
import com.morph.game.shooting.entities.components.Block;
import com.morph.game.shooting.entities.components.Health;
import com.morph.game.shooting.graphics.shaders.BasicTexturedShader;

public class BlockEntity extends EntityRectangle {
	public BlockEntity(Vector2f position, float size, Color color, boolean isTrigger) {
		super(position, new Vector2f(size, size), color, new BasicTexturedShader(), new Texture("textures/tileUnlit.png"), isTrigger);
		addComponent(new Block(color, new Color(0, 1, 0), new Color(1, 0, 0)));
		addComponent(new Health(100));
	}
}
