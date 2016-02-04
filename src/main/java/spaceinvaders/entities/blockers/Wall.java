package spaceinvaders.entities.blockers;

import java.awt.Graphics;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public abstract class Wall implements MoveBlocker, GameEntity {

	/**
	 * this class had 1 attribute
	 * - height : the height of the wall
	 */
	protected int height;
	
	/**
	 * Create a wall
	 * @param data
	 * 		The game data
	 */
	public Wall(GameData data) {
		height = data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize();
	}

	/* ----- Boolean ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isMovable() {
		return false;
	}

	/* ----- Drawing ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {}
}
