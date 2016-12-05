package GravityGolfGame;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameControls extends JPanel {

	private JButton nextLevel;
	
	public GameControls() {
		createButtons();
	}

	public void openNextLevel(){
		nextLevel.setEnabled(true);
	}
	
	private void createButtons(){
		
		JButton start = new JButton("Start");
		start.addActionListener(e -> GameEngine.theInstance().timer());
		add(start);
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(e -> GameEngine.theInstance().stopTimer());
		add(stop);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(e -> GameEngine.theInstance().resetGame());
		add(reset);
		
		nextLevel = new JButton("Next Level");
		nextLevel.addActionListener(e -> GameEngine.theInstance().nextLevel());
		add(nextLevel);	
		
		return;
	}
	

}
