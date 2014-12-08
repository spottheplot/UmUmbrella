package com.umumbrella.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.umumbrella.game.MainGame;

public class Player {
	Vector2 position;
	Vector2 speed;
	private int playerWidth, playerHeight;
	private boolean jumping;
	private static int hSpeed = 60;

	public Player() {
		position.x = MainGame.WIDTH / 2;
		//TODO: Determine ground position from background
		position.y = MainGame.HEIGHT * 5 / 2;
		jumping = false;
	}

	public void update() {
		// Position
		position.add(speed.scl(Gdx.graphics.getDeltaTime()));
	}

	public void setxVelocity(float xVelocity) {
		speed.x = xVelocity;
	}

	public void setyVelocity(float yVelocity) {
		speed.y = yVelocity;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public void setxPosition(float xPosition) {
		position.x = xPosition;
	}

	public void setyPosition(float yPosition) {
		position.y = yPosition;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public void setSpeed(Vector2 speed) {
		this.speed = speed;
	}

	public int getPlayerHeight() {
		return playerHeight;
	}

	public int getPlayerWidth() {
		return playerWidth;
	}

	public float getxPosition() {
		return position.x;
	}

	public float getxVelocity() {
		return speed.x;
	}

	public float getyPosition() {
		return position.y;
	}

	public float getyVelocity() {
		return speed.y;
	}

	public static int gethSpeed() {
		return hSpeed;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getSpeed() {
		return speed;
	}
}
