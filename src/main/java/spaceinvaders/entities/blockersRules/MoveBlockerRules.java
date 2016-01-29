package spaceinvaders.entities.blockersRules;

import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.Laser;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.SmallAlien;

/**
 *
 * @author Kévin Rico
 * @author Simon Delberghe
 *
 */
public class MoveBlockerRules extends MoveBlockerRulesApplierDefaultImpl {
	
	/**
	 * Defines the action when the laser touches an enemy
	 * @param laser
	 * @param ennemy
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Laser laser, Enemies enemy) throws IllegalMoveException {
		kill(laser, enemy);
		throw new IllegalMoveException();
	}
	
	public void moveBlockerRule(Laser laser, SmallAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Enemies) alien);
	}
	
	public void moveBlockerRule(Laser laser, MediumAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Enemies) alien);
	}
	
	public void moveBlockerRule(Laser laser, LargeAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Enemies) alien);
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
		super.gameData.getScore().setValue(super.gameData.getScore().getValue() + alien.score());
	}
}
