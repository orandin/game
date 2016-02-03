package spaceinvaders.entities;

import gameframework.game.GameData;

import java.awt.Graphics;

/**
 * @author Benjamin Szczapa
 * @author Kevin Rico
 * @author Matthieu Lepers
 * @author Guillaume Maitrot
 * @author Theo Verschaeve
 * @author Simon Delberghe
 */
public class AliensArray extends EnemiesArray {

	/**
	 * {@inheritDoc}
	 */
	public AliensArray(GameData data) {
		super(data);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {
		//Invoke a new wave if all enemies are dead
		if (checkAllDead()) {
			data.getUniverse().removeGameEntity(this);
			data.getUniverse().addGameEntity(new AliensArray(data));
		}
		
		for (int i = 0; i < enemyArray.length; i++) {
			for (int j = 0; j < enemyArray[0].length; j++) {
				xPos += sign * speed;

				if (xPos >= 100) {
					sign  = -1;
					yPos += 4;
				} else if (xPos <= 0) {
					sign  = 1;
					yPos += 4;
				}

				if (enemyArray[i][j] != null) {
					enemyArray[i][j].setOffsets(xPos, yPos);
					enemyArray[i][j].shoot();
					enemyArray[i][j].draw(g);
				}
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Enemy rulesToCreateEnemy(int row, int posX, int posY) {
		switch(row) {
			case 1:
				return new LargeAlien(data, posX, posY, this);

			case 2:
			case 3:
				return new MediumAlien(data, posX, posY, this);
		}
		return new SmallAlien(data, posX, posY, this);
	}
}
