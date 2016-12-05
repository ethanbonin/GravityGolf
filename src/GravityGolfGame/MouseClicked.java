package GravityGolfGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GravityGolfGame.Triangle.Type;

public class MouseClicked implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		int x = (int) e.getX() / 20 + 1;
		int y = (int) e.getY() / 20 + 1;

		if (x == 25 || x == 26) 
			x = 24;
		
		
		if (x == 1 || x == 2)
			x = 3;

		if (y == 1)
			y = 2;
				
		if (y == 25)
			y = 24;
		
		
		Board.getInstance().addTriangle(Board.getInstance().getCellAt(x, y));
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
