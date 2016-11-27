package GravityGolfGame;

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
		start.addActionListener(e -> System.out.println("Not implemented"));
		add(start);
		
		JButton stop = new JButton("Stop");
		start.addActionListener(e -> System.out.println("Not implemented"));
		add(stop);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(e -> System.out.println("Not implemented"));
		add(reset);
		
		nextLevel = new JButton("Next Level");
		nextLevel.setEnabled(false);
		nextLevel.addActionListener(e -> System.out.println("Not implemented"));
		add(nextLevel);	
		
		return;
	}
	

	// TESTING ONLY
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 100);
		frame.add(new GameControls());
		frame.setVisible(true);
	}

}
