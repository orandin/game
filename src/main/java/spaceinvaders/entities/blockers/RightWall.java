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
public class RightWall extends Wall {
	
	/* ----- Constructor ----- */
	
	/**
	 * Create the right wall
	 * @param data The game data
	 */
	public RightWall(GameData data) {
		super(data);
		int posX       = data.getConfiguration().getNbColumns() * data.getConfiguration().getSpriteSize();
		pointWall = new Point(posX, 0);
	}
}