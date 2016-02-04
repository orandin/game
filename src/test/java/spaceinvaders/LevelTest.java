package spaceinvaders;

import static org.junit.Assert.*;
import gameframework.drawing.GameUniverseViewPort;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.entities.Alien;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.SmallAlien;

public class LevelTest {
	
	GameUniverseViewPort view;
	GameData gameData;
	GameConfiguration config;
	Level level;
	Enemies enemy;
	
	@Before
	public void init() {
		view = new GameUniverseViewPortDefaultImpl();
		config = new GameConfiguration();
		gameData = new GameData(config);
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
		assertEquals(MediumAlien.class, enemy.getClass());
		row = 3;
		enemy = level.rulesToCreateEnemy(row, posX, posY);
		assertEquals(MediumAlien.class, enemy.getClass());
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
