package GravityGolfGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GravityGolfGame.Triangle.Type;

public class MouseClicked implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		Point i = e.getPoint();
		int x = (int) e.getX()/20 + 1;
		int y = (int) e.getY()/20 + 1;
		Board.getInstance().addTriangle(new Triangle(Board.getInstance().getCellAt(x, y), Type._45, Orientation.RIGHT));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseClicked(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
