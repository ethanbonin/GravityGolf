package GravityGolfGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.sun.java.swing.plaf.windows.resources.windows;

public class GameEngine extends JFrame {

	public static final int CELL_SIZE = 20;
	private Board board;
	private TrianglePane triUI;
	private GameControls controlUI;
	
	public GameEngine() {
		board = board.getInstance();
		//board.setConfigFiles("src/Data/GravityGolfBoard.csv");
		board.setConfigFiles("src/Data/testBoard.csv");
		board.load();
		
		triUI = new TrianglePane();
		controlUI = new GameControls();
		
		loadUI();
	}
	
	private void loadUI(){
		
		setSize(CELL_SIZE* 35, CELL_SIZE * 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(controlUI, BorderLayout.PAGE_START);
		add(board, BorderLayout.CENTER);
		add(triUI, BorderLayout.LINE_END);
		
		return;
	}
	
	public void Test(){
		// TESTING
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (true) {
			timer();
		}
	}
	
	// TODO
	private void timer(){
		
		// TEST
		board.update();
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		GameEngine gravityGolf = new GameEngine();
		gravityGolf.setVisible(true);
		gravityGolf.Test();
	}

}
