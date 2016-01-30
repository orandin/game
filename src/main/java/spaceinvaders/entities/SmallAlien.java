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
public class SmallAlien extends Alien {
	
	/**
	 * Create a small alien
	 * @param data
	 * 		The game data
	 * @param posX
	 * 		The initial x position
	 * @param posY
	 * 		The initial y position
	 */
	public SmallAlien(GameData data,int posX, int posY, EnnemiesArray array){
		super(data, posX,  posY, array);
		//Calculate the position on screen with this row and column
		super.setPosition(new Point(posX * this.image.getWidth(), posY * this.image.getHeight()));
	}
	
	/* ----- Getters ----- */
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