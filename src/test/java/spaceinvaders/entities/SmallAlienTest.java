package spaceinvaders.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class SmallAlienTest extends EnemyTest {

	@Override
	protected Enemy creatEnemy() {
		return this.enemy = new SmallAlien(this.gameData, 200, 200, this.level);
	}

	@Test
	public void smallAlienTest() {
		assertNotNull(this.enemy);
		assertEquals(SmallAlien.class, this.enemy.getClass());
	}

}
