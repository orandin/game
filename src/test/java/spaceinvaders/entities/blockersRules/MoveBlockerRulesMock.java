/**
 * 
 */
package spaceinvaders.entities.blockersRules;

import spaceinvaders.entities.EnemiesShooter;
import spaceinvaders.entities.PlayerLaser;

/**
 * @author Simon Delberghe
 *
 */
public class MoveBlockerRulesMock extends MoveBlockerRules {

	protected boolean isKill = false;
	
	@Override
	protected void kill(PlayerLaser laser, EnemiesShooter alien){
		isKill = true;
	}
	
	public boolean isKill() {
		return isKill;
	}
	
	public void resetIsKill() {
		isKill = false;
	}
}
