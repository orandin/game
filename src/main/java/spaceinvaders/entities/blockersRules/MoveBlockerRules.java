package spaceinvaders.entities.blockersRules;

import java.awt.Point;

import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.LargeAlien;
import spaceinvaders.entities.Laser;
import spaceinvaders.entities.MediumAlien;
import spaceinvaders.entities.SmallAlien;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class MoveBlockerRules extends MoveBlockerRulesApplierDefaultImpl {
	
	/**
	 * Defines the action when the laser touches an enemy
	 * @param laser
	 * 		The laser witch hit something
	 * @param ennemy
	 * 		The enemy witch is hit
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Laser laser, Enemies enemy, Point position) throws IllegalMoveException {
		kill(laser, enemy, position);
		throw new IllegalMoveException();
	}
	
	/**
	 * Collision detector for SmallAlien
	 * @param laser
	 * 		The laser witch hit something
	 * @param ennemy
	 * 		The enemy witch is hit
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Laser laser, SmallAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Enemies) alien, alien.getLocationInArray());
	}
	
	/**
	 * Collision detector for MediumAlien
	 * @param laser
	 * 		The laser witch hit something
	 * @param ennemy
	 * 		The enemy witch is hit
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Laser laser, MediumAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Enemies) alien, alien.getLocationInArray());
	}
	
	/**
	 * Collision detector for LargeAlien
	 * @param laser
	 * 		The laser witch hit something
	 * @param ennemy
	 * 		The enemy witch is hit
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Laser laser, LargeAlien alien) throws IllegalMoveException {
		moveBlockerRule(laser, (Enemies) alien, alien.getLocationInArray());
	}
	
	/**
	 * Destroy the enemy
	 * @param laser
	 * 		The laser witch is the destroyer
	 * @param alien
	 * 		The alien witch is destroy
	 * @param positionInArray
	 * 		The position of the alien in the AlienArray for removing correctly
	 */
	protected void kill(Laser laser, Enemies enemy, Point positionInArray) {
		enemy.getArray().increaseSpeed();
		enemy.getArray().removeEnemyFromPosition(positionInArray);
		super.gameData.getUniverse().removeGameEntity(enemy);
		super.gameData.getUniverse().removeGameEntity(laser);
		laser.getShooter().resetShoot();
		super.gameData.getScore().setValue(super.gameData.getScore().getValue() + enemy.score());
	}
}
