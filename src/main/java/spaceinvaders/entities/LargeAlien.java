package spaceinvaders.entities;

import spaceinvaders.Level;
import gameframework.game.GameData;

/**
 * 
 * @author Kévin Rico
 * @author Simon Delberghe
 *
 */
public class LargeAlien extends Alien {

	/**
	 * Constructor
	 * @param gameData
	 * @param posX
	 * @param posY
	 */
	public LargeAlien(GameData gameData, int posX, int posY, Level lvl){
		super(gameData, posX, posY, lvl);
	}

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
	protected int score() {
		return 40;
	}

}
