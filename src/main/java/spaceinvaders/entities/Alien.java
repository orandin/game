package spaceinvaders.entities;

import spaceinvaders.Game.Game;

public class Alien extends Ennemy {
	
	public Alien(Game game, int initialXPos, int initialYPos, int lifePoints, int reward) {
		super(game, initialXPos, initialYPos, 1, "../../images/alien" + lifePoints + ".png", 22, 20, lifePoints, reward);
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}
}