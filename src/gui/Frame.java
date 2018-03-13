package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame {

	private JFrame frame;
	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;

	public Frame() {
		frame = new JFrame();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void openLogin() {
		frame.setSize(350, 200);
		//frame.setSize(320, 250);
		frame.setTitle("Engenharia de Software II");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);

		// JMenuBar menu = new JMenuBar();
		// JMenu file = new JMenu("File");
		// menu.add(file);
		// JMenu view = new JMenu("View");
		// menu.add(file);
		// menu.add(view);
		// JMenuItem load=new JMenuItem("Load XML");
		// JMenuItem save=new JMenuItem("Save");
		// JMenuItem newProblem=new JMenuItem("New Problem");
		// JMenuItem graph=new JMenuItem("Graph");
		// JMenuItem email=new JMenuItem("Emails");
		// JMenuItem problemsList=new JMenuItem("Problems List to Solve");
		// file.add(load);
		// file.add(save);
		// file.add(newProblem);
		// view.add(graph);
		// view.add(email);
		// view.add(problemsList);
		//
		// frame.setJMenuBar(menu);
		//
		loginPanel = new LoginPanel();
		loginPanel.logon();
		
		registerPanel= new RegisterPanel();
		registerPanel.signUp();
		
//		if(loginPanel.isRegButtonPressed())	{
//			frame.add(registerPanel.getRegister());
//		}
//		else	{
//			frame.remove(registerPanel.getRegister());
//			frame.add(loginPanel.getLogin());
//		}
		frame.add(loginPanel.getLogin());
		
		//frame.add(registerPanel.getRegister());// frame.setSize(320, 250);
		// frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
