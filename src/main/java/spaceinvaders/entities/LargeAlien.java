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
public class LargeAlien extends Alien {

	/**
	 * Create a large alien
	 * @param gameData
	 * 		The game data
	 * @param posX
	 * 		The initial x position
	 * @param posY
	 * 		The initial y position
	 */
	public LargeAlien(GameData gameData, int posX, int posY, Level lvl){
		super(gameData, posX, posY, lvl);
		super.image = new DrawableImage("../../images/entite/saucer3a.png", data.getCanvas());
		super.point = 40;
	}
}