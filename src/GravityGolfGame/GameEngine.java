package GravityGolfGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
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
	
	public static GameEngine theInstance(){ return engine; }
	
	public GameEngine() {
		board = board.getInstance();
		//board.setConfigFiles("src/Data/GravityGolfBoard.csv");
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
	
	public void quizGame() {
		class QuizPanel extends JPanel{
			void quizPane() { 
				setSize(300, 100);
				setVisible(true);
			}
		}
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
