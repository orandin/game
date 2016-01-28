package spaceinvaders.entities.blockers;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class RightWall extends Wall implements MoveBlocker{

	private Point point;
	public RightWall(GameData data) {
		super(data);
		int posX = data.getConfiguration().getNbColumns() * data.getConfiguration().getSpriteSize();
		this.point = new Point(posX, 0);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(this.point, new Dimension(1, super.height));
	}

}
