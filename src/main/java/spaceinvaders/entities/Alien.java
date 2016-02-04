package spaceinvaders.entities;

import spaceinvaders.Level;
import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class Alien extends EnemiesShooter{

	/* ----- constructor ----- */
	
	/**
	 * Alien constructor
	 * @param data ; the game data
	 * @param enemyPoint : point win by the player if he touch his
	 * @param posX : x position on the screen
	 * @param posY : y position on the screen
	 * @param lvl : the actually game Level
	 */
	public Alien(GameData data, int enemyPoint, int posX, int posY, Level lvl){
		super(data, posX, posY, lvl);
		point = enemyPoint;
		setImage();
	}
	
	/* ----- Setter ----- */
	
	/**
	 * this method is use by the constructor for initialised the alien image
	 * because all aliens in space invaders game are not the same image
	 */
	private void setImage(){
		if(point == 10){
			image = new DrawableImage("../../images/entite/saucer1b.png", data.getCanvas());
		}
		if(point == 20){
			image = new DrawableImage("../../images/entite/saucer2a.png", data.getCanvas());
		}
		if(point == 40){
			image = new DrawableImage("../../images/entite/saucer3a.png", data.getCanvas());
		}
	}
	/* ----- Method ----- */

	/**
	 * action to do after a move
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		lvl.getEnemiesArray().ReverseMoveStrategyForAll(position.x);
		shoot();
	}
}
