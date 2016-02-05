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

	/* ----- Constructor ----- */
	
	/**
	 * Create a shooter
	 * @param data
	 * 		The game data
	 */
	public Shooter(GameData data) {
		super(data);
	}

	/* ----- Getter -----*/
	
	/**
	 * Get the entity position
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}
	
	/**
	 * getter for the entitie image
	 * @return the entitie image
	 */
	public DrawableImage getImage(){
		return image;
	}
	
	/* ----- Method ----- */
	
	/**
	 * @return <code>true</code> if the shooter can shoot <code>false</code> else
	 */
	public abstract boolean canShoot();

	/**
	 * method call by the shooter to shoot
	 */
	public abstract void shoot();
}
