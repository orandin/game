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
	 * @param gameData The game data
	 * @param posX	The initial x position
	 * @param posY	The initial y position
	 */
	public LargeAlien(GameData gameData, int posX, int posY, EnemiesArray enemiesArray) {
		super(gameData, posX, posY, enemiesArray);
		//Calculate the position on screen with this row and column
		super.setPosition(new Point(posX * image.getWidth(), posY * image.getHeight()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSprite() {
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
