package spaceinvaders.entities;

import spaceinvaders.Level;
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
	public MediumAlien(GameData gameData, int posX, int posY, Level lvl) {
		super(gameData, posX, posY, lvl);
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
	protected int score() {
		return 20;
	}

}
