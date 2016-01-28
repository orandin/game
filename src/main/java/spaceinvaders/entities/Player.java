package spaceinvaders.entities;

import gameframework.motion.MoveStrategyKeyboard8Dir;
import spaceinvaders.Game.Game;

public class Player extends AbstractEntity {
	
	/**
	 * Create the player
	 * @param game
	 * 		The game where the player is registered
	 */
	public Player(Game game)
	{
		super(game, game.getGameCanvas().getWidth(), game.getGameCanvas().getHeight(), 4, "../../images/player.png", 64, 42);
		super.moveDriver.setStrategy(new MoveStrategyKeyboard8Dir());
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// if player go left, decrement this.xPos by the player speed
		// else if player go right, increment this.xPos by the player speed
	}
}