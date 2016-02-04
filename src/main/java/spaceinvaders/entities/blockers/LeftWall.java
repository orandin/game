package spaceinvaders.entities.blockers;

import gameframework.game.GameData;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class LeftWall extends Wall {

	/* ----- Constructor ----- */
	
	/**
	 * Create the left wall
	 * @param data
	 * 		The game data
	 */
	public LeftWall(GameData data) {
		super(data);
	}
	
	/* ----- Getters ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(new Point(0,0), new Dimension(1, height));
	}
}