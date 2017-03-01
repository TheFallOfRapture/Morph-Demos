package com.morph.game.shooting.systems;

import com.morph.engine.core.Game;
import com.morph.engine.core.GameSystem;
import com.morph.engine.entities.Entity;
import com.morph.game.shooting.ShootingGame;
import com.morph.game.shooting.entities.components.Health;

public class HealthSystem extends GameSystem {

	public HealthSystem(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean acceptEntity(Entity e) {
		return e.hasComponent(Health.class);
	}

	@Override
	public void initSystem() {
		// TODO Auto-generated method stub
		
	}
	
	protected void fixedUpdate(Entity e, float dt) {
		Health h = e.getComponent(Health.class);

		if (h.getCurrentHealth() <= 0) {
			((ShootingGame)game).getWorld().removeEntity(e);
		}
	}
}
