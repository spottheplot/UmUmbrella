package com.umumbrella.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.umumbrella.entities.Bee;
import com.umumbrella.entities.Player;
import com.umumbrella.entities.Umbrella;
import com.umumbrella.framework.TextureManager;

public class Renderer {
	private final World world;
	private Umbrella umbrella;
	private Player player;
	private TextureRegion playerFrame;
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
		
		for (Bee bee: world.getBeeArray()) {
			
			float xRender = bee.getxPosition() - bee.getBeeWidth() / 2;
			float yRender = bee.getyPosition() - bee.getBeeHeight() / 2;
			
			if (bee.getBounced()) {
				batch.draw(TextureManager.bouncedBee, 
						xRender, yRender, 
						bee.getxPosition(), bee.getyPosition(), 
						bee.getBeeWidth(), bee.getBeeHeight(), 
						1.0f, 1.0f, 
						(float) (bee.getAngle() * 180 / Math.PI));
			}
			else {
				batch.draw(TextureManager.normalBee, 
						xRender, yRender, 
						bee.getxPosition(), bee.getyPosition(), 
						bee.getBeeWidth(), bee.getBeeHeight(), 
						1.0f, 1.0f,
						(float) (bee.getAngle() * 180 / Math.PI));
			}
		}
		
		batch.draw(TextureManager.BACKGROUND, 0, 0);
		
		umbrella = world.getUmbrella();
		
		if (umbrella.getOpen()) {
			batch.draw(TextureManager.umbrellaOpen, 
					umbrella.getxPosition() - umbrella.getUmbrellaWidth() / 2, umbrella.getyPosition(), 
					umbrella.getxPosition(), umbrella.getyPosition() + umbrella.getUmbrellaHeight() / 2, 
					umbrella.getUmbrellaWidth(), umbrella.getUmbrellaHeight(), 
					1.0f, 1.0f, 
					(float) (umbrella.getAngle() * 180 / Math.PI));
		}
		else {
			batch.draw(TextureManager.umbrellaClosed, 
					umbrella.getxPosition() - umbrella.getUmbrellaWidth() / 2, umbrella.getyPosition(), 
					umbrella.getxPosition(), umbrella.getyPosition() + umbrella.getUmbrellaHeight() / 2, 
					umbrella.getUmbrellaWidth(), umbrella.getUmbrellaHeight(), 
					1.0f, 1.0f, 
					(float) (umbrella.getAngle() * 180 / Math.PI));
		}

		if (player.getxVelocity() == 0) {
			playerFrame = TextureManager.playerStatic;
		}
		else {
			player = world.getPlayer();
			playerFrame = TextureManager.playerAnimation.getKeyFrame(Gdx.graphics.getDeltaTime());
		}
		
		batch.draw(playerFrame, 
				player.getxPosition() - player.getPlayerWidth() / 2, player.getyPosition(),
				player.getxPosition(), player.getyPosition() + player.getPlayerHeight() / 2,
				player.getPlayerWidth(), player.getPlayerHeight(),
				1.0f, 1.0f,
				0);
		
		batch.end();
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}
}
