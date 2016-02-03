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
	 * getter for the entitie image
	 * @return the entitie image
	 */
	public DrawableImage getImage(){
		return super.image;
	}
	
	//Method
	
	public abstract boolean canShoot();
	public abstract void shoot();
}
