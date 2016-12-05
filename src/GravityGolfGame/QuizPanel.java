package GravityGolfGame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import GravityGolfGame.Triangle.Type;

public class QuizPanel extends JPanel {

	ArrayList<String> answers = new ArrayList<String>();

	private Orientation orient = Orientation.RIGHT;
	private Triangle thirty = new Triangle(new BoardCell(0, 0), Type._30, orient);
	private Triangle fortyFive = new Triangle(new BoardCell(0, 0), Type._45, orient);
	private Triangle sixty = new Triangle(new BoardCell(0, 0), Type._60, orient);
	
	JComboBox<String> questionOne = new JComboBox<String>();
	JComboBox<String> questionTwo = new JComboBox<String>();
	JComboBox<String> questionThree = new JComboBox<String>();

	public QuizPanel() {
		JFrame frame = new JFrame();
		JOptionPane quiz = new JOptionPane();
		JOptionPane.showMessageDialog(frame,
				"This is a Quiz to see what you have learned\n"
						+ "All angles in question concern the right-most angle\n "
						+" on the triangle to the left of the question",
				"QUIZ", JOptionPane.INFORMATION_MESSAGE);
		this.createLayout();
	}

	private void createLayout() {

		// Give the display two rows
		this.setLayout(new GridLayout(4, 0));
		JLabel instructions = new JLabel();
		instructions.setText("All angles in question concern the right-most angle");
		JButton submitButton = new JButton();
		submitButton.setText("Submit");
		submitButton.addActionListener((e -> checkSolution()));
		// Create check Boxes and Combo Boxes for all questions
		createIcons(questionOne, thirty, 1);
		createIcons(questionTwo, sixty, 2);
		createIcons(questionThree, fortyFive, 3);
		add(instructions);
		add(submitButton);
	}


	private void createIcons(JComboBox<String> question,Triangle t, int index) {
		
		JPanel comboBoxDisplay = new JPanel();
		JLabel label = new JLabel();
		label.setText("Which angle is diplayed?");

		add(t);
	
		// Set Possible Answers
		question.addItem("30");
		question.addItem("45");
		question.addItem("60");
		question.addItem("90");
		
		// Make a subpanel border for people cards
		Border borderComboBox = BorderFactory.createTitledBorder("Question " + index + ":");
		comboBoxDisplay.setBorder(borderComboBox);
		
		comboBoxDisplay.add(label, BorderLayout.CENTER);
		comboBoxDisplay.add(question, BorderLayout.SOUTH);
		this.add(comboBoxDisplay);
	}
	
	private void checkSolution() {
		JFrame frame = new JFrame();
		
		if (quizFinished()) {
			JOptionPane.showMessageDialog(frame,
					"Congratulations! \n You have PASSED",
					"QUIZ", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(frame,
					"Sorry atleast one of your answers\n is incorrect",
					"QUIZ", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public boolean quizFinished() {
		String one = (String) questionOne.getSelectedItem();
		String two = (String) questionTwo.getSelectedItem();
		String three = (String) questionThree.getSelectedItem();
		System.out.println(one + " " + two + " " + three);
		if (one.equals("30") && two.equals("60") && three.equals("45")) {
			return true;
		}
		return false;	
	}
}
