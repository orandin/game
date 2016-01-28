package spaceinvaders.entities;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategyRandom;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import spaceinvaders.Game.Game;

public abstract class AbstractEntity extends GameMovable implements GameEntity {

	protected Game game;
	protected int xPos;
	protected int yPos;
	protected int speed;
	protected BufferedImage sprite;
	protected GameCanvas canvas;
	
	/**
	 * Create the entity
	 * @param game
	 * 		The game where the entity is registered
	 * @param initialXPos
	 * 		The initial X coordinate where the entity is draw
	 * @param initialYPos
	 * 		The initial Y coordinate where the entity is draw
	 * @param speed
	 * 		The entity movement speed
	 * @param entitySpritePath
	 * 		The entity sprite
	 * @param spriteWidth
	 * 		The sprite width
	 * @param spriteHeight
	 * 		The sprite height
	 */
	public AbstractEntity(Game game, int initialXPos, int initialYPos, int speed, String entitySpritePath, int spriteWidth, int spriteHeight)
	{
		super();
		super.moveDriver.setStrategy(new MoveStrategyRandom());
		this.game = game;
		this.xPos = initialXPos - spriteWidth / 2;
		this.yPos = initialYPos - spriteHeight / 2;
		this.speed = speed;
		this.sprite = new BufferedImage(spriteWidth, spriteHeight, BufferedImage.TYPE_INT_RGB);
		this.canvas = game.getGameCanvas();
	}
	
	/**
	 * Get the entity Hitbox
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(this.xPos, this.yPos, this.sprite.getWidth(), this.sprite.getHeight());
	}
	
	/**
	 * Draw the entity on canvas after clear last position
	 */
	@Override
	public void draw(Graphics g) {
		g.clearRect(this.xPos - this.speed, this.yPos, this.sprite.getWidth() + this.speed, this.sprite.getHeight());
		g.drawImage(this.sprite, this.xPos, this.yPos, null);
	}
}
