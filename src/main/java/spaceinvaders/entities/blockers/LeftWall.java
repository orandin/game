package spaceinvaders.entities.blockers;

import gameframework.game.GameData;

import java.awt.Point;

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
		this.pointWall = new Point(-1, 0);
	}
}
