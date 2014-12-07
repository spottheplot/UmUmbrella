package com.umumbrella.GameWorld;

import com.badlogic.gdx.utils.Array;
import com.umumbrella.entities.Bee;
import com.umumbrella.entities.Player;
import com.umumbrella.entities.Umbrella;

public class World {
	Player player;
	Umbrella umbrella;
	Array<Bee>  beeArray;

	/**
	 * Instantiates a new world.
	 */
	public World() {
		// Initialise world objects
		player = new Player();
		umbrella = new Umbrella(player.getxPosition(), player.getyPosition());
		beeArray = new Array<Bee>(false, 20);
	}

	/**
	 * Updates the values of all the world elements
	 */
	public void update() {
		player.update();
		for (Bee bee : beeArray) {
			bee.update();
		}
	}

	public Player getPlayer() {
		return player;
	}

	public Umbrella getUmbrella() {
		return umbrella;
	}

	public Array<Bee> getBeeArray() {
		return beeArray;
	}
}
