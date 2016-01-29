package spaceinvaders.entities;

import gameframework.game.GameData;

/**
 * 
 * @author Kevin Rico
 * @author Simon Delberghe
 *
 */
public class MediumAlien extends Alien {
	
	/**
	 * Constructor
	 * @param gameData
	 * @param posX
	 * @param posY
	 */
	public MediumAlien(GameData gameData, int posX, int posY) {
		super(gameData, posX, posY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getUriImage() {
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
