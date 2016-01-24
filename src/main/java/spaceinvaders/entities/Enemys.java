package spaceinvaders.entities;

import java.awt.Point;

import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategyStraightLine;

public abstract class Enemys extends GameMovable implements GameEntity{

	private static final int INIT_X = 15; //position initial en X
	private static final int INIT_Y = 15; // position initial en y
	private static final int MAX_X = 26; // position max en X
	private static int POS_X = INIT_X; //pos x actuel
	private static int POS_Y = INIT_Y; //pos Y actuel
	private static final int MIN_POINT = 10; //point minimum
	private static final int MIN_LIFE = 1; //vie minimum
	protected int life; //vie actuel
	protected int point; // nbr de point
	
	public Enemys(){
		this(MIN_LIFE, MIN_POINT, POS_X, POS_Y);
	}
	public Enemys(int point){
		this(MIN_LIFE, point, POS_X, POS_Y);
	}
	public Enemys(int life, int score){
		this(life,score, POS_X, POS_Y);
	}
	public Enemys(int life, int point, int posX, int posY) {
		super();
		super.setPosition(new Point(posX, posY));
		super.moveDriver.setStrategy(new MoveStrategyStraightLine(super.position, new Point(22,22)));
		this.life = life;
		this.point = point;
		if(POS_X++ == MAX_X){
			POS_X = INIT_X;
			POS_Y++;
		}
	}
	
	public int getPoint(){
		return this.point;
	}

	public int getLife(){
		return this.life;
	}
	
	public void discreaseLife(){
		this.life--;
	}
	
}
