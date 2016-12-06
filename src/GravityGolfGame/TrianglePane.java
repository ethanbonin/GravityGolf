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
	
	private static Orientation orient = Orientation.RIGHT;
	private Triangle thirty = new Triangle(new BoardCell(0, 0), Type._30, orient);
	private Triangle fortyFive = new Triangle(new BoardCell(0, 0), Type._45, orient);
	private Triangle sixty = new Triangle(new BoardCell(0, 0), Type._60, orient);
	private static Triangle.Type currentType = Type._45;
	
	public TrianglePane() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(new EmptyBorder(10, 5, 5, 5));
		
		createTriangleButtons();
		createFlipButton();
		
		
	}
	
	private void createTriangleButtons(){
		
		add(new JLabel("30 Degrees"));
		createSelect(thirty);
		add(thirty);
		
		add(new JLabel("45 Degrees"));
		createSelect(fortyFive);
		add(fortyFive);
		
		add(new JLabel("60 Degrees"));
		createSelect(sixty);
		add(sixty);
		
		return;
	}
	
	private void createFlipButton(){
		
		JButton flip = new JButton("Flip Triangle");
		flip.addActionListener(e -> update());
		add(flip);
		
		return;
	}
	
	private void createSelect(Triangle t){
		JButton select = new JButton("Select");
		select.addActionListener(e -> updateType(t));
		add(select);
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
	
	private void updateType(Triangle t){
		currentType = t.getType();
	}
	
	public Type getTriangle() {
		return thirty.getType();
	}
	
	public Type getFortyFixTriangle() {
		return fortyFive.getType();
	}
	
	public Type getSixtyTriangle() {
		return sixty.getType();
	}
	
	public static Orientation getOrientation(){
		return orient;
	}
	public static Type getType(){
		return currentType;
	}
	
	// TESTING ONLY
	/*public static void main(String[] args) {
		JFrame frame = new JFrame();
		//frame.setSize(150, 400);
		frame.setSize(600, 300);
		//frame.add(new TrianglePane());
		frame.add(new QuizPanel());
		frame.setVisible(true);
	}
	*/

}
