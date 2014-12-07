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
	public static TextureRegion normalBee;
	public static TextureRegion bouncedBee;
	
	public static Texture PLAYER1;
	public static Texture PLAYER2;
	public static Texture PLAYERSTATIC;
	public static TextureRegion player1;
	public static TextureRegion player2;
	public static TextureRegion playerStatic;	
	public static Animation playerAnimation;
	
	public static Texture UMBRELLAOPEN;
	public static Texture UMBRELLACLOSED;
	public static TextureRegion umbrellaOpen;
	public static TextureRegion umbrellaClosed;
	
	public TextureManager() {
		BACKGROUND = new Texture(Gdx.files.internal("background.png"));
		
		NORMALBEE = new Texture(Gdx.files.internal("normalbee.png"));
		BOUNCEDBEE = new Texture(Gdx.files.internal("bouncedbee.png"));
		
		normalBee = new TextureRegion(NORMALBEE);
		bouncedBee = new TextureRegion(BOUNCEDBEE);
		
		//TODO: Add more sprites for player movement
		// public static TextureRegion player1, player2, player3;
		
		PLAYER1 = new Texture(Gdx.files.internal("player1.png"));
		PLAYER2 = new Texture(Gdx.files.internal("player2.png"));
		PLAYERSTATIC = new Texture(Gdx.files.internal("playerstatic.png"));
		
		player1 = new TextureRegion(PLAYER1);
		player2 = new TextureRegion(PLAYER2);
		TextureRegion[] player = { player1, player2 };
		playerStatic = new TextureRegion(PLAYERSTATIC);
		
		playerAnimation = new Animation(0.06f, player);
		playerAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		
		UMBRELLAOPEN = new Texture(Gdx.files.internal("umbrellaopen.png"));
		UMBRELLACLOSED = new Texture(Gdx.files.internal("umbrellaclosed.png"));
		
		umbrellaOpen = new TextureRegion(UMBRELLAOPEN);
		umbrellaClosed = new TextureRegion(UMBRELLACLOSED);
	}
}
