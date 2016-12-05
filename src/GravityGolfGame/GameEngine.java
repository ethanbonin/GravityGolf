package GravityGolfGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameEngine extends JFrame {

	private static GameEngine engine = new GameEngine();
	public static final int CELL_SIZE = 20;
	public static final int FPS = 17;
	private Board board;
	private TrianglePane triUI;
	private GameControls controlUI;
	Timer timer = new Timer(FPS, new TimerListener());
	private ArrayList<String> levels = new ArrayList<String>();
	private int levelCount = 0;
	
	public static GameEngine theInstance(){ return engine; }
	
	public GameEngine() {
		board = board.getInstance();
//		levels.add("src/Data/a.csv");
//		levels.add("src/Data/b.csv");
//		levels.add("src/Data/c.csv");
//		board.setConfigFiles(levels.get(levelCount));
		board.setConfigFiles("src/Data/b.csv");
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
		//add(quizGame, BorderLayout.SOUTH);
		
		return;
	}
	
	public void timer(){
		timer.start();
	}
	
	public void stopTimer(){
		timer.stop();
	}
	
	public void resetGame() {
		timer.stop();
		board.reset();
	}
	
	public void CheckGameOver() {
		if (board.GameOver()){
			timer.stop();
			
			JFrame frame = new JFrame();
			JOptionPane gameWon = new JOptionPane();
			
			// pop up a dialogue that confirms computer win
			JOptionPane.showMessageDialog(frame, "Congrats! You won!",
					"Level Over", gameWon.INFORMATION_MESSAGE);
		}
	}
	
	public void nextLevel() {
		
		if (levelCount > 3) {
			System.out.println("Congradulations! You won!");
			System.exit(0);
		}
		
		//levelCount++;
		//Need to some how reset config file
	}
	
	
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			board.update();
			CheckGameOver();
		}
	}
	
	public static void main(String[] args) {
		
		GameEngine gravityGolf = new GameEngine();
		gravityGolf.setVisible(true);
	}

}
