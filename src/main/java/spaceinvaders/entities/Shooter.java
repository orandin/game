package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;


/**
 * 
 * @author Kevin Rico
 * @author Benjamin Szczapa
 *
 */
public abstract class Shooter extends MovableEntity {

	protected boolean canShoot;
	
	/**
	 * Constructor
	 * @param data
	 */
	public Shooter(GameData data) {
		super(data);
	}
	
	/**
	 * Boolean that say if the shooter can shoot or not
	 * @return 
	 */
	public boolean canShoot(){
		return this.canShoot;
	}
	
	/**
	 * @return the image of the shooter
	 */
	public DrawableImage getImage(){
		return this.image;
	}

	/**
	 * Method that reset the shoot of the shooter. The player can shoot again.
	 */
	public void resetShoot(){
		this.canShoot = true;
	}
	
	/**
	 * Method that allow a shooter to shoot.
	 */
	public abstract void shoot();
}
