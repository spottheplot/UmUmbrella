package com.umumbrella.entities;

import umumbrella.MainGame;
import umumbrella.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Bee {
	
	private float xPosition, yPosition, xVelocity, yVelocity;
	private Texture beeTexture;
	private int beeWidth, beeHeight;
	private boolean bounced;
	
	public Bee(float chance) {
		
		//Depending on the chance (0 to 1) specified as input the bee starts head first or sting first
		if (MathUtils.random() < chance) {
			bounced = false;
			beeTexture = TextureManager.NORMALBEE;
		}
		else {
			bounced = true;
			beeTexture = TextureManager.BOUNCEDBEE;
		}
		
		beeWidth = beeTexture.getWidth();
		beeHeight = beeTexture.getHeight();
		
		//Initialize position in the upper part of the screen
		
		xPosition = MathUtils.random(0, MainGame.WIDTH);
		yPosition = MathUtils.random(MainGame.HEIGHT, 2 * MainGame.HEIGHT);
		
		xVelocity = 0; //For now equal to 0, check for possible range in random
		yVelocity = -1;
	}
	
	public void update() {		
		//Constants velocity for now, implement acceleration or change of direction
		xPosition += xVelocity * Gdx.graphics.getDeltaTime();
		yPosition += yVelocity * Gdx.graphics.getDeltaTime();
	}
	
	public void render(SpriteBatch sb) {
	}
	
	public void bounceOff() {
		if (bounced == false) {
			bounced = true;
		}
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
