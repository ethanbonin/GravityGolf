package GravityGolfGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Quiz extends JPanel{
	
	public Quiz() {
		JButton quiz = new JButton("Quiz");
		quiz.addActionListener(new ButtonListener());
		add(quiz);
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	private JPanel questions() {
		return null;
	}
	
	//Testing
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(150, 100);
		frame.add(new Quiz());
		frame.setVisible(true);

	}
	
}

