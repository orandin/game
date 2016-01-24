package spaceinvaders.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategyRandom;

public class Player extends GameMovable implements GameEntity{
	
	/*
	 * position de test a changer quand la taille sera fixer (à reflechir)
	 */
	private static final int INIT_POSX = 50;
	private static final int INIT_POSY = 50;
	private String name;
	
	//Constructor
	public Player(String name){
		this(name,INIT_POSX, INIT_POSY);
	}
	public Player(String name, int posX, int posY) {
		super();
		super.setPosition(new Point(posX, posY));
		super.moveDriver.setStrategy(new MoveStrategyRandom());
		this.name = name;	
	}

	//Getter
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return lifeBox
	 */
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(super.position);
	}
	
	//Methode
	
	@Override
	public void oneStepMoveAddedBehavior() {
	
	}
	
	public static void main (String[] args){
		Player p = new Player("keke");
		while(true){
			System.out.println("pos : (" + p.getPosition().getX() + "," + p.getPosition().getY() + ")");
			p.oneStepMove();
			System.out.println("pos : (" + p.getPosition().getX() + "," + p.getPosition().getY() + ")");
		}		
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}