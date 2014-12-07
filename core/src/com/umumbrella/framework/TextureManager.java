package com.umumbrella.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureManager {
	
	/* Loads Textures as public statics for the rest of the classes to use */
	public static Texture BACKGROUND;
	public static Texture NORMALBEE;
	public static Texture BOUNCEDBEE;
	public static Texture PLAYER1 ;
	public static Texture PLAYER2;
	public static TextureRegion player1;
	public static TextureRegion player2;
	public static Animation playerAnimation;
	public static Texture UMBRELLA;
	
	public TextureManager() {
		BACKGROUND = new Texture(Gdx.files.internal("background.png"));
		NORMALBEE = new Texture(Gdx.files.internal("normaklbee.png"));
		BOUNCEDBEE = new Texture(Gdx.files.internal("bouncedbee.png"));
		
		//TODO: Add more sprites for player movement
		// public static TextureRegion player1, player2, player3;
		PLAYER1 = new Texture(Gdx.files.internal("player1.png"));
		PLAYER2 = new Texture(Gdx.files.internal("player2.png"));
		player1 = new TextureRegion(PLAYER1);
		player2 = new TextureRegion(PLAYER2);
		TextureRegion[] player = { player1, player2 };
		playerAnimation = new Animation(0.06f, player);
		playerAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		UMBRELLA = new Texture(Gdx.files.internal("umbrella.png"));
	}
}
