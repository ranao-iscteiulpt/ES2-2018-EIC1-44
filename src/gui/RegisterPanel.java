package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel{
	
//	private JPanel register;
//	private SignUp s=new SignUp(); 

//	public RegisterPanel() {
//		register = new JPanel();
//	}

//	public JPanel getRegister() {
//		return register;
//	}
	
	private JFrame frame;
	private JPanel LoginPanel;
	
	public RegisterPanel(JFrame frame, JPanel LoginPanel){
		this.frame = frame;
		this.LoginPanel = LoginPanel;
	}

	public void register() {
		
		this.setLayout(new GridBagLayout());

		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel name=new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		this.add(name,cs);
		
		JTextField userText = new JTextField(10);
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 2;
		this.add(userText,cs);
		
		JLabel email=new JLabel("E-mail: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		this.add(email,cs);
		
		JTextField emailText = new JTextField(10);
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 2;
		this.add(emailText,cs);
		
		JLabel password=new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 4;
		cs.gridwidth = 3;
		this.add(password,cs);
		
		JTextField passwordText = new JTextField(10);
		cs.gridx = 0;
		cs.gridy = 5;
		cs.gridwidth = 3;
		this.add(passwordText,cs);
		
		JLabel confirmPassword=new JLabel("Confirm Password: ");
		cs.gridx = 0;
		cs.gridy = 6;
		cs.gridwidth = 4;
		this.add(confirmPassword,cs);
		
		JTextField passConfirmText = new JTextField(10);
		cs.gridx = 0;
		cs.gridy = 7;
		cs.gridwidth = 5;
		this.add(passConfirmText,cs);
		
		JButton registerButton=new JButton("Register");
		cs.gridx = 2;
		cs.gridy = 8;
		cs.gridwidth = 5;
		this.add(registerButton,cs);
		
		frame.add(this);
		
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RegisterPanel.this.setVisible(false);
				LoginPanel.setVisible(true);
//				String username=userText.getText();
//				String pass=passwordText.getText();
//				String email=emailText.getText();
//				User u=new User(username, pass, email);
//				if(!passwordText.getText().equals(passConfirmText.getText()))	{
//					JOptionPane.showMessageDialog(registerButton, "The passwords not match :(");
//				}
//				else	{
//					s.getUsersRegister().add(u);
//					JOptionPane.showMessageDialog(registerButton, "Registration Sucessfull :)");
//					Frame frame=new Frame();
//					frame.openLogin();
//				}
//				
			}
		});
		
	}
}
