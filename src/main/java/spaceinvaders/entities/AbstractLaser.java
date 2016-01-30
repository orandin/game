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
	 * @param data
	 * 		The game data
	 * @param shooter
	 * 		The laser's shooter
	 */
	public AbstractLaser(GameData data, Shooter shooter) {
		super(data);
		this.image = this.getUrlImage();
		this.shooter = shooter;
		
		this.setPosition();
		this.setMoveStrategy();
	}
	
	/* ----- Getters ----- */
	/**
	 * Get the sprite as a Drawable image
	 * @return a drawable image
	 */
	public abstract DrawableImage getUrlImage();
	
	/**
	 * Get the laser's shooter
	 * @return the shooter
	 */
	public Shooter getShooter() {
		return this.shooter;
	}
	
	/**
	 * Get the bounding box of the laser
	 * @return the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(this.image.getWidth(), this.image.getHeight()));
	}
	
	/* ----- Setters ----- */
	/**
	 * Define how the laser move
	 */
	public abstract void setMoveStrategy();
	
	/**
	 * Set the laser position relative to the shooter
	 */
	public abstract void setPosition();
}