package spaceinvaders.entities.blockers;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

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

	/* ----- Attributes ----- */
	
	/**
	 * this class had 1 attribute
	 * - height : the height of the wall
	 */
	protected int height;
	protected Point pointWall;

	/* ----- Constructor ----- */
	
	/**
	 * Create a wall
	 * @param data The game data
	 */
	public Wall(GameData data) {
		height = data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize();
	}

	/* ----- Getter -----*/
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isMovable() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(pointWall, new Dimension(1, height));
	}

	/* ----- Method -----*/
	
	/* ----- unused ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {}
}
