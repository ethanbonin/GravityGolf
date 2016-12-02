package GravityGolfGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class GameEngine extends JFrame {

	public static final int CELL_SIZE = 20;
	public static final int FPS = 20;
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
	
	// TODO
	public void timer(){
		Timer timer = new Timer(FPS, new TimerListener());
		timer.start();
	}
	
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			board.update();
		}
	}
	
	public static void main(String[] args) {
		
		GameEngine gravityGolf = new GameEngine();
		gravityGolf.setVisible(true);
	}

}
