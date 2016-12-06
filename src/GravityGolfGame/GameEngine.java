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
	private QuizPanel quizPanel;
	Timer timer = new Timer(FPS, new TimerListener());
	private ArrayList<String> levels = new ArrayList<String>();
	private int levelCount = 0;
	
	public static GameEngine theInstance(){ return engine; }
	
	public GameEngine() {
		board = board.getInstance();
		board.setConfigFiles("src/Data/a.csv");
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
		//add(quizPanel, BorderLayout.SOUTH);
		
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
		
		if (levelCount == 0 && board.GameOver() == true){
			levelCount++;
			setSize(CELL_SIZE* 35, CELL_SIZE * 43);
			quizPanel = new QuizPanel();
			add(quizPanel, BorderLayout.SOUTH);
			board.reset();
			board.setConfigFiles("src/Data/b.csv");
			board.load();
		}
		if (levelCount == 1 && board.GameOver() == true) {
			levelCount++;
			board.reset();
			board.setConfigFiles("src/Data/c.csv");
			board.load();
		}
		
		if (levelCount == 2 && board.GameOver() == true) {
			JFrame frame = new JFrame();
			JOptionPane gameWon = new JOptionPane();
			JOptionPane.showMessageDialog(frame, "Congrats! You won the whole Game!!!\n time to take a quiz",
					"Game Over", gameWon.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		
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
