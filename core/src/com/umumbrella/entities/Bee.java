package com.umumbrella.entities;

import com.umumbrella.game.MainGame;
import com.umumbrella.framework.TextureManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Bee {

	private TextureRegion beeTexture;
	private int beeWidth, beeHeight;
	private boolean bounced;
	private final Circle beeCircle;
	Vector2 position;
	Vector2 speed;

	/**
	 * Instantiates a new bee.
	 *
	 * @param chance The chance (0 to 1) specified as input the bee starts head first or sting first
	 */
	public Bee(float chance) {
		if (MathUtils.random() < chance) {
			bounced = false;

			beeWidth = TextureManager.NORMALBEE.getWidth();
			beeHeight = TextureManager.NORMALBEE.getHeight();
			beeTexture = new TextureRegion(TextureManager.NORMALBEE, beeWidth, beeHeight);
		}
		else {
			bounced = true;

			beeWidth = TextureManager.BOUNCEDBEE.getWidth();
			beeHeight = TextureManager.BOUNCEDBEE.getHeight();
			beeTexture = new TextureRegion(TextureManager.BOUNCEDBEE, beeWidth, beeHeight);
		}

		//Initialize position out of the screen over the top
		position = new Vector2(
				MathUtils.random(0, MainGame.WIDTH),
				MathUtils.random(MainGame.HEIGHT, 2 * MainGame.HEIGHT));

		speed = new Vector2(
				MathUtils.random(-3.0f, 3.0f),
				MathUtils.random(-6.0f, 0.0f));

		beeCircle = new Circle(position, beeWidth);
	}

	public void update() {
		//Constants velocity for now, implement acceleration or change of direction??
		position.x += speed.x * Gdx.graphics.getDeltaTime();
		position.y += speed.y * Gdx.graphics.getDeltaTime();
	}

	public void setxVelocity(float xVelocity) {
		speed.x = xVelocity;
	}

	public void setyVelocity(float yVelocity) {
		speed.y = yVelocity;
	}

	public void setxPosition(float xPosition) {
		position.x = xPosition;
	}

	public void setyPosition(float yPosition) {
		position.y = yPosition;
	}

	public void setBounced(boolean bounced) {
		this.bounced = bounced;
	}

	public float getxPosition() {
		return position.x;
	}

	public float getyPosition() {
		return position.y;
	}

	public int getBeeWidth() {
		return beeWidth;
	}

	public int getBeeHeight() {
		return beeHeight;
	}

	public float getxVelocity() {
		return speed.x;
	}

	public float getyVelocity() {
		return speed.y;
	}

	public boolean getBounced() {
		return bounced;
	}

	//	public void bounceOff(float xUmbrella, float yUmbrella) { //THIS METHOD NEEDS TO BE MOVED OUTSIDE. KEEP HERE FOR THE MATHS
	//
	//		bounced = true;
	//
	//		//Change velocity according to collision physics
	//
	//		double collisionAngle = Math.atan2(yPosition - yUmbrella, xPosition - xUmbrella);
	//		double rotationAngle = 2 * (Math.PI / 2 - collisionAngle);
	//
	//		double newXSpeed = 0;
	//		double newYSpeed = 0;
	//
	//		if (angle > collisionAngle + Math.PI) { 			//Rotate anti clock-wise
	//			newXSpeed = Math.cos(rotationAngle) * xVelocity + Math.sin(rotationAngle) * yVelocity;
	//			newYSpeed = -Math.sin(rotationAngle) * xVelocity + Math.cos(rotationAngle) * yVelocity;
	//		}
	//		else { 				//Rotate clock-wise
	//			newXSpeed = Math.cos(rotationAngle) * xVelocity - Math.sin(rotationAngle) * yVelocity;
	//			newYSpeed = Math.sin(rotationAngle) * xVelocity + Math.cos(rotationAngle) * yVelocity;
	//		}
	//
	//		xVelocity = (float) newXSpeed;
	//		yVelocity = (float) newYSpeed;
	//	}

	public float getAngle() {
		return speed.angleRad();
	}


}
