/**
 * 
 */
package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

/**
 * @author Simon Delberghe
 * @author Matthieu Lepers
 */
public abstract class Alien extends Enemies {
	
	/**
	 * Create an alien
	 * @param data
	 * 		The game data
	 * @param posX
	 * 		The initial x position where it spawn
	 * @param posY
	 * 		The initial y position where it spawn
	 * @param array
	 * 		The array when the alien is, this is for movement
	 */
	public Alien(GameData data,int posX, int posY, EnnemiesArray array){
		super(data, posX, posY, array);
		super.image = new DrawableImage(getUriImage(), super.data.getCanvas());
		super.point = score();
	}
	
	protected abstract String getUriImage();
	
	public abstract int score();
}
