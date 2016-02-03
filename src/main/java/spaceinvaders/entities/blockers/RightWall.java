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
public class RightWall extends Wall {

	private Point point;
	
	/**
	 * Create the right wall
	 * @param data
	 * 		The game data
	 */
	public RightWall(GameData data) {
		super(data);
		int posX = data.getConfiguration().getNbColumns() * data.getConfiguration().getSpriteSize();
		this.point = new Point(posX, 0);
	}

	/* ----- Getters ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(this.point, new Dimension(1, super.height));
	}
}