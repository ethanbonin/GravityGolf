package GravityGolfGame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Quiz extends JPanel{
	
	public Quiz() {
		JButton quiz = new JButton("Quiz");
		quiz.addActionListener(e -> popUp());
		add(quiz);
	}
	
	private void popUp(){
		
		setSize(300, 100);
		
		
		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//setBorder(new EmptyBorder(10, 5, 5, 5));
	}
	
	
	//Testing
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(150, 100);
		frame.add(new Quiz());
		frame.setVisible(true);

	}
	
}

