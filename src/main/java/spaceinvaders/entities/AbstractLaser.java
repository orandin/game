package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

import java.awt.Dimension;
import java.awt.Rectangle;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class AbstractLaser extends EntiteMovable {

	protected Shooter shooter;

	/**
	 * Create a laser
	 * @param data The game data
	 * @param shooter The laser's shooter
	 */
	public AbstractLaser(GameData data, Shooter shooter) {
		super(data);
		image = new DrawableImage(this.getSprite(), this.data.getCanvas());
		this.shooter = shooter;
		
		setPosition();
		setMoveStrategy();
	}

	/**
	 * Get the laser's shooter
	 * @return the shooter
	 */
	public Shooter getShooter() {
		return shooter;
	}

	/**
	 * Get the bounding box of the laser
	 * @return the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(position, new Dimension(image.getWidth(), image.getHeight()));
	}

	/**
	 * Define how the laser move
	 */
	public abstract void setMoveStrategy();
	
	/**
	 * Set the laser position relative to the shooter
	 */
	public abstract void setPosition();
}