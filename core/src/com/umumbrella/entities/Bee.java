package com.umumbrella.entities;

import com.umumbrella.game.MainGame;
import com.umumbrella.framework.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Bee {

	private float xPosition, yPosition, xVelocity, yVelocity;
	private final float angle;
	private TextureRegion beeTexture;
	private int beeWidth, beeHeight;
	private boolean bounced;

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
		xPosition = MathUtils.random(0, MainGame.WIDTH);
		yPosition = MathUtils.random(MainGame.HEIGHT, 2 * MainGame.HEIGHT);
		
		xVelocity = MathUtils.random(-3.0f, 3.0f);
		yVelocity = MathUtils.random(-6.0f, 0.0f);
		
		angle = (float) Math.atan2(yVelocity, xVelocity);
	}
	
	public void update() {
		//Constants velocity for now, implement acceleration or change of direction??
		xPosition += xVelocity * Gdx.graphics.getDeltaTime();
		yPosition += yVelocity * Gdx.graphics.getDeltaTime();
	}
	
	public void render(SpriteBatch sb) {
		sb.draw(beeTexture, xPosition - beeWidth / 2, yPosition - beeHeight / 2, xPosition, yPosition, beeWidth, beeHeight, 1.0f, 1.0f, angle * 180 / (float) Math.PI);
	}
	
	public void setxVelocity(float xVelocity) {
		this.xVelocity = xVelocity;
	}
	
	public void setyVelocity(float yVelocity) {
		this.yVelocity = yVelocity;
	}
	
	public void setxPosition(float xPosition) {
		this.xPosition = xPosition;
	}
	
	public void setyPosition(float yPosition) {
		this.yPosition = yPosition;
	}
	
	public void setBounced(boolean bounced) {
		this.bounced = bounced;
	}
	
	public float getxPosition() {
		return xPosition;
	}
	
	public float getyPosition() {
		return yPosition;
	}
	
	public int getBeeWidth() {
		return beeWidth;
	}
	
	public int getBeeHeight() {
		return beeHeight;
	}
	
	public float getxVelocity() {
		return xVelocity;
	}
	
	public float getyVelocity() {
		return yVelocity;
	}
	
	public boolean getBounced() {
		return bounced;
	}
	
	public float getAngle() {
		return angle;
	}
	
	public void bounceOff(float xUmbrella, float yUmbrella) { //THIS METHOD NEEDS TO BE MOVED OUTSIDE. KEEP HERE FOR THE MATHS
		
		bounced = true;
		
		//Change velocity according to collision physics
		
		double collisionAngle = Math.atan2(yPosition - yUmbrella, xPosition - xUmbrella);
		double rotationAngle = 2 * (Math.PI / 2 - collisionAngle);

		double newXSpeed = 0;
		double newYSpeed = 0;
		
		if (angle > collisionAngle + Math.PI) { 			//Rotate anti clock-wise
			newXSpeed = Math.cos(rotationAngle) * xVelocity + Math.sin(rotationAngle) * yVelocity;
			newYSpeed = -Math.sin(rotationAngle) * xVelocity + Math.cos(rotationAngle) * yVelocity;
		}
		else { 				//Rotate clock-wise
			newXSpeed = Math.cos(rotationAngle) * xVelocity - Math.sin(rotationAngle) * yVelocity;
			newYSpeed = Math.sin(rotationAngle) * xVelocity + Math.cos(rotationAngle) * yVelocity;
		}
		
		xVelocity = (float) newXSpeed;
		yVelocity = (float) newYSpeed;
	}

}
