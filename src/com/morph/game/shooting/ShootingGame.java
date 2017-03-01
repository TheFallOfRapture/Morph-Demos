package com.morph.game.shooting;

import com.morph.engine.collision.CollisionEngine;
import com.morph.engine.core.Game;
import com.morph.engine.core.OpenGame;
import com.morph.engine.entities.Entity;
import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.events.EventDispatcher;
import com.morph.engine.events.EventListener;
import com.morph.engine.events.ResizeEvent;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.GLRenderingEngine;
import com.morph.engine.graphics.Texture;
import com.morph.engine.graphics.components.RenderData;
import com.morph.engine.input.Keyboard;
import com.morph.engine.input.Mouse;
import com.morph.engine.math.MatrixUtils;
import com.morph.engine.physics.components.Gravity;
import com.morph.engine.physics.components.Transform2D;
import com.morph.engine.physics.components.Velocity2D;
import com.morph.game.shooting.controller.Action;
import com.morph.game.shooting.entities.Player;
import com.morph.game.shooting.entities.PuzzlePlayer;
import com.morph.game.shooting.entities.components.Attacker;
import com.morph.game.shooting.entities.components.Block;
import com.morph.game.shooting.entities.components.Health;
import com.morph.game.shooting.entities.components.attacks.Attack;
import com.morph.game.shooting.entities.components.attacks.AttackData;
import com.morph.game.shooting.entities.components.attacks.MouseProjectileAttack;
import com.morph.game.shooting.entities.components.attacks.TargetedProjectileAttack;
import com.morph.game.shooting.events.AttackEvent;
import com.morph.game.shooting.graphics.shaders.BasicTexturedShader;
import com.morph.game.shooting.levels.FirstPrototypeLevel;
import com.morph.game.shooting.levels.Level;
import com.morph.game.shooting.levels.PlatformerLevel;
import com.morph.game.shooting.levels.TestPuzzleLevel;
import com.morph.game.shooting.systems.BlockInputSystem;
import com.morph.game.shooting.systems.BlockStateSystem;
import com.morph.game.shooting.systems.CollisionSystem;
import com.morph.game.shooting.systems.ControllerSystem;
import com.morph.game.shooting.systems.PhysicsWorld;
import com.morph.game.shooting.systems.HealthSystem;
import com.morph.game.shooting.systems.TriggerSystem;
import com.morph.game.shooting.systems.VelocitySystem;

import java.util.function.Consumer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

public class ShootingGame extends OpenGame {
	private Player player;
	private PuzzlePlayer puzzlePlayer;
	private PlatformerLevel currentLevel;
	private Entity testEnemy;
	private static final float WORLD_SIZE = 50f;

	public ShootingGame(int width, int height, float fps, boolean fullscreen) {
		super(width, height, "Platformer Project: Prototype 1", fps, fullscreen);
	}

	@Override
	public void initGame() {
		renderingEngine.setClearColor(new Color(0.1f, 0.1f, 0.1f, 1));
		float ratio = (float) width / (float) height;
		GLRenderingEngine.setProjectionMatrix(MatrixUtils.getOrthographicProjectionMatrix(WORLD_SIZE, 0, 0, WORLD_SIZE * ratio, -1, 1));

		player = new Player(33, 20, 1, 1, new Color(1, 1, 1), new BasicTexturedShader());
		System.out.println("xd");
		addEntity(player);

		testEnemy = new EntityRectangle(25, 30, 3, 3, new Color(1, 1, 1, 1), new BasicTexturedShader(), new Texture("textures/tileUnlit.png"), false);
//		testEnemy.addComponent(new Block(new Color(0.25f, 0.25f, 0.25f), new Color(0.5f, 0.5f, 0.5f), new Color(0, 1, 0)));
		testEnemy.addComponent(new Health(5000));
		testEnemy.addComponent(new Velocity2D());
//		testEnemy.addComponent(new Gravity());

		addEntity(testEnemy);

//		addEntity(puzzlePlayer = new PuzzlePlayer(33.333f, 50, 3, 3, new BasicTexturedShader(), this));

		EntityRectangle fireball = new EntityRectangle(0, 0, 1, 1, new Color(1, 1, 1), new com.morph.engine.graphics.shaders.BasicTexturedShader(), new Texture("textures/fireball.png"), true);
		EntityRectangle hugeFireball = new EntityRectangle(0, 0, 5, 5, new Color(1, 0, 0), new com.morph.engine.graphics.shaders.BasicTexturedShader(), new Texture("textures/fireball.png"), true);

		AttackData fireballAttackData = new AttackData(25, 0.5f);
//		Consumer<Entity> fireballBehavior = e -> e.getComponent(RenderData.class).setTexture(new Texture("textures/redBlock.png"));
		Consumer<Entity> fireballBehavior = e -> {
			if (!e.hasComponent(Health.class)) return;
			float percentHealth = e.getComponent(Health.class).getPercentHealth();
			System.out.println(percentHealth);
			e.getComponent(RenderData.class).resetAllColors(
					new Color(1, percentHealth, percentHealth));
		};

		Attack fireballAttack = new MouseProjectileAttack(fireballAttackData, this, fireball, fireballBehavior, 20);
		Attack targetedFireball = new TargetedProjectileAttack(fireballAttackData, this, fireball, testEnemy, fireballBehavior, 20);
		Attack megaFireball = new TargetedProjectileAttack(new AttackData(500, 7.5f), this, hugeFireball, player, fireballBehavior, 5);

		player.addComponent(new Attacker(fireballAttack, targetedFireball, Attack.NOTHING, Attack.NOTHING));
		testEnemy.addComponent(new Attacker(megaFireball, Attack.NOTHING, Attack.NOTHING, Attack.NOTHING));

//		currentLevel = new TestLevel(this);

//		addEntities(currentLevel.getEntities());

		Level testLevel = new FirstPrototypeLevel();
		Level testPuzzleLevel = new TestPuzzleLevel();

		getWorld().addEntities(testPuzzleLevel.getEntities());

		addSystem(new ControllerSystem(this));
		addSystem(new PhysicsWorld(this));
		addSystem(new CollisionEngine(this));
		addSystem(new CollisionSystem(this));
		addSystem(new VelocitySystem(this));
		addSystem(new TriggerSystem(this));
		addSystem(new HealthSystem(this));
		addSystem(new BlockInputSystem(this));
		addSystem(new BlockStateSystem(this));
	}

	@EventListener(ResizeEvent.class)
	public void handleResize(ResizeEvent e) {
		int width = e.getWidth();
		int height = e.getHeight();

		glViewport(0, 0, width, height);
		float ratio = (float) width / (float) height;
		GLRenderingEngine.setProjectionMatrix(MatrixUtils.getOrthographicProjectionMatrix(WORLD_SIZE, 0, 0, WORLD_SIZE * ratio, -1, 1));
	}

	private float attackCounter;
	private final float ATTACK_COOLDOWN = 7.5f;

	@Override
	public void fixedGameUpdate(float dt) {
		if (attackCounter >= ATTACK_COOLDOWN) {
			EventDispatcher.INSTANCE.dispatchEvent(
					new AttackEvent(testEnemy
							, AttackEvent.AttackSelection.ONE
							, Mouse.getWorldMousePosition()));

			attackCounter = 0;
		}

		attackCounter += dt;
	}

	// TODO: Remove if working
//	@Override
//	public void render() {
//		// TODO Auto-generated method stub
//		renderingEngine.render(display, entities);
//	}

	private void respawnPlayer() {

	}

	private float cdCounter = 0;
	private final float RAPID_FIRE_CD = 0.2f;
	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
//		if (Keyboard.isKeyDown(GLFW_KEY_SPACE)) {
//			Action.TEST_ACTION.executeIfMatch("Move Up", puzzlePlayer);
//		}

		if (Keyboard.isKeyPressed(GLFW_KEY_1)) {
			EventDispatcher.INSTANCE.dispatchEvent(
					new AttackEvent(player
								  , AttackEvent.AttackSelection.ONE
								  , Mouse.getWorldMousePosition()));
		}

		if (Keyboard.isKeyPressed(GLFW_KEY_2)) {
			EventDispatcher.INSTANCE.dispatchEvent(
					new AttackEvent(player
							, AttackEvent.AttackSelection.TWO
							, Mouse.getWorldMousePosition()));
		}

		if (Keyboard.isKeyPressed(GLFW_KEY_3)) {
			EventDispatcher.INSTANCE.dispatchEvent(
					new AttackEvent(player
							, AttackEvent.AttackSelection.THREE
							, Mouse.getWorldMousePosition()));
		}


		if (Keyboard.isKeyDown(GLFW_KEY_4)) {
			cdCounter += dt;
			if (cdCounter >= RAPID_FIRE_CD) {
				EventDispatcher.INSTANCE.dispatchEvent(
						new AttackEvent(player
								, AttackEvent.AttackSelection.TWO
								, Mouse.getWorldMousePosition()));
				cdCounter = 0;
			}
		} else {
			cdCounter = 0;
		}
	}

	@Override
	public void preGameUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postGameUpdate() {
		// TODO Auto-generated method stub

	}

}
