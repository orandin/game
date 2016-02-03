package spaceinvaders.Game;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;
import gameframework.motion.blocking.MoveBlockerRulesApplier;

import java.io.IOException;

import spaceinvaders.Level;
import spaceinvaders.entities.Player;
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
		gameWindow = new GameWindow("space invaders", data.getCanvas(), data);
		gameWindow.createGUI();
		universeViewPort = new GameUniverseViewPortDefaultImpl(data);
		universeViewPort.setBackgroundImage("../../fond.png");

		MoveBlockerRulesApplier applier = new MoveBlockerRules();
		applier.setGameData(data);
		data.getMoveBlockerChecker().setMoveBlockerRules(applier);
		data.addLevel(new Level(data, universeViewPort,  new Player(this, data)));
	}

	/**
	 * Get the game data
	 * @return the game data
	 */
	public GameData getData() {
		return data;
	}

	/**
	 * End the game
	 */
	public void endGame() {
		universeViewPort.setBackgroundImage("../../game_over.png");
		universeViewPort.paint();
	}

	public static void main (String[] args) throws IOException {
		new Game().start();
	}
}
