package spaceinvaders.entities.blockersRules;

import spaceinvaders.entities.Alien1;
import spaceinvaders.entities.Alien2;
import spaceinvaders.entities.Alien3;
import spaceinvaders.entities.Enemys;
import spaceinvaders.entities.Laser;
import gameframework.motion.IllegalMoveException;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;

public class MoveBlockerRules extends MoveBlockerRulesApplierDefaultImpl {
	
	//quand le laser touche un enemie
	
	public void moveBlockerRule(Laser laser, Alien1 alien) throws IllegalMoveException {
		kill(laser,(Enemys) alien);
		throw new IllegalMoveException();
	}
	public void moveBlockerRule(Laser laser, Alien2 alien) throws IllegalMoveException {
		kill(laser,(Enemys) alien);
		throw new IllegalMoveException();
	}
	public void moveBlockerRule(Laser laser, Alien3 alien) throws IllegalMoveException {
		kill(laser,(Enemys) alien);
		throw new IllegalMoveException();
	}
	
	private void kill(Laser laser, Enemys alien){
		super.gameData.getUniverse().removeGameEntity(alien);
		super.gameData.getUniverse().removeGameEntity(laser);
		laser.getShooter().resetShoot();
	}
	
	//quand un le joueur touche un enemie
	
	
}
