package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class Alien extends Enemy {

	/**
	 * Create an alien
	 * @param data	The game data
	 * @param posX	The initial x position where it spawn
	 * @param posY	The initial y position where it spawn
	 * @param array	The array when the alien is, this is for movement
	 */
	public Alien(GameData data,int posX, int posY, EnemiesArray array) {
		super(data, posX, posY, array);
		image = new DrawableImage(getSprite(), data.getCanvas());
		point = score();
	}
}
