package com.morph.game.platformer;

import com.morph.engine.core.GameApplication;

public class PlatformerGameLauncher {
	private static GameApplication gameLauncher;
	private static PlatformerGame game;
	
	public static void main(String[] args) {
		game = new PlatformerGame(800, 600, 60, false);
		gameLauncher = new GameApplication(game);
		
		gameLauncher.launch();
	}
}
