/**
 * 
 */
package spaceinvaders.entities.blockers;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import dependencies.factories.GameDataFactory;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

/**
 * @author Simon Delberghe
 *
 */
public abstract class WallTest {

	protected Wall wall;
	protected GameData data;
	
	@Before 
	public void init() {
		data = (new GameDataFactory()).createDefaultGameData();  
		wall = createWall(data);
	}
	
	public abstract Wall createWall(GameData data);
	
	public abstract Point test_getPointWall();
		
	/**
	 * Test method for {@link spaceinvaders.entities.blockers.Wall#isMovable()}.
	 */
	@Test
	public void testIsMovable() {
		assertFalse(wall.isMovable());
	}

	/**
	 * Test method for {@link spaceinvaders.entities.blockers.Wall#getBoundingBox()}.
	 */
	@Test
	public void testGetBoundingBox() {
		int height = data.getConfiguration().getNbRows() * data.getConfiguration().getSpriteSize();
		Rectangle expected = new Rectangle(test_getPointWall(), new Dimension(1, height));
		
		assertEquals(expected, wall.getBoundingBox());
	}

}
