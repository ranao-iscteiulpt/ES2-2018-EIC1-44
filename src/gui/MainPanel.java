package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private JFrame frame;

	public MainPanel(JFrame frame) {
		this.frame = frame;
	}

	public void mainPanel() {

		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		menu.add(file);
		JMenu view = new JMenu("View");
		menu.add(view);
		JMenu actions = new JMenu("Actions");
		menu.add(actions);
		
		JMenuItem loadXml = new JMenuItem("Load XML");
		JMenuItem loadGraph = new JMenuItem("Load Graph");
		
		JMenuItem email = new JMenuItem("Emails");
		JMenuItem problemsList = new JMenuItem("Problems List to Solve");
		
		JMenuItem newProblem = new JMenuItem("New Problem");
		JMenuItem sendEmail = new JMenuItem("Send Email");
		
		file.add(loadXml);
		file.add(loadGraph);
		
		view.add(email);
		view.add(problemsList);

		actions.add(newProblem);
		actions.add(sendEmail);
		
		frame.setJMenuBar(menu);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
