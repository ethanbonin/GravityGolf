package GravityGolfGame;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.Messaging.SyncScopeHelper;

import GravityGolfGame.Triangle.Type;

public class GameControls extends JPanel {
	

	public GameControls() {
		createButtons();
	}

	private void createButtons() {

		JButton start = new JButton("Start");
		start.addActionListener(e -> GameEngine.theInstance().timer());
		add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(e -> GameEngine.theInstance().stopTimer());
		add(stop);

		JButton reset = new JButton("Reset");
		reset.addActionListener(e -> GameEngine.theInstance().resetGame());
		add(reset);

		JButton nextTriangle;
		nextTriangle = new JButton("Choose Triangle");
		nextTriangle.addActionListener(e -> Board.getInstance().updateCounter());
		add(nextTriangle);

		return;
	}

}
