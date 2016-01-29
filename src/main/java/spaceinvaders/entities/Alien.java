/**
 * 
 */
package spaceinvaders.entities;

import gameframework.drawing.DrawableImage;
import gameframework.game.GameData;

/**
 * @author Simon Delberghe
 *
 */
public abstract class Alien extends Enemies {
	
	public Alien(GameData data,int posX, int posY){
		super(data, posX, posY);
		super.image = new DrawableImage(getUriImage(), super.data.getCanvas());
		super.point = score();
	}
	
	protected abstract String getUriImage();
	
	protected abstract int score();
}
