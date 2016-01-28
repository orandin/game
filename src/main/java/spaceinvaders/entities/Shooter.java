package spaceinvaders.entities;

import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

public abstract class Shooter extends EntiteMovable {

	protected boolean canShoot;
	
	//Constructor
	
	public Shooter(GameData data) {
		super(data);
	}

	//Getter
	
	public boolean canShoot(){
		return this.canShoot;
	}
	
	public Point getPosition(){
		return super.position;
	}
	
	public DrawableImage getImage(){
		return this.image;
	}
	
	//Method

	public void resetShoot(){
		this.canShoot = true;
	}
	
	public abstract void shoot();
}
