package com.morph.game.shooting.levels;

import java.util.ArrayList;
import java.util.List;

import com.morph.engine.entities.Entity;

public class Level {
	private List<Entity> entities;
	
	public Level() {
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void removeEntity(Entity e) {
		entities.remove(e);
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
}
