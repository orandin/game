package spaceinvaders.entities;

import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
/**
 * this class represents the differents type of entities who can shoot in the game
 * @author 
 *
 */
public abstract class Shooter extends EntiteMovable {

	//Constructor
	
	/**
	 * constructor
	 * @param data : game data
	 */
	public Shooter(GameData data) {
		super(data);
	}

	//Getter
	
	/**
	 * getter for shooter position
	 * @return the position of the shooter
	 */
	public Point getPosition(){
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
