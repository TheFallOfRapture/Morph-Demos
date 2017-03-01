package com.morph.game.shooting.controller;

import com.morph.engine.entities.Entity;
import com.morph.engine.math.Vector2f;

public abstract class MovementCommand {
	public abstract Vector2f addMovement(Entity e);
}
