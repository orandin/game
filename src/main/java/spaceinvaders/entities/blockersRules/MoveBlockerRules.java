package spaceinvaders.entities.blockersRules;

import spaceinvaders.entities.Alien;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.Laser;
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
	public void moveBlockerRule(Laser laser, Alien alien) throws IllegalMoveException {
		kill(laser, alien);
		throw new IllegalMoveException();
	}

	/**
	 * Destroys the enemy
	 * @param laser
	 * @param alien
	 */
	protected void kill(Laser laser, Enemies alien){
		super.gameData.getUniverse().removeGameEntity(alien);
		super.gameData.getUniverse().removeGameEntity(laser);
		laser.getShooter().resetShoot();
	}
}
