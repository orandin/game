package spaceinvaders.entities.blockersRules;

import spaceinvaders.entities.Alien1;
import spaceinvaders.entities.Alien2;
import spaceinvaders.entities.Alien3;
import spaceinvaders.entities.Enemies;
import spaceinvaders.entities.Laser;
import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;

public class MoveBlockerRules extends MoveBlockerRulesApplierDefaultImpl {
	
	// When the laser hit an enemy
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
	
	// When the player hit an enemy (Enemy die)
	private void kill(Laser laser, Enemies alien){
		super.gameData.getUniverse().removeGameEntity(alien);
		super.gameData.getUniverse().removeGameEntity(laser);
		laser.getShooter().resetShoot();
	}
	
}
