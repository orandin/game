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
	
	//Constructor
	public Shooter(GameData data) {
		super(data);
	}

	//Getter
	
	public boolean canShoot(){
		return this.canShoot;
	}
	
	public DrawableImage getImage(){
		return this.image;
	}
	
	//Methods

	public void resetShoot(){
		this.canShoot = true;
	}
	
	public abstract void shoot();
}
