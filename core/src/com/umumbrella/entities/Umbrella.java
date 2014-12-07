package com.umumbrella.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.umumbrella.framework.TextureManager;
import com.umumbrella.game.MainGame;

public class Umbrella {
	
	private float xPosition, yPosition, angle;
	private int umbrellaWidth, umbrellaHeight;
	private boolean open;
	private TextureRegion umbrellaTexture;
	
	public Umbrella(float xPosition, float yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		
		umbrellaWidth = TextureManager.UMBRELLA.getWidth();
		umbrellaHeight = TextureManager.UMBRELLA.getHeight();
		umbrellaTexture = new TextureRegion(TextureManager.UMBRELLA, umbrellaWidth, umbrellaHeight);
		
		open = false;
	}
	
	public void update(float xCursor, float yCursor, boolean click) {
		angle = (float) Math.atan2(MainGame.HEIGHT - yCursor, xCursor);
		if (click) {
			open = !open;
		}
	}
	
	public void render(SpriteBatch sb) {
		sb.draw(umbrellaTexture, xPosition - umbrellaWidth / 2, yPosition, xPosition, yPosition + umbrellaHeight / 2, umbrellaWidth, umbrellaHeight, 1.0f, 1.0f, angle * 180 / (float) Math.PI);
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

}
