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
public class AliensArray extends EnnemiesArray {
	
	/**
	 * {@inheritDoc}
	 */
	public AliensArray(GameData data) {
		super(data);
	}
	
	/* ----- Drawing ----- */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(Graphics g) {
		//Invoke a new wave if all enemies are dead
		if (this.checkAllDead()) {
			this.data.getUniverse().removeGameEntity(this);
			this.data.getUniverse().addGameEntity(new AliensArray(this.data));
		}
		
		for (int i = 0; i < this.enemyArray.length; i++) {
			for (int j = 0; j < this.enemyArray[0].length; j++) {
				this.xPos += this.sign * this.speed;
				if (this.xPos >= 100) {
					this.sign = -1;
					this.yPos += 4;
				}
				if (this.xPos <= 0) {
					this.sign = 1;
					this.yPos += 4;
				}
				if (this.enemyArray[i][j] != null) {
					this.enemyArray[i][j].setOffsets(this.xPos, this.yPos);
					this.enemyArray[i][j].shoot();
					this.enemyArray[i][j].draw(g);
				}
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Enemies rulesToCreateEnemy(int row, int posX, int posY) {
		switch(row) {
			case 1:
				return new LargeAlien(super.data, posX, posY, this);
			case 2:
			case 3:
				return new MediumAlien(super.data, posX, posY, this);
		}
		return new SmallAlien(super.data, posX, posY, this);
	}
}
