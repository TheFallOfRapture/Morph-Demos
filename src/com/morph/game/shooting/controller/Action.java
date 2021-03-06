package com.morph.game.shooting.controller;

import java.util.function.Consumer;

import com.morph.engine.entities.Entity;
import com.morph.engine.math.Vector2f;
import com.morph.engine.physics.components.Velocity2D;

public class Action {
	private Consumer<Entity> behavior;
	private String trigger;
	
	public static final Action TEST_ACTION = new Action("Move Up", e -> {
		Velocity2D v = e.getComponent(Velocity2D.class);
		v.addVelocity(new Vector2f(0, 5f));
	});
	
	public Action(String trigger, Consumer<Entity> behavior) {
		this.trigger = trigger;
		this.behavior = behavior;
	}
	
	public void executeIfMatch(String trigger, Entity e) {
		if (trigger.equals(this.trigger)) {
			behavior.accept(e);
		}
	}
}
