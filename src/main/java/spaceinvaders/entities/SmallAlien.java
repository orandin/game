package spaceinvaders.entities;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * @author Matthieu Lepers
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
	public SmallAlien(GameData data,int posX, int posY, EnnemiesArray array){
		super(data, posX,  posY, array);
		//Calculate the position on screen with this row and column
		super.setPosition(new Point(posX * this.image.getWidth(), posY * this.image.getHeight()));
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
	public int score() {
		return 10;
	}
	
}
