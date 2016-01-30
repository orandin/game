package spaceinvaders.entities;

import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class Shooter extends EntiteMovable {

	protected boolean canShoot;
	
	/**
	 * Create a shooter
	 * @param data
	 * 		The game data
	 */
	public Shooter(GameData data) {
		super(data);
	}

	/* ----- Getters ----- */
	/**
	 * Get the entity position
	 * @return the position
	 */
	public Point getPosition() {
		return super.position;
	}
	
	/**
	 * Get the entity sprite
	 * @return the sprite
	 */
	public DrawableImage getImage() {
		return this.image;
	}
	
	/* ----- Setters ----- */
	/**
	 * Allow the shooter to shoot again
	 */
	public void resetShoot() {
		this.canShoot = true;
	}
	
	/* ----- Booleans ----- */
	/**
	 * Check if the shooter can shoot
	 * @return {@code true} if he can, {@code false] else
	 */
	public boolean canShoot() {
		return this.canShoot;
	}
	
	/* ----- Actions ----- */
	/**
	 * Define how the shooter shoot
	 */
	public abstract void shoot();
}
