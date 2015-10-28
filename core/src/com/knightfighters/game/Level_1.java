package com.knightfighters.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;
import java.util.Map;

public class Level_1 extends ApplicationAdapter implements InputProcessor, ApplicationListener {
	SpriteBatch batch;
	Camera camera;
	Viewport viewport;
	Texture background, ui;
	TextureAtlas taPlayer_i, taPlayer_a, taPlayer_d, taPlayer_r;
	Animation player_i, player_a, player_d, player_r;
	Sprite backgroundSprite, uiSprite;
	BitmapFont font;
	Player knight;
	private String mHealthCount;
	private float elapsedTime = 0;
	private float x = 0.0f;
	private boolean left_pressed = false, right_pressed = false;
	private int w,h;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("level1_background.jpg");
		backgroundSprite = new Sprite(background);
		backgroundSprite.setPosition(0.0f, 0.0f);
		backgroundSprite.setSize(1280, 720);
		ui = new Texture("ui_trans.png");
		uiSprite = new Sprite(ui);
		uiSprite.setPosition(0.0f, 0.0f);
		uiSprite.setSize(1280, 137);
		font = new BitmapFont(Gdx.files.internal("fonts/arial-20.fnt"),false);
		font.setColor(Color.BLACK);

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		viewport = new FitViewport(1280, 720, camera);
		viewport.apply();

		taPlayer_i = new TextureAtlas("knight/idle/spritesheet.atlas");
		player_i = new Animation(1 / 60f, taPlayer_i.getRegions());
		taPlayer_a = new TextureAtlas("knight/attack/spritesheet.atlas");
		player_a = new Animation(1 / 60f, taPlayer_a.getRegions());
		taPlayer_d = new TextureAtlas("knight/defend/spritesheet.atlas");
		player_d = new Animation(1 / 60f, taPlayer_d.getRegions());
		taPlayer_r = new TextureAtlas("knight/run/spritesheet.atlas");
		player_r = new Animation(1 / 60f, taPlayer_r.getRegions());

		Gdx.input.setInputProcessor(this);
		knight = new Player();
		mHealthCount = "Health: " + Integer.toString(knight.getHealth());

		camera.position.set(camera.viewportWidth / 2.0f, camera.viewportHeight / 2.0f, 0.0f);
	}

	@Override
	public void render () {
		camera.update();
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mHealthCount = "Health: " + Integer.toString(knight.getHealth());

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			elapsedTime += Gdx.graphics.getDeltaTime();
			backgroundSprite.draw(batch);
			uiSprite.draw(batch);

			font.draw(batch, mHealthCount, 600, 600);

			switch(knight.getState()) {
				case 1:
					batch.draw(player_i.getKeyFrame(elapsedTime, true), 1000 + x, 150);
					break;
				case 2:
					batch.draw(player_a.getKeyFrame(elapsedTime, true), 1000 + x, 150);
					break;
				case 3:
					batch.draw(player_d.getKeyFrame(elapsedTime, true), 1000 + x, 150);
					break;
				case 4:
					batch.draw(player_r.getKeyFrame(elapsedTime, true), 1000 + x, 150);
					break;
			}

		batch.end();
	}

	@Override
	public void dispose () {
		background.dispose();
		ui.dispose();
		backgroundSprite.getTexture().dispose();
		uiSprite.getTexture().dispose();
		taPlayer_i.dispose();
		taPlayer_a.dispose();
		taPlayer_d.dispose();
		taPlayer_r.dispose();
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		camera.position.set(camera.viewportWidth / 2.0f, camera.viewportHeight / 2.0f, 0.0f);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		if (screenX <= 210 && screenY <= 137) {
			left_pressed = true;
			knight.setState(4);
			x = x - 5.0f;
		} else if (screenX <= 420 && screenY <= 137) {
			right_pressed = true;
			knight.setState(4);
			x = x + 5.0f;
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		if (screenX <= 210 && screenY <= 137) {
			left_pressed = false;
			knight.setState(1);
			x = 0.0f;
		} else if (screenX <= 420 && screenY <= 137) {
			right_pressed = false;
			knight.setState(1);
			x = 0.0f;
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
