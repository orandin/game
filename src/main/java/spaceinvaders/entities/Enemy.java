package spaceinvaders.entities;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class Enemy extends Shooter implements MoveBlocker {

	protected int point;
	protected EnemiesArray enemiesArray;
	protected double xOffset = 0;
	protected int yOffset 	 = 0;

	/**
	 * Create an enemy
	 * @param data The game data
	 * @param posX The initial x position
	 * @param posY The initial y position
	 * @param enemiesArray The array witch allow it to move on screen
	 */
	public Enemy(GameData data, int posX, int posY, EnemiesArray enemiesArray) {
		super(data);
		super.setPosition(new Point(posX, posY));
		this.enemiesArray = enemiesArray;
	}


	/**
	 * Get the amount of points you win when the entity die
	 * @return the amount of points
	 */
	public abstract int score();

	/**
	 * Get the bounding box of this entity
	 * @return the bounding box as a rectangle
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(
				new Point((int) Math.floor(xOffset + position.x), yOffset + position.y), 
				new Dimension(image.getWidth(), image.getHeight())
			);
	}

	/**
	 * Get the array when the enemy is
	 * @return the array
	 */
	public EnemiesArray getArray() {
		return enemiesArray;
	}

	/**
	 * Get the location in the EnemiesArray of the entity
	 * @return a point witch x is the row in the array and y is the column in the array
	 */
	public Point getLocationInArray() {
		return new Point(
				(int) (getPosition().getX() / getImage().getWidth()), 
				(int) (getPosition().getY() / getImage().getHeight())
			);
	}

	/**
	 * Set the position offsets
	 * @param x The x position offset
	 * @param y	The y position offset
	 */
	public void setOffsets(double x, int y) {
		xOffset = x;
		yOffset = y;
	}

	/**
	 * Allow the entity to shoot
	 */
	@Override
	public void shoot() {
		Random rand = new Random();
		int pos 	= (int) getLocationInArray().getY();

		if (pos == 4 && rand.nextInt(700) % 350 == 0)
			data.getUniverse().addGameEntity(new EnemyLaser(data, this));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {
		data.getCanvas().drawImage(g, image.getImage(), (int) Math.floor(xOffset + position.x), yOffset + position.y);
	}
}
