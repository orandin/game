package spaceinvaders.entities.blockersRules;

import spaceinvaders.entities.Alien;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.Laser;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.PlayerLaser;
import spaceinvaders.entities.SmallAlien;
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
	 * Defines the action when the laser touches an enemy
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
}
