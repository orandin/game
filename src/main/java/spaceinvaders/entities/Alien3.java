package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

public class Alien3 extends Enemies{

	private static final int POINT = 40;
	
	// Constructor
	public Alien3(GameData gameData, int posX, int posY){
		super(gameData, posX, posY);
		super.image = new DrawableImage("../../images/entite/saucer3a.png", super.data.getCanvas());
		super.point = POINT;
	}

}
