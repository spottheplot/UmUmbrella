package umumbrella;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.umumbrella.entities.Bee;
import com.umumbrella.entities.Player;
import com.umumbrella.entities.Umbrella;
import com.umumbrella.framework.TextureManager;

public class World {
	
	/* This class handles collisions, and it's where the player, umbrella and bees live
	 * It contains the main game loop as well*/
	
	private Texture background;
	private Player player;
	private Umbrella umbrella;
	private Array<Bee> bees;
	
	public World() {
		background = TextureManager.BACKGROUND;
	}
	
	public void update() {
		
	}
	
	public void render(SpriteBatch sb) {
		sb.draw(background, 0, 0);
	}
	
}
