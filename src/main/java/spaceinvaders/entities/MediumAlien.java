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
public class MediumAlien extends Alien {
	
	/**
	 * Create a medium alien
	 * @param gameData
	 * 		The game data
	 * @param posX
	 * 		The initial x position
	 * @param posY
	 * 		The initial y position
	 */
	public MediumAlien(GameData gameData, int posX, int posY, Level lvl) {
		super(gameData, posX, posY, lvl);
		image = new DrawableImage("../../images/entite/saucer2a.png", data.getCanvas());
		point = 20;
	}

}