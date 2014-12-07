package com.umumbrella.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Renderer {
	private final World world;
	private final OrthographicCamera cam;
	private final ShapeRenderer shapeRenderer;
	private final SpriteBatch batch;

	public Renderer(World world) {
		this.world = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 137, 204);

		batch = new SpriteBatch();

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render() {
		System.out.println("GameRenderer - render");
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}
}
