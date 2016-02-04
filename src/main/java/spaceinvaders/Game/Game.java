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
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class Game extends GameDefaultImpl {
	
	protected GameWindow gameWindow;
	protected GameUniverseViewPortDefaultImpl universeViewPort;
	protected Thread livesChecker;
	
	/**
	 * Create the game
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

	public void endOfGame(){
		this.universeViewPort.setBackgroundImage("../../game_over.png");
		this.universeViewPort.paint();
	}
	
	public static void main (String[] args) throws IOException{
		Game game = new Game();
		game.start();
		game.endOfGame();
	}
}