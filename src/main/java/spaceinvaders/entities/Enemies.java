package spaceinvaders.entities;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author Matthieu Lepers
 * @author Kévin Rico
 * @author Simon Delberghe
 */
public abstract class Enemies extends Shooter implements MoveBlocker{

	protected int point;
	protected AlienArray array;
	protected double xOffset = 0;
	protected int yOffset = 0;
	
	/**
	 * Create an enemy
	 * @param data
	 * 		The game data
	 * @param posX
	 * 		The initial x position
	 * @param posY
	 * 		The initial y position
	 * @param array
	 * 		The array whitch allow it to move on screen
	 */
	public Enemies(GameData data, int posX, int posY, AlienArray array) {
		super(data);
		super.setPosition(new Point(posX, posY));
		this.array = array;
	}
	
	/* ----- Getters ----- */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(new Point((int) Math.floor(this.xOffset + super.position.x), this.yOffset + super.position.y), new Dimension(super.image.getWidth(), super.image.getHeight()));
	}
	
	/**
	 * Get the array when the enemy is
	 * @return the array
	 */
	public AlienArray getArray() {
		return this.array;
	}
	
	/* ----- Setters ----- */
	/**
	 * Set the position offsets
	 * @param x
	 * 		The x position offset
	 * @param y
	 * 		The y position offset
	 */
	public void setOffsets(double x, int y) {
		this.xOffset = x;
		this.yOffset = y;
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {}

	@Override
	public void shoot(){
	}
	
	public abstract int score();
	
	/**
	 * Draw the enemy in the correct location with this offsets position and position
	 */
	@Override
	public void draw(Graphics g) {
		this.data.getCanvas().drawImage(g, this.image.getImage(), (int) Math.floor(this.xOffset + super.position.x), this.yOffset + super.position.y);
	}
}
