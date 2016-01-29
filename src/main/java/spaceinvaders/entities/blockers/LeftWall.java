package spaceinvaders.entities.blockers;

import gameframework.game.GameData;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class LeftWall extends Wall {

	/**
	 * Constructor
	 * @param data
	 */
	public LeftWall(GameData data) {
		super(data);
	}

	/**
	 * @return The bound of the left wall.
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(new Point(-1,0), new Dimension(1, super.height));
	}

}
