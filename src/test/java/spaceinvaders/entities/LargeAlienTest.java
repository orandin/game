package spaceinvaders.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargeAlienTest extends EnemyTest {

	@Override
	protected Enemy creatEnemy() {
		return this.enemy = new LargeAlien(this.gameData, 200, 200, this.level);
	}

	@Test
	public void largeAlienTest() {
		assertNotNull(this.enemy);
		assertEquals(LargeAlien.class, this.enemy.getClass());
	}

}
