package spaceinvaders.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Alien extends Enemys {
	
	public Alien(){
		super();
	}
	public Alien(int life, int point) {
		super(life, point);
	}
	public Alien(int point){
		super(point);
	}
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		/*
		 * si arrive au bord on change de sens et on baisse y	
		 */
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
