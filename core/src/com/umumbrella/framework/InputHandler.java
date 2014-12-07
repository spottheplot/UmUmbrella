package com.umumbrella.framework;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.umumbrella.entities.Player;
import com.umumbrella.entities.Umbrella;

public class InputHandler implements InputProcessor {
	Player player;
	Umbrella umbrella;

	public InputHandler(Player player, Umbrella umbrella) {
		this.player = player;
		this.umbrella = umbrella;
	}

	@Override
	public boolean keyDown(int keycode) {
		// Player
		switch (keycode) {
		case (Input.Keys.W):
		case (Input.Keys.LEFT):
			player.setxVelocity(-Player.gethSpeed());
		break;
		case (Input.Keys.D):
		case (Input.Keys.RIGHT):
			player.setxVelocity(Player.gethSpeed());
		break;
		default:
			break;
		}
		// TODO Add umbrella
		return true;

	}

	@Override
	public boolean keyUp(int keycode) {
		// Player
		switch (keycode) {
		case (Input.Keys.W):
		case (Input.Keys.LEFT):
		case (Input.Keys.D):
		case (Input.Keys.RIGHT):
			player.setxVelocity(0);
		break;
		}
		// TODO Add umbrella
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		umbrella.update(screenX, screenY);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
