package com.umumbrella.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.umumbrella.framework.TextureManager;
import com.umumbrella.game.MainGame;

public class Umbrella {

	private final float xPosition, yPosition;
	private float angle;
	private final int umbrellaWidth, umbrellaHeight;
	private boolean open;

	/**
	 * Instantiates a new umbrella.
	 *
	 * @param xPosition The x position
	 * @param yPosition The y position
	 */
	public Umbrella(float xPosition, float yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;

		umbrellaWidth = TextureManager.UMBRELLAOPEN.getWidth();
		umbrellaHeight = TextureManager.UMBRELLAOPEN.getHeight();

		open = false;
	}

	public void update(float xCursor, float yCursor) {
		angle = (float) Math.atan2(MainGame.HEIGHT - yCursor, xCursor);
	}

	public void update(boolean click) {
		if (click) {
			open = !open;
		}
	}

	public float getxPosition() {
		return xPosition;
	}

	public float getyPosition() {
		return yPosition;
	}

	public float getAngle() {
		return angle;
	}

	public boolean getOpen() {
		return open;
	}
	
	public int getUmbrellaWidth() {
		return umbrellaWidth;
	}
	
	public int getUmbrellaHeight() {
		return umbrellaHeight;
	}

}
