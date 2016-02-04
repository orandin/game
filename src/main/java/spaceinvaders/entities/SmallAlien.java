package spaceinvaders.entities;

import spaceinvaders.Level;
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
public class SmallAlien extends Alien {

	/**
	 * Create a small alien
	 * @param data The game data
	 * @param posX The initial x position
	 * @param posY The initial y position
	 */	
	public SmallAlien(GameData data,int posX, int posY, Level lvl){
		super(data, posX,  posY, lvl);
		point = 10;
		image = new DrawableImage("../../images/entite/saucer2a.png", data.getCanvas());
	}

}
