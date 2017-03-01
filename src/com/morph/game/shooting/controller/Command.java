package com.morph.game.shooting.controller;

import com.morph.engine.entities.Entity;

@FunctionalInterface
public interface Command {
	void execute(Entity e);
}
