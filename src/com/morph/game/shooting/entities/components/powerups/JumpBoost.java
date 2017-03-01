package com.morph.game.shooting.entities.components.powerups;

import com.morph.engine.entities.Entity;
import com.morph.game.shooting.controller.KeyboardController;

public class JumpBoost extends PowerUp {
	private float jumpModifier;
	
	public JumpBoost(float jumpModifier) {
		this.jumpModifier = jumpModifier;
	}
	
	@Override
	public void onPickup(Entity e) {
		KeyboardController kc = e.getComponent(KeyboardController.class);
		float jump = kc.getJumpHeight();
		kc.setJumpHeight(jump * jumpModifier);
	}
	
	public float getJumpModifier() {
		return jumpModifier;
	}
}
