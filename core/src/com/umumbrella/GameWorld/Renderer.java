package com.umumbrella.GameWorld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Renderer {
	private World world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	public Renderer(World world) {
		this.world = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 137, 204);

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render() {
		System.out.println("GameRenderer - render");
		//TODO

	}
}
