package com.morph.game.flappybird;

import com.morph.engine.collision.components.TriggerComponent;
import com.morph.engine.core.GameSystem;
import com.morph.engine.entities.Entity;

public class ScoreDetectorTriggerSystem extends GameSystem {
	public ScoreDetectorTriggerSystem(FlappyBirdGame game) {
		super(game);
	}
	
	@Override
	protected boolean acceptEntity(Entity e) {
		return e.hasComponent(TriggerComponent.class);
	}
	
	@Override
	public void initSystem() {}
	
	protected void fixedUpdate(Entity e, float dt) {
		TriggerComponent c = e.getComponent(TriggerComponent.class);
		
		if (c.isHandled()) c.getParent().removeComponent(c);
		
		if (c.getParent() instanceof Player && c.getCollidedEntity() instanceof ScoreDetector) {
			System.out.println("GOOD");
			((FlappyBirdGame)game).getWorld().removeEntity(c.getCollidedEntity());
			((FlappyBirdGame)game).incrementScore();
			c.setHandled(true);
		}
	}
}
