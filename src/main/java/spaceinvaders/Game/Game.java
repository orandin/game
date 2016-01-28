package spaceinvaders.Game;

import spaceinvaders.Level;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

/**
 * @author Matthieu Lepers
 * @author Benjamin Szczapa
 */
public class Game extends GameDefaultImpl {
	
	private GameWindow window;
	private GameCanvas canvas;
	private GameUniverseViewPortDefaultImpl universe;
	
	public Game(GameData datas) {
		super(datas);
		//this.data.increaseLife(1);
		this.data.getCanvas().setSize(100, 100);
		
		this.canvas = this.data.getCanvas();
		this.window = new GameWindow("Space Invaders", this.canvas, this.data);
		
		window.createGUI();
		
		//This is working
		this.universe = new GameUniverseViewPortDefaultImpl(this.data);
		
		//Add the level
		this.data.addLevel(new Level(this));
		
		this.universe.paint();
		
		this.start();
	}
	
	public GameCanvasDefaultImpl getGameCanvas() {
		return (GameCanvasDefaultImpl) this.canvas;
	}
	
	public GameData getData() {
		return this.data;
	}
	
	public GameUniverseViewPortDefaultImpl getUniverseViewPort() {
		return this.universe;
	}
	
	public static void main (String[] args) {
		GameData datas = new GameData(new GameConfiguration());
		new Game(datas);
	}
}