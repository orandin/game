package spaceinvaders.entities.blockersRules;

import spaceinvaders.entities.Alien1;
import spaceinvaders.entities.Alien2;
import spaceinvaders.entities.Alien3;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.Laser;
import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;

public class MoveBlockerRules extends MoveBlockerRulesApplierDefaultImpl {
	
	/**
	 * Methods that define the hitbox of the enemies. If a laser hit an enemy, the kill method is called.
	 * @param laser
	 * @param alien
	 * @throws IllegalMoveException
	 */
	public void moveBlockerRule(Laser laser, Alien1 alien) throws IllegalMoveException {
		kill(laser,(Enemies) alien);
		throw new IllegalMoveException();
	}
	public void moveBlockerRule(Laser laser, Alien2 alien) throws IllegalMoveException {
		kill(laser,(Enemies) alien);
		throw new IllegalMoveException();
	}
	public void moveBlockerRule(Laser laser, Alien3 alien) throws IllegalMoveException {
		kill(laser,(Enemies) alien);
		throw new IllegalMoveException();
	}
	
	/**
	 * Method that kill an enemy when he is hit by a laser's player.
	 * @param laser
	 * @param alien
	 */
	private void kill(Laser laser, Enemies alien){
		super.gameData.getUniverse().removeGameEntity(alien);
		super.gameData.getUniverse().removeGameEntity(laser);
		laser.getShooter().resetShoot();
	}
	
}
