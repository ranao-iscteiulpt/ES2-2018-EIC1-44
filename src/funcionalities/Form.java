package funcionalities;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Form {
	
	private JPanel mainPanel;
	
	public Form(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	/**
	 * Method that removes the current panel and adds the next one
	 * @param panelToAdd panel to add
	 */
	
	public void create(JPanel panelToAdd) {
		mainPanel.removeAll();		
		
		mainPanel.add(panelToAdd,BorderLayout.CENTER);			
		mainPanel.revalidate();
		mainPanel.repaint();
	}

}
