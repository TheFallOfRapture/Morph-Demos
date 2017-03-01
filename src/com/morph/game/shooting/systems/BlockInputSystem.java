package com.morph.game.shooting.systems;

import com.morph.engine.collision.components.BoundingBox2D;
import com.morph.engine.core.Game;
import com.morph.engine.core.GameSystem;
import com.morph.engine.entities.Entity;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.GLRenderingEngine;
import com.morph.engine.graphics.components.RenderData;
import com.morph.engine.input.Mouse;
import com.morph.engine.math.Vector2f;
import com.morph.engine.math.Vector4f;
import com.morph.game.shooting.entities.components.Block;

public class BlockInputSystem extends GameSystem {
	public BlockInputSystem(Game game) {
		super(game);
	}
	
	protected void update(Entity e) {
		BoundingBox2D bounds = e.getComponent(BoundingBox2D.class);
		Block block = e.getComponent(Block.class);
		
		Vector2f mousePos = Mouse.getWorldMousePosition();
		
		switch (block.getCurrentStateName()) {
			case "BlockInactive":
				if (mousePos != null && bounds.contains(mousePos)) {
					if (Mouse.isMouseButtonPressed(0)) {
						block.setState("BlockClick");
					} else {
						block.setState("BlockHover");
					}
				}
				break;
			case "BlockHover":
				if (mousePos != null && bounds.contains(mousePos)) {
					if (Mouse.isMouseButtonPressed(0)) {
						block.setState("BlockClick");
					}
				} else {
					block.setState("BlockInactive");
				}
				break;
			case "BlockClick":
				if (!Mouse.isMouseButtonDown(0)) {
					block.setState("BlockDestroy");
				}
				break;
		}
	}

	@Override
	protected boolean acceptEntity(Entity e) {
		return e.hasComponents(Block.class, BoundingBox2D.class);
	}

	@Override
	public void initSystem() {}
}
