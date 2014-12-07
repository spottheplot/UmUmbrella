package com.umumbrella.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	
	/* Loads Textures as public statics for the rest of the classes to use */
	
	public static Texture BACKGROUND = new Texture(Gdx.files.internal("background.png"));
	public static Texture NORMALBEE = new Texture(Gdx.files.internal("normaklbee.png"));
	public static Texture BOUNCEDBEE = new Texture(Gdx.files.internal("bouncedbee.png"));
}
