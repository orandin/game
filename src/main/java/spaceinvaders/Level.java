package spaceinvaders;

import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import spaceinvaders.entities.Alien;
import spaceinvaders.entities.EnemiesShooter;
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
	
	/* ---- Attributes ----- */
	
	/**
	 * this class had 3 attributes
	 * NB_CELLS : the default number of cell
	 * NB_ROWS : the default number of rows
	 * enemiesArray : the enemies array
	 */
	private final int NB_CELLS = 11;
	private final int NB_ROWS  = 5;
	private EnemiesArray enemiesArray;

	/* ----- Constructor ----- */
	
	/**
	 * Create the Level
	 * @param gameData
	 * 		The game data
	 * @param view
	 * 		The game universe
	 * @param player
	 * 		The player
	 */
	public Level(GameData gameData, GameUniverseViewPort view) {
		super(gameData);
		gameBoard = view;
		enemiesArray = new EnemiesArray(gameData);
	}

	/* ----- Getters ----- */
	
	/**
	 * getter for enemiesArray
	 * @return the enemies array
	 */
	public EnemiesArray getEnemiesArray(){
		return enemiesArray;
	}
	
	/* ----- Methods ----- */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init() {
		
		Player player = new Player(data);
		
		data.getUniverse().addGameEntity(new LeftWall(data));
		data.getUniverse().addGameEntity(new RightWall(data));
		data.getUniverse().addGameEntity(player);

		int posX = spriteSize * 5;
		int posY = posX;

		for(int row = 1; row <= NB_ROWS; row++){
			for(int cell = 1; cell <= NB_CELLS; cell++){
				EnemiesShooter enemy = rulesToCreateEnemy(row, posX, posY);
				enemiesArray.add(enemy);
				if(cell == NB_CELLS)
					posY += enemy.getImage().getHeight();
				else
					posX += enemy.getImage().getWidth();
			}
			posX = spriteSize * 5;
		}
		
	}
	
	/**
	 * Defines the rules to create an enemy by row
	 * @param row
	 * @param posX
	 * @param posY
	 * @return Returns the enemy created
	 */
	protected EnemiesShooter rulesToCreateEnemy(int row, int posX, int posY) {
		if(row == 1){
			return new Alien(super.data, 40, posX, posY, this);
		}
		if(row == 2 || row == 3){
			return new Alien(super.data, 20, posX, posY, this);
		}
		return new Alien(super.data, 10, posX, posY, this);
	}
	
	//methode pour reset le lvl pour l'instant non fonctionnel
	public void resetLevel(){
		data.getUniverse().removeAllGameEntities();
		init();
	}
}