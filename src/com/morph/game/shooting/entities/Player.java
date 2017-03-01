package com.morph.game.shooting.entities;

import static org.lwjgl.glfw.GLFW.*;

import com.morph.engine.core.Game;
import com.morph.engine.entities.EntityRectangle;
import com.morph.engine.graphics.Color;
import com.morph.engine.graphics.Shader;
import com.morph.engine.graphics.Texture;
import com.morph.engine.physics.components.Gravity;
import com.morph.engine.physics.components.Velocity2D;
import com.morph.game.shooting.controller.KeyboardController;
import com.morph.game.shooting.entities.components.Health;

public class Player extends EntityRectangle {
	public Player(int x, int y, int width, int height, Color color, Shader<?> shader) {
		super(x, y, width, height, color, shader, new Texture("textures/blueMan.png"), false);
		KeyboardController kc = new KeyboardController(15f, 0.5f, 0.8f, 20f, GLFW_KEY_W, GLFW_KEY_S, GLFW_KEY_A, GLFW_KEY_D);
		addComponent(kc);
		addComponent(new Velocity2D());
		addComponent(new Gravity());
		addComponent(new Health(100));
	}
}
