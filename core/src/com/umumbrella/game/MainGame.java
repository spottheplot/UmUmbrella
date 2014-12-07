package com.umumbrella.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.umumbrella.GameWorld.World;
import com.umumbrella.GameWorld.Renderer;
import com.umumbrella.framework.InputHandler;

public class MainGame extends ApplicationAdapter {
	private World world;
	private Renderer renderer;

	SpriteBatch batch;
	public static int WIDTH = 640, HEIGHT = 480; //This values should be adjusted

	@Override
	public void create () {
		world = new World();
		renderer = new Renderer(world);

		Gdx.input.setInputProcessor(new InputHandler(world.getPlayer(), world.getUmbrella()));
	}

	@Override
	public void dispose () {
		renderer.dispose();
	}

	@Override
	public void render () {
		renderer.render();
	}
}
