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
	public MediumAlien(GameData gameData, int posX, int posY, EnnemiesArray array) {
		super(gameData, posX, posY, array);
		//Calculate the position on screen with this row and column
		super.setPosition(new Point(posX * this.image.getWidth(), posY * this.image.getHeight()));
	}
	
	/* ----- Getters ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSprite() {
		return "../../images/entite/saucer2a.png";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int score() {
		return 20;
	}
}