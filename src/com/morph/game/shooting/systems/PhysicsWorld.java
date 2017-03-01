package com.morph.game.shooting.systems;

import com.morph.engine.core.Game;
import com.morph.engine.core.GameSystem;
import com.morph.engine.entities.Entity;
import com.morph.engine.math.Vector2f;
import com.morph.engine.physics.components.Gravity;
import com.morph.engine.physics.components.Velocity2D;

public class PhysicsWorld extends GameSystem {
	private static final Vector2f GRAVITY = new Vector2f(0, -50f);
	
	public PhysicsWorld(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean acceptEntity(Entity e) {
		return e.hasComponent(Velocity2D.class);
	}
	
	protected void fixedUpdate(Entity e, float dt) {
		Velocity2D vel2D = e.getComponent(Velocity2D.class);

		if (e.hasComponent(Gravity.class))
			vel2D.addVelocity(GRAVITY.scale(dt));
	}

	@Override
	public void initSystem() {
		// TODO Auto-generated method stub
		
	}

}
