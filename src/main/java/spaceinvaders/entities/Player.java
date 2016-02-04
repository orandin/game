package spaceinvaders.entities;

import java.awt.Point;
import java.awt.event.KeyEvent;

import spaceinvaders.entities.playerEntry.PlayerCommande;
import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.SpeedVector;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class Player extends Shooter {

	/* ----- Attributes ----- */
	
	/**
	 * this class had 1 attributes
	 * - canShoot : boolean to know if the player can shoot or not
	 */
	private boolean canShoot = true;

	/* ----- Constructor ----- */
	
	/**
	 * Create the player
	 * @param data
	 * 		The game data
	 */
	public Player(GameData data) {
		super(data);

		//Main ship sprite
		image = new DrawableImage("../../images/entite/player1.png", data.getCanvas());

		//Initializing initial player position
		int posX = (config.getNbColumns() / 2) - 1; //Player is positionned on the middle of the canvas
		int posY = config.getNbRows() - (config.getNbRows() / 4) ; //And in the bottom of the screen
		super.setPosition(new Point(posX * config.getSpriteSize(), posY * config.getSpriteSize()));

		//Seting the moveStrategy
		MoveStrategyKeyboard str = new MoveStrategyKeyboard(false, new SpeedVector(new Point(0, 0), 12));

		//Deletion UP and DOWN keys
		str.addKeyDirection(KeyEvent.VK_UP, new Point(0, 0));
		str.addKeyDirection(KeyEvent.VK_DOWN, new Point(0, 0));

		//on ajoute la strategie au movedriver et on ajoute un KeyListener au canvas du jeu pour que les touches soit prises en compte
		moveDriver.setStrategy(str);
		data.getCanvas().addKeyListener(str);
		//Add KeyListener for shooting key
		data.getCanvas().addKeyListener(new PlayerCommande(this));
	}
	
	/* ----- Methods ----- */
	
	/**
	 * {@inheritDoc}
	 */
	public boolean canShoot(){
		return canShoot;
	}

	/**
	 * when a target is touch or when the laser arrive at the top of screen allows to be able to shoot again
	 */
	public void resetShoot(){
		canShoot = true;	
	}

	/**
	 * {@inheritDoc}
	 */
	public void shoot(){
		if(canShoot()){
			data.getUniverse().addGameEntity(new PlayerLaser(data, this));
			canShoot = false;
		}		
	}

	/* ----- unused ----- */
	/**
	 * action to do after a move
	 */
	@Override
	public void oneStepMoveAddedBehavior() {}

}