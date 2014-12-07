package com.umumbrella.entities;

import com.badlogic.gdx.Gdx;
import com.umumbrella.game.MainGame;

public class Player {
	private float xPosition, yPosition, xVelocity, yVelocity;
	private int playerWidth, playerHeight;
	private boolean jumping;
	private static int hSpeed = 60;

	public Player() {
		xPosition = MainGame.WIDTH / 2;
		//TODO: Determine ground position from background
		yPosition = MainGame.HEIGHT * 5 / 2;
		jumping = false;
	}

	public void update() {
		//Constants velocity in x for now, no speed in y axis
		xPosition += xVelocity * Gdx.graphics.getDeltaTime();
//		yPosition += yVelocity * Gdx.graphics.getDeltaTime();
	}

	public void setxVelocity(float xVelocity) {
		this.xVelocity = xVelocity;
	}

	public void setyVelocity(float yVelocity) {
		this.yVelocity = yVelocity;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public void setxPosition(float xPosition) {
		this.xPosition = xPosition;
	}

	public void setyPosition(float yPosition) {
		this.yPosition = yPosition;
	}

	public int getPlayerHeight() {
		return playerHeight;
	}

	public int getPlayerWidth() {
		return playerWidth;
	}

	public float getxPosition() {
		return xPosition;
	}

	public float getxVelocity() {
		return xVelocity;
	}

	public float getyPosition() {
		return yPosition;
	}

	public float getyVelocity() {
		return yVelocity;
	}

	public static int gethSpeed() {
		return hSpeed;
	}
}
