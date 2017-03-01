package com.morph.game.shooting.controller;

import com.morph.engine.entities.Entity;
import com.morph.engine.math.Vector2f;

public class JumpCommand extends MovementCommand {
	private float jumpHeight;

	public JumpCommand(float jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	@Override
	public Vector2f addMovement(Entity e) {
		// TODO Auto-generated method stub
		return new Vector2f(0, 0);
	}

}
