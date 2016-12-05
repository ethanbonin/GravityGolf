package GravityGolfGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GravityGolfGame.Triangle.Type;

public class TrianglePane extends JPanel{

	// TODO: Implement Click and Drag functionality into the triangles
	
	private Orientation orient = Orientation.RIGHT;
	private Triangle thirty = new Triangle(new BoardCell(0, 0), Type._30, orient);
	private Triangle fortyFive = new Triangle(new BoardCell(0, 0), Type._45, orient);
	private Triangle sixty = new Triangle(new BoardCell(0, 0), Type._60, orient);
	
	public TrianglePane() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(new EmptyBorder(10, 5, 5, 5));
		
		createTriangleButtons();
		createFlipButton();
		
	}
	
	private void createTriangleButtons(){
		
		add(new JLabel(thirty.getType().toString() + " Degrees"));
		//add(thirty);
		
		add(new JLabel(fortyFive.getType().toString() + " Degrees"));
		add(fortyFive);
		
		add(new JLabel(sixty.getType().toString() + " Degrees"));
		add(sixty);
		
		return;
	}
	
	private void createFlipButton(){
		
		JButton flip = new JButton("Flip Triangle");
		flip.addActionListener(e -> update());
		add(flip);
		
		return;
	}
	
	private void update(){
		
		switch(orient){
		case RIGHT:
			orient = Orientation.UP;
			break;
		case UP:
			orient = Orientation.LEFT;
			break;
		case LEFT:
			orient = Orientation.DOWN;
			break;
		case DOWN:
			orient = Orientation.RIGHT;
			break;
		default:
			System.out.println("Triangle Flip Error. TrianglePane.update");
			orient = Orientation.RIGHT;
		}
		
		thirty.setOrientaion(orient);
		fortyFive.setOrientaion(orient);
		sixty.setOrientaion(orient);
		
		repaint();
		return;
	}

	// TESTING ONLY
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//frame.setSize(150, 400);
		frame.setSize(600, 300);
		//frame.add(new TrianglePane());
		frame.add(new QuizPanel());
		frame.setVisible(true);

	}

}
