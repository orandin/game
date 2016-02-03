package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import spaceinvaders.Game.Game;
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

	protected Game game;

	/**
	 * Create the player
	 * @param data	The game data
	 */
	public Player(Game game, GameData data) {
		super(data);
		
		//Main ship sprite
		image = new DrawableImage(getSprite(), data.getCanvas());
		
		//Initializing initial player position
		int posX = (config.getNbColumns() / 2) - 1; //Player is positionned on the middle of the canvas
		int posY = config.getNbRows() - (config.getNbRows() / 6) ; //And in the bottom of the screen
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
		canShoot = true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Rectangle getBoundingBox() {
		return new Rectangle(position, new Dimension(image.getWidth(), image.getHeight()));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSprite() {
		return "../../images/entite/player1.png";
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void shoot() {
		if(canShoot) {
			data.getUniverse().addGameEntity(new Laser(data, this));
			canShoot = false;
		}
	}
	
	/**
	 * Hurt the player by one life point
	 */
	public void hurt() {
		data.decreaseLife(1);
		
		if (data.getLife().getValue() <= 0)
			game.endGame();
	}
}