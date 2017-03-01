package com.morph.game.shooting.entities.components.powerups;

import com.morph.engine.entities.Component;
import com.morph.engine.entities.Entity;

public abstract class PowerUp extends Component {
	@Override
	public Component clone() {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract void onPickup(Entity e);
}
