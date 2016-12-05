package GravityGolfGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MouseClicked implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		Point i = e.getPoint();
		System.out.println(e.getX()/20 + " " + e.getY()/20);
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
