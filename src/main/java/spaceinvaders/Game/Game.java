package spaceinvaders.Game;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameMenuBar;
import gameframework.gui.GameWindow;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * 
 * @author Benjamin Szczapa
 *
 */
public class Game {
	
	private static GameCanvas gameCanvas = new GameCanvasDefaultImpl();
	private static GameData gameData = new GameData(new GameConfiguration());
	private static GameWindow gameWindow;
	private static GameUniverseViewPortDefaultImpl universeViewPort;
	private static DrawableImage image;
	
	public static void main (String[] args) throws IOException{

		gameData.increaseLife(1);
		gameWindow = new GameWindow("Sapce Invaders", gameCanvas, gameData);
		universeViewPort = new GameUniverseViewPortDefaultImpl(gameData);
		universeViewPort.paint();
		
		image = new DrawableImage(new File("src/main/resources/fond.png").toURI().toURL(), gameCanvas);
		gameCanvas.setSize(840, 600);
		
		
		
		gameWindow.createGUI();
		
	}
	

}