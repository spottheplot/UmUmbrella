package umumbrella.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.umumbrella.game.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Under My Umbrella";
		config.width = MainGame.WIDTH;
		config.height = MainGame.HEIGHT;
		
		new LwjglApplication(new MainGame(), config);
	}
}
