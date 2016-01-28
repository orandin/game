package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

public class Alien2 extends Enemys{

	private static final int POINT = 20;
	
	public Alien2(GameData gameData, int posX, int posY) {
		super(gameData, posX, posY);
		super.image = new DrawableImage("../../images/entite/saucer2a.png", super.data.getCanvas());
		super.point = POINT;
	}

}
