package spaceinvaders.entities;

import java.awt.Point;

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
	public LargeAlien(GameData gameData, int posX, int posY, EnnemiesArray array) {
		super(gameData, posX, posY, array);
		//Calculate the position on screen with this row and column
		super.setPosition(new Point(posX * this.image.getWidth(), posY * this.image.getHeight()));
	}
	
	/* ----- Getters ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getUriImage() {
		return "../../images/entite/saucer3a.png";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int score() {
		return 40;
	}
}