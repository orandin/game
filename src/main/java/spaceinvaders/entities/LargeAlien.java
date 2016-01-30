package spaceinvaders.entities;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * @author Matthieu Lepers
 * @author Kevin Rico
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
	public LargeAlien(GameData gameData, int posX, int posY, EnnemiesArray array){
		super(gameData, posX, posY, array);
		//Calculate the position on screen with this row and column
		super.setPosition(new Point(posX * this.image.getWidth(), posY * this.image.getHeight()));
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
