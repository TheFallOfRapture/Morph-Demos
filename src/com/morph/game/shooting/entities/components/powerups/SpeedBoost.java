package com.morph.game.shooting.entities.components.powerups;

import com.morph.engine.entities.Entity;
import com.morph.game.shooting.controller.KeyboardController;

public class SpeedBoost extends PowerUp {
	private float speedModifier;
	
	public SpeedBoost(float speedModifier) {
		this.speedModifier = speedModifier;
	}
	
	@Override
	public void onPickup(Entity e) {
		KeyboardController kc = e.getComponent(KeyboardController.class);
		kc.setSpeed(kc.getSpeed() * speedModifier);
	}
	
	public float getSpeedModifier() {
		return speedModifier;
	}
}
