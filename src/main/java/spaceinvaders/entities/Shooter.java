package spaceinvaders.entities;

import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

public abstract class Shooter extends EntiteMovable {

	//Constructor
	
	public Shooter(GameData data) {
		super(data);
	}

	//Getter
	
	public Point getPosition(){
		return super.position;
	}
	
	public DrawableImage getImage(){
		return this.image;
	}
	
	//Method
	public abstract boolean canShoot();
	public abstract void shoot();
}
