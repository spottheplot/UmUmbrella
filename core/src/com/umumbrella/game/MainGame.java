package com.umumbrella.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.umumbrella.GameWorld.World;
import com.umumbrella.GameWorld.Renderer;

public class MainGame extends ApplicationAdapter {
	private World world;
	private Renderer renderer;
	
	SpriteBatch batch;
	public static int WIDTH = 640, HEIGHT = 480; //This values should be adjusted
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
}
