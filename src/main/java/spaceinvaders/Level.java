package spaceinvaders;

import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import spaceinvaders.entities.EnnemiesArray;
import spaceinvaders.entities.Player;
import spaceinvaders.entities.blockers.LeftWall;
import spaceinvaders.entities.blockers.RightWall;

/**
 * @author Kevin Rico
 * @author Simon Delberghe
 * @author Matthieu Lepers
 */
public class Level extends GameLevelDefaultImpl {
	
	/**
	 * Constructor
	 * @param gameData
	 * @param view
	 */
	public Level(GameData gameData, GameUniverseViewPort view){
		super(gameData);
		super.gameBoard = view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init() {
		Player player = new Player(super.data);
		
		data.getUniverse().addGameEntity(new LeftWall(data));
		data.getUniverse().addGameEntity(new RightWall(data));
		data.getUniverse().addGameEntity(player);
		
		//Now the only thing we have to register is the array witch contains all enemies
		data.getUniverse().addGameEntity(new EnnemiesArray(data));	
	}
}
