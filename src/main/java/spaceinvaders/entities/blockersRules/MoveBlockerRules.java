package spaceinvaders.entities.blockersRules;

import spaceinvaders.entities.Alien;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.EnemyLaser;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.PlayerLaser;
import spaceinvaders.entities.SmallAlien;
import spaceinvaders.entities.blockers.LeftWall;
import spaceinvaders.entities.blockers.RightWall;
import spaceinvaders.entities.blockers.Wall;
import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;

/**
 *
 * @author Kévin Rico
 * @author Simon Delberghe
 * @author Théo Verschaeve
 *
 */
public class MoveBlockerRules extends MoveBlockerRulesApplierDefaultImpl {
	
	/**
	 * Defines the action when the player laser touches an enemy
	 * @param laser
	 * @param alien
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(PlayerLaser laser, Alien alien) throws IllegalMoveException {
		kill(laser, alien);
		throw new IllegalMoveException();
	}
	
	public void moveBlockerRule(PlayerLaser laser, SmallAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}
	
	public void moveBlockerRule(PlayerLaser laser, MediumAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}
	
	public void moveBlockerRule(PlayerLaser laser, LargeAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}
	/**
	 * Destroys the enemy
	 * @param laser
	 * @param alien
	 */
	protected void kill(PlayerLaser laser, Enemies alien){
		super.gameData.getUniverse().removeGameEntity(laser);
		
		System.out.println(alien.getLevel().getEnemiesArray().getEnemiesPositionInArray(alien));
		alien.getLevel().getEnemiesArray().remove(alien);
		laser.getShooter().resetShoot();
	}
	/**
	 * Defines the action when the enemy laser touches an enemy
	 * @param laser
	 * @param alien
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(EnemyLaser laser, Alien alien){
		
	}
	public void moveBlockerRule(EnemyLaser laser, SmallAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}
	
	public void moveBlockerRule(EnemyLaser laser, MediumAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}
	
	public void moveBlockerRule(EnemyLaser laser, LargeAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Alien) alien);
	}
	
	/**
	 * Defines the action when the enemies laser touches a player
	 * @param player
	 * @param laser
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Player player, EnemyLaser laser) throws IllegalMoveException {
		super.gameData.decreaseLife(1);
		super.gameData.getUniverse().removeGameEntity(laser);
		throw new IllegalMoveException();
	}
	
	/**
	 * Defines the action when the enemies touches a wall
	 * @param player
	 * @param laser
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Alien alien, Wall wall) throws IllegalMoveException{
		throw new IllegalMoveException();
	}
	public void moveBlockerRule(SmallAlien alien, RightWall wall) throws IllegalMoveException {
		moveBlockerRule((Alien) alien, wall);
	}
	
	public void moveBlockerRule(MediumAlien alien, RightWall wall) throws IllegalMoveException {
		moveBlockerRule((Alien) alien, wall);
	}
	
	public void moveBlockerRule(LargeAlien alien, RightWall wall) throws IllegalMoveException {
		moveBlockerRule((Alien) alien, wall);
	}
	
}
