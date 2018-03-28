package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import funcionalities.Form;

public class MainPanel extends JPanel {

	private JFrame frame;
	private Form form = new Form(this);

	public MainPanel(JFrame frame) {
		this.frame = frame;
		frame.setLayout(new BorderLayout());
	}

	public void mainPanel() {
		frame.setSize(641, 668);
		frame.setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		menu.add(file);
		JMenu view = new JMenu("View");
		menu.add(view);
		JMenu actions = new JMenu("Actions");
		menu.add(actions);

		JMenuItem loadXml = new JMenuItem("Load XML");

		loadXml.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				XMLLoadPanel xmlPanel = new XMLLoadPanel();
				form.create(xmlPanel);
			}
		});


		JMenuItem loadGraph = new JMenuItem("Load Graph");

		JMenuItem email = new JMenuItem("Emails");

		JMenuItem problemsList = new JMenuItem("Problems List to Solve");

		JMenuItem newProblem = new JMenuItem("New Problem");

		newProblem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ProblemPanel problemPanel = new ProblemPanel();
				form.create(problemPanel);
			}

		});

		JMenuItem sendEmail = new JMenuItem("Send Email");
		
		sendEmail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EmailPanel emailPanel = new EmailPanel();
				form.create(emailPanel);
				
			}
		});

		file.add(loadXml);
		file.add(loadGraph);

		view.add(email);
		view.add(problemsList);

		actions.add(newProblem);
		actions.add(sendEmail);

		frame.setJMenuBar(menu);
		frame.add(this,BorderLayout.CENTER);

	}
	
	
}
