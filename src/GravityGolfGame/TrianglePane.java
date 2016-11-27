package GravityGolfGame;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrianglePane extends JPanel{

	public TrianglePane() {
		
		repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int i = 0;
		for (Triangle.Type t : Triangle.Type.values()){
			new Triangle(null, t, Orientation.RIGHT).draw(g, new BoardCell(10, 10 + i*GameEngine.CELL_SIZE, false, false));
			System.out.println(t.toString() + " degree Triangle not implemented");
			i++;
		}
		
		return;
	}

	// TESTING ONLY
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(150, 400);
		frame.add(new TrianglePane());
		frame.setVisible(true);

	}

}
