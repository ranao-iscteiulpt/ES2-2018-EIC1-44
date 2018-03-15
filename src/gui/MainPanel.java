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
		menu.add(file);
		menu.add(view);
		JMenuItem load = new JMenuItem("Load XML");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem newProblem = new JMenuItem("New Problem");
		JMenuItem graph = new JMenuItem("Graph");
		JMenuItem email = new JMenuItem("Emails");
		JMenuItem problemsList = new JMenuItem("Problems List to Solve");
		file.add(load);
		file.add(save);
		file.add(newProblem);
		view.add(graph);
		view.add(email);
		view.add(problemsList);

		frame.setJMenuBar(menu);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
