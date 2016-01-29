package spaceinvaders.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import spaceinvaders.entities.playerEntry.PlayerCommande;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.SpeedVector;

/**
 * 
 * @author Benjamin Szczapa
 * @author Kevin Rico
 *
 */
public class Player extends Shooter{
	
	/**
	 * Constructor
	 * @param data
	 */
	public Player(GameData data) {
		super(data);
		
		// Picture for the main ship
		super.image = new DrawableImage("../../images/entite/player1.png", data.getCanvas());
		
		// Player's position initialisation
		int posX = this.config.getNbColumns() / 2; //position au milieu du canvas
		int posY = this.config.getNbRows() - (this.config.getNbRows() / 6) ; //position en bas du joueur
		super.setPosition(new Point(posX * super.config.getSpriteSize(), posY * super.config.getSpriteSize()));
		
		// strategy initialisation
		MoveStrategyKeyboard str = new MoveStrategyKeyboard(false, new SpeedVector(new Point(0,0), 12));
		
		// Remove 'Up' and 'Down' keys
		str.addKeyDirection(KeyEvent.VK_UP, new Point(0, 0));
		str.addKeyDirection(KeyEvent.VK_DOWN, new Point(0, 0));
		
		// We add the strategy to moverider et we add a KeyListener to the game canvas for the keys to be taken in count
		super.moveDriver.setStrategy(str);
		data.getCanvas().addKeyListener(str);
		// We add a KeyListener for the shot key
		data.getCanvas().addKeyListener(new PlayerCommande(this));
		super.canShoot = true;
	}

	/**
	 * @return The dimension of the game.
	 */
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(this.image.getWidth(), this.image.getHeight()));
	}
	
	// Methods
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO
	}
	
	/**
	 * Method that allow the player to shoot at enemies.
	 */
	@Override
	public void shoot(){
		if(super.canShoot){
			super.data.getUniverse().addGameEntity(new Laser(super.data, this, true));
			super.canShoot = false;
		}
	}
	
}