package com.morph.game.shooting.entities;

import com.morph.engine.core.Game;
import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;
import com.morph.engine.graphics.Texture;
import com.morph.engine.graphics.components.RenderData;
import com.morph.engine.graphics.shaders.BasicTexturedShader;
import com.morph.engine.physics.components.Gravity;
import com.morph.engine.physics.components.Velocity2D;
import com.morph.game.shooting.entities.components.Attacker;
import com.morph.game.shooting.entities.components.attacks.Attack;
import com.morph.game.shooting.entities.components.attacks.AttackData;
import com.morph.game.shooting.entities.components.attacks.MouseProjectileAttack;

public class PuzzlePlayer extends EntityRectangle {
	public PuzzlePlayer(float x, float y, float width, float height, Shader<?> shader, Game game) {
		super(x, y, width, height, new Color(0.5f, 1, 0.5f), shader, new Texture("textures/tile.png"), false);
		addComponent(new Velocity2D());
//		addComponent(new Gravity());

//		EntityRectangle fireball = new EntityRectangle(0, 0, 2, 2, new Color(1, 1, 1), new BasicTexturedShader(), new Texture("textures/fireball.png"), true);

//		AttackData fireballAttackData = new AttackData(25);
//		Attack fireballAttack = new MouseProjectileAttack(fireballAttackData, game, fireball, e -> e.getComponent(RenderData.class).setTexture(new Texture("textures/redBlock.png")), 20);

//		addComponent(new Attacker(fireballAttack, Attack.NOTHING, Attack.NOTHING, Attack.NOTHING));
	}
}
