package com.morph.game.flappybird;

import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;
import com.morph.engine.math.Vector2f;
import com.morph.engine.physics.components.RigidBody;

public class Player extends EntityRectangle {
	public Player(int x, int y, int width, int height, Color color, float mass, Shader<?> shader) {
		super(x, y, width, height, color, shader, null, false);
		addComponent(new RigidBody(mass));
	}
	
	/**
	 * Bounces vertically upward.
	 * @param dt the time step
	 */
	public void bounce(float j, float dt) {
		RigidBody rigidBody = getComponent(RigidBody.class);
		
		if (rigidBody.getVelocity().getY() < 0)
			rigidBody.applyImpulse(rigidBody.getVelocity().scale(-1 * rigidBody.getMass()), dt);
		
		rigidBody.applyImpulse(new Vector2f(0, j), dt);
	}
}
