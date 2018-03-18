package funcionalities;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Form {
	
	private JPanel mainPanel;
	
	public Form(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	public void create(JPanel panelToAdd) {
		mainPanel.removeAll();		
		
		mainPanel.add(panelToAdd,BorderLayout.CENTER);			
		mainPanel.revalidate();
		mainPanel.repaint();
	}

}
