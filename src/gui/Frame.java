package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame {

	private JFrame frame;

	public Frame() {
		
		frame = new JFrame("Engenharia de Software II");
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponents();
	}

	/**
	 * Method to add the first panel (login)
	 */
	
	private void addComponents() {
		
		LoginPanel loginPanel = new LoginPanel(frame);
	}

	/**
	 * Method to initialize the frame
	 */
	
	public void init() {
		
		//frame.setSize(640, 668);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}