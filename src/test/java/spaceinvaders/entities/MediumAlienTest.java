package spaceinvaders.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class MediumAlienTest extends EnemyTest {

	@Override
	protected Enemy creatEnemy() {
		return this.enemy = new MediumAlien(this.gameData, 200, 200, this.level);
	}

	@Test
	public void mediumAlienTest() {
		assertNotNull(this.enemy);
		assertEquals(MediumAlien.class, this.enemy.getClass());
	}

}
