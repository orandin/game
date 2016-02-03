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
	
	protected boolean canShoot = true;
	
	//Constructor
	
	/**
	 * Create the player
	 * @param data
	 * 		The game data
	 */
	public Player(GameData data) {
		super(data);
		
		//Main ship sprite
		super.image = new DrawableImage("../../images/entite/player1.png", data.getCanvas());
		
		//Initializing initial player position
		int posX = (this.config.getNbColumns() / 2) - 1; //Player is positionned on the middle of the canvas
		int posY = this.config.getNbRows() - (this.config.getNbRows() / 6) ; //And in the bottom of the screen
		super.setPosition(new Point(posX * super.config.getSpriteSize(), posY * super.config.getSpriteSize()));
		
		//Seting the moveStrategy
		MoveStrategyKeyboard str = new MoveStrategyKeyboard(false, new SpeedVector(new Point(0, 0), 12));
		
		//Deletion UP and DOWN keys
		str.addKeyDirection(KeyEvent.VK_UP, new Point(0, 0));
		str.addKeyDirection(KeyEvent.VK_DOWN, new Point(0, 0));
		
		//on ajoute la strategie au movedriver et on ajoute un KeyListener au canvas du jeu pour que les touches soit prises en compte
		super.moveDriver.setStrategy(str);
		data.getCanvas().addKeyListener(str);
		//Add KeyListener for shooting key
		data.getCanvas().addKeyListener(new PlayerCommande(this));
	}

	//Getter

	public boolean canShoot(){
		return this.canShoot;
	}
	
	public void resetShoot(){
	 this.canShoot = true;	
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(this.image.getWidth(), this.image.getHeight()));
	}
	
	public void shoot(){
		if(this.canShoot){
			super.data.getUniverse().addGameEntity(new PlayerLaser(super.data, this));
			this.canShoot = false;
		}
	}
	
}