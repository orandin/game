package spaceinvaders.Game;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;
import gameframework.motion.blocking.MoveBlockerRulesApplier;

import java.io.IOException;

import spaceinvaders.Level;
import spaceinvaders.entities.blockersRules.MoveBlockerRules;

/**
 * 
 * @author Benjamin Szczapa
 *
 */
public class Game extends GameDefaultImpl{
	
	private GameWindow gameWindow;
	protected GameUniverseViewPortDefaultImpl universeViewPort;
	
	/**
	 * Method that define the main features of the game.
	 */
	public Game() {
		super(new GameData(new GameConfiguration()));
		this.gameWindow = new GameWindow("space invaders", this.data.getCanvas(), this.data);
		this.gameWindow.createGUI();
		this.universeViewPort = new GameUniverseViewPortDefaultImpl(this.data);
		this.universeViewPort.setBackgroundImage("../../fond.png");
		
		MoveBlockerRulesApplier applier = new MoveBlockerRules();
		applier.setGameData(data);
		this.data.getMoveBlockerChecker().setMoveBlockerRules(applier);
		this.data.addLevel(new Level(this.data, this.universeViewPort));
	}
	
	public GameUniverseViewPortDefaultImpl getUniverseViewPort() {
		return this.universeViewPort;
	}

	/**
	 * Main method.
	 * @param args
	 * @throws IOException
	 */
	public static void main (String[] args) throws IOException{
		Game game = new Game();
		game.start();
		
		while(!game.data.getEndOfGame().getValue()) {
			/**
			 * End of the game if the plyer's life is 0.
			 */
			if(game.data.getLife().getValue() <= 0) {
				game.data.getEndOfGame().setValue(true);
			}
			/**
			 * TODO: check if the player is hit by an enemy shot and decrease his life to 1.
			 */
			if(true) {
				game.data.decreaseLife(1);
			}
		}
		
		/**
		 * Modify the background image with a game over screen.
		 */
		game.getUniverseViewPort().setBackgroundImage("../../game_over.png");
		
	}
	

}