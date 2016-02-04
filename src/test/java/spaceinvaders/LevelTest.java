package spaceinvaders;

import static org.junit.Assert.*;
import gameframework.drawing.GameUniverseViewPort;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.entities.Enemy;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.MediumAlienTest;
import spaceinvaders.entities.SmallAlien;

public class LevelTest {
	
	protected GameUniverseViewPort view;
	protected GameData gameData;
	protected Level level;
	protected Enemy enemy;
	
	@Before
	public void init() {
		view = new GameUniverseViewPortDefaultImpl();
		gameData = new GameData(new GameConfiguration());
		level = new Level(gameData, view);
	}

	@Test
	public void rulesToCreateEnemyTest() {
		int row = 1, posX = 200, posY = 200;
		init();
		
		enemy = level.rulesToCreateEnemy(row, posX, posY);
		assertEquals(LargeAlien.class, enemy.getClass());
		
		row = 2;
		enemy = level.rulesToCreateEnemy(row, posX, posY);
		assertEquals(MediumAlienTest.class, enemy.getClass());
		
		row = 3;
		enemy = level.rulesToCreateEnemy(row, posX, posY);
		assertEquals(MediumAlienTest.class, enemy.getClass());
		
		row = 4;
		enemy = level.rulesToCreateEnemy(row, posX, posY);
		assertEquals(SmallAlien.class, enemy.getClass());
	}
	
	@Test
	public void enemiesArrayTest() {
		int row = 1, posX = 200, posY = 200;
		init();
		enemy = level.rulesToCreateEnemy(row, posX, posY);
		assertNotNull(level.getEnemiesArray());
	}

}
