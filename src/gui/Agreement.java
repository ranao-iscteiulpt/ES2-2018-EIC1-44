package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Agreement {
	
	JFrame frame = new JFrame("Agreement");
	
	public Agreement() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		
		addComponents();
		
	}

	private void addComponents() {
		
		JLabel title = new JLabel("AGREEMENT");
		
		JTextArea text = new JTextArea("INFORMED, CLARIFIED AND FREE CONSENT FOR PARTICIPATION. \n" +
				"\n" + 
				"We are responsible for the collection, processing and use of personal data in the content of its activity of sending emails, creating problems and optimizing them.\r\n" +
				"\r\n" +
				"We attach great importance to the protection of personal data and collect, process and use personal data exclusively in accordance with the following principles:\r\n" +
				"\r\n" +
				"  - In order to communicate with you and take with you information considered revelant within the scope of the project, we will collect your e-mail address through the application registration.\r\n" +
				"\r\n" +
				"Any question contact us.");
		
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(text);
		
		JButton close = new JButton("Exit");
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(close, BorderLayout.SOUTH);
	
	}
	
	public void init() {
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setSize(350, 300);
	}

}
