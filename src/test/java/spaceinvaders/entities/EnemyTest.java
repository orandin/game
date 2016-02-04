package spaceinvaders.entities;

import static org.junit.Assert.*;
import gameframework.drawing.GameUniverseViewPort;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.EnemiesArray;
import spaceinvaders.Level;


public abstract class EnemyTest {

	protected GameUniverseViewPort view;
	protected GameData gameData;
	protected Level level;
	protected Enemy enemy;
	
	@Before 
	public void init() {
		view = new GameUniverseViewPortDefaultImpl();
		gameData = new GameData(new GameConfiguration());
		level = new Level(gameData, view);
		enemy = creatEnemy();
	}
	
	protected abstract Enemy creatEnemy();
	
	@Test
	public void getLevelTest() {
		assertSame(this.level, this.enemy.getLevel());
	}

}
