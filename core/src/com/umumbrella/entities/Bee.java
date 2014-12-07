package com.umumbrella.entities;

import umumbrella.MainGame;
import umumbrella.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Bee {
	
	private float xPosition, yPosition, xVelocity, yVelocity, angle;
	private TextureRegion beeTexture;
	private int beeWidth, beeHeight;
	private boolean bounced;
	
	public Bee(float chance) {
		
		//Depending on the chance (0 to 1) specified as input the bee starts head first or sting first
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
		
		xVelocity = 0; //For now equal to 0, check for possible range in random
		yVelocity = -1;
		
		angle = (float) Math.atan2(yVelocity, xVelocity);
	}
	
	public void update() {		
		//Constants velocity for now, implement acceleration or change of direction??
		xPosition += xVelocity * Gdx.graphics.getDeltaTime();
		yPosition += yVelocity * Gdx.graphics.getDeltaTime();
	}
	
	public void render(SpriteBatch sb) {
		sb.draw(beeTexture, xPosition - beeWidth / 2, yPosition - beeHeight / 2, xPosition, yPosition, beeWidth, beeHeight, 1.0f, 1.0f, angle);
	}
	
	public void bounceOff(float xUmbrella, float yUmbrella) { //Pass the position of the center of the arc of the umbrella to calculate collision
		
		bounced = true;
		
		//Change velocity according to collision physics
		
		double collisionAngle = Math.atan2(yPosition - yUmbrella, xPosition - xUmbrella);
	}
	
	public float getX() {
		return xPosition;
	}
	
	public float getY() {
		return yPosition;
	}
	
	public boolean getState() {
		return bounced;
	}

}
