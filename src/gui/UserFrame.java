package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UserFrame {

	private JFrame frame;

	public UserFrame() {
		frame = new JFrame();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void openLogin() {
		frame.setSize(500, 400);
		frame.setTitle("Engenharia de Software II");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);

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
