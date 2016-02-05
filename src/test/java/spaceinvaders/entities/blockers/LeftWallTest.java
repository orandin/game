/**
 * 
 */
package spaceinvaders.entities.blockers;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * @author Simon Delberghe
 *
 */
public class LeftWallTest extends WallTest {

	@Override
	public Wall createWall(GameData data) {
		return new LeftWall(data);
	}

	@Override
	public Point test_getPointWall() {
		return new Point(0, 0);
	}

}
