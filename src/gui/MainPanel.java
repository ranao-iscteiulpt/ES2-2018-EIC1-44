package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileSystemView;

import GUITest.OptimizationProcess1;
import GUITest.ProblemProcess1;
import funcionalities.Form;

public class MainPanel extends JPanel {

	private JFrame frame;
	private Form form = new Form(this);
	private File selectedFile;

	public MainPanel(JFrame frame) {
		this.frame = frame;
		frame.setLayout(new BorderLayout());
	}

	public void mainPanel() {
		frame.setSize(830,480);
		frame.setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		menu.add(file);
		JMenu view = new JMenu("View");
		menu.add(view);
		JMenu actions = new JMenu("Actions");
		menu.add(actions);
		JMenu help = new JMenu("Help");
		menu.add(help);


		JMenuItem loadXml = new JMenuItem("Load XML");

		loadXml.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				 int returnValue = jfc.showOpenDialog(null);
				 // int returnValue = jfc.showSaveDialog(null);

				 if (returnValue == JFileChooser.APPROVE_OPTION) {
					 selectedFile = jfc.getSelectedFile(); 
					 OpenXMLPanel xmlPanel = new OpenXMLPanel(jfc.getSelectedFile());
					 form.create(xmlPanel);
				 }
//				XMLLoadPanel xmlPanel = new XMLLoadPanel();
//				form.create(xmlPanel);
			}
		});


		JMenuItem loadGraph = new JMenuItem("Load Graph");

		JMenuItem email = new JMenuItem("Emails");

		JMenuItem problemsList = new JMenuItem("Problems List to Solve");

		JMenuItem newProblem = new JMenuItem("New Problem");

		newProblem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//ProblemPanel problemPanel = new ProblemPanel(); para retirar
				ProblemProcess1 problemPanel = new ProblemProcess1(form);
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
		
		JMenuItem faq = new JMenuItem("FAQ");

		faq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FaqPanel faqPanel = new FaqPanel();
				form.create(faqPanel);
			}
		});
		
		JMenuItem optimization = new JMenuItem("Optimization");
		optimization.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//OptimizationPanel optimizatinPanel = new OptimizationPanel();
				OptimizationProcess1 optimizationPanel = new OptimizationProcess1(form);
				form.create(optimizationPanel);
			}
		});
		
		
		
		file.add(loadXml);
		file.add(loadGraph);

		view.add(email);
		view.add(problemsList);

		actions.add(newProblem);
		actions.add(sendEmail);
		actions.add(optimization);

		help.add(faq);
		
		frame.setJMenuBar(menu);
		frame.add(this,BorderLayout.CENTER);

	}
	
	
}
