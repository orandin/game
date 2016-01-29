package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;


public class Alien1 extends Alien {
	
	private static final int POINT = 10;
	
	//Constructor
	public Alien1(GameData data,int posX, int posY){
		super(data,posX, posY);
		super.image = new DrawableImage("../../images/entite/saucer1b.png", super.data.getCanvas());
		super.point = POINT;
	}

	
}
