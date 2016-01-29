package spaceinvaders.entities;

import gameframework.game.GameData;

/**
 * 
 * @author Kevin Rico
 * @author Simon Delberghe
 *
 */
public class SmallAlien extends Alien {
	
	
	/**
	 * Constructor
	 * @param data
	 * @param posX
	 * @param posY
	 */
	public SmallAlien(GameData data,int posX, int posY){
		super(data, posX,  posY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getUriImage() {
		return "../../images/entite/saucer1b.png";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected int score() {
		return 10;
	}
	
}
