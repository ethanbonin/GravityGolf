package GravityGolfGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrianglePane extends JPanel{

	public TrianglePane() {
		
		for (Triangle.Type t : Triangle.Type.values()){
			
		}
		
	}

	// TESTING ONLY
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(150, 400);
		frame.add(new TrianglePane());
		frame.setVisible(true);

	}

}
