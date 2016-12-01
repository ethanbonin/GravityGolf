package GravityGolfGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameEngine extends JFrame {

	public static final int CELL_SIZE = 40;
	private Board board;
	private TrianglePane triUI;
	private GameControls controlUI;
	
	public GameEngine() {
		board = board.getInstance();
		board.setConfigFiles("src/Data/GravityGolfBoard.csv");
		board.load();
		
		triUI = new TrianglePane();
		controlUI = new GameControls();
		
		loadUI();
	}
	
	private void loadUI(){
		
		setSize(CELL_SIZE* 15, CELL_SIZE * 15);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(controlUI, BorderLayout.PAGE_START);
		add(board, BorderLayout.CENTER);
		add(triUI, BorderLayout.LINE_END);
		
		return;
	}
	
	// TODO
	private void timer(){
		
		
	}
	
	public static void main(String[] args) {
		
		GameEngine gravityGolf = new GameEngine();
		gravityGolf.setVisible(true);

	}

}
