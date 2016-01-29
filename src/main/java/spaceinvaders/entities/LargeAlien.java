package spaceinvaders.entities;

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
	public LargeAlien(GameData gameData, int posX, int posY){
		super(gameData, posX, posY);
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
	public int score() {
		return 40;
	}

}
