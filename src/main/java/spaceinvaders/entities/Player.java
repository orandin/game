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

public class Player extends Shooter{
	
	//Constructor
	
	public Player(GameData data) {
		super(data);
		
		//image du vaiseau principal
		super.image = new DrawableImage("../../images/entite/player1.png", data.getCanvas());
		
		//initialisation de la position du joueur
		int posX = this.config.getNbColumns() / 2; //position au milieu du canvas
		int posY = this.config.getNbRows() - (this.config.getNbRows() / 6) ; //position en bas du joueur
		super.setPosition(new Point(posX * super.config.getSpriteSize(), posY * super.config.getSpriteSize()));
		
		//initialisation de la strategy
		MoveStrategyKeyboard str = new MoveStrategyKeyboard(false, new SpeedVector(new Point(0, 0), 12));
		
		//on enleve les touche haut et bas
		str.addKeyDirection(KeyEvent.VK_UP, new Point(0, 0));
		str.addKeyDirection(KeyEvent.VK_DOWN, new Point(0, 0));
		
		//on ajoute la strategie au movedriver et on ajoute un KeyListener au canvas du jeu pour que les touches soit prises en compte
		super.moveDriver.setStrategy(str);
		data.getCanvas().addKeyListener(str);
		//ajout d'un KeyListener pour la toucher tirer
		data.getCanvas().addKeyListener(new PlayerCommande(this));
		super.canShoot = true;
	}

	//Getter

	public Rectangle getBoundingBox() {
		return new Rectangle(super.position, new Dimension(this.image.getWidth(), this.image.getHeight()));
	}
	
	//Methode
	
	@Override
	public void oneStepMoveAddedBehavior() {}
	
	public void shoot(){
		if(super.canShoot){
			super.data.getUniverse().addGameEntity(new Laser(super.data, this));
			super.canShoot = false;
		}
	}
	
}