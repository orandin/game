package spaceinvaders.entities.blockersRules;

import spaceinvaders.entities.Alien;
import spaceinvaders.entities.Laser;
import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;

public class MoveBlockerRules extends MoveBlockerRulesApplierDefaultImpl {
	
	//when the laser hits an enemy
	
	public void moveBlockerRule(Laser laser, Alien alien) throws IllegalMoveException {
		kill(laser,alien);
		throw new IllegalMoveException();
	}
	
	private void kill(Laser laser, Alien alien){
		super.gameData.getUniverse().removeGameEntity(alien);
		super.gameData.getUniverse().removeGameEntity(laser);
		laser.getShooter().resetShoot();
	}
	
	//when the player hits an enemy
