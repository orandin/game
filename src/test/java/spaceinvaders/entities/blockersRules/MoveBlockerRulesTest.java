/**
 * 
 */
package spaceinvaders.entities.blockersRules;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dependencies.factories.GameDataFactory;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.motion.IllegalMoveException;
import spaceinvaders.Level;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.PlayerLaser;
import spaceinvaders.entities.SmallAlien;

/**
 * @author Simon Delberghe
 *
 */
public class MoveBlockerRulesTest {

	protected MoveBlockerRulesMock rules;
	protected GameData data;
	protected Player player;
	protected PlayerLaser pl;
	protected Level lvl;
	
	@Before
	public void init() {
		data = (new GameDataFactory()).createDefaultGameData();
		data.getUniverse().addGameEntity(new SmallAlien(data, 0, 0, null));
		
		player = new Player(data);
		pl     = new PlayerLaser(data, player);
		lvl    = new Level(data, new GameUniverseViewPortDefaultImpl());
		
		rules = new MoveBlockerRulesMock();
		rules.setGameData(data);
	}
	
	
	public void moveBlockerRuleAlienTest() {
		assertTrue(rules.isKill());
		rules.resetIsKill();
	}
	
	@Test
	public void moveBlockerRuleSmallAlienTest() {
		try {
			rules.moveBlockerRule(pl, new SmallAlien(data, 0, 0, lvl));
		} catch (IllegalMoveException e) {}
		
		moveBlockerRuleAlienTest();
	}
	
	@Test
	public void moveBlockerRuleMediumAlienTest() {
		try {
			rules.moveBlockerRule(pl, new MediumAlien(data, 0, 0, lvl));
		} catch (IllegalMoveException e) {}
		
		moveBlockerRuleAlienTest();
	}
	
	@Test
	public void moveBlockerRuleLargeAlienTest() {
		try {
			rules.moveBlockerRule(pl, new LargeAlien(data, 0, 0, lvl));
		} catch (IllegalMoveException e) {}
		
		moveBlockerRuleAlienTest();
	}
	
	@Test(expected=IllegalMoveException.class)
	public void moveBlockerRuleExceptionTest() throws IllegalMoveException {
		rules.moveBlockerRule(player, new SmallAlien(data, 0, 0, lvl));
	}
}
