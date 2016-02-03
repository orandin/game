package spaceinvaders;

import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import spaceinvaders.entities.AliensArray;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.blockers.LeftWall;
import spaceinvaders.entities.blockers.RightWall;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class Level extends GameLevelDefaultImpl {

	protected Player player;

	/**
	 * Create the Level
	 * @param gameData The game data
	 * @param view The game universe
	 * @param player The player
	 */
	public Level(GameData gameData, GameUniverseViewPort view, Player player) {
		super(gameData);
		gameBoard = view;
		this.player = player;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init() {
		Player player = this.player;

		data.getUniverse().addGameEntity(new LeftWall(data));
		data.getUniverse().addGameEntity(new RightWall(data));
		data.getUniverse().addGameEntity(player);

		//Now the only thing we have to register is the array witch contains all enemies
		data.getUniverse().addGameEntity(new AliensArray(data));	
	}
}
