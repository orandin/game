/**
 * 
 */
package spaceinvaders.entities.blockers;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import gameframework.game.GameData;

/**
 * @author Simon Delberghe
 *
 */
public class RightWallTest extends WallTest {

	@Override
	public Wall createWall(GameData data) {
		return new RightWall(data);
	}

	@Override
	public Point test_getPointWall() {
		int posX = data.getConfiguration().getNbColumns() * data.getConfiguration().getSpriteSize();
		return new Point(posX, 0);
	}

}
