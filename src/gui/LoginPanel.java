package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import funcionalities.Login;

public class LoginPanel extends JPanel{

	private JFrame frame;
	private RegisterPanel registerPanel;
	private Login login;
	
	public LoginPanel(JFrame frame) {
		this.frame = frame;
	}
	
	public void login() {
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel userLabel = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		this.add(userLabel, cs);

		JTextField userText = new JTextField(10);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		this.add(userText, cs);

		JLabel passLabel = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		this.add(passLabel, cs);

		JTextField passText = new JTextField(10);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		this.add(passText, cs);

		JButton logButton = new JButton("LogIn");
		cs.gridx = 2;
		cs.gridy = 2;
		cs.gridwidth = 2;
		this.add(logButton, cs);

		logButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				login = new Login(userText.getText(), passText.getText(), registerPanel.getUsers());
				login.confirmLogin();
				
				if(login.getLogin() == true){
					JOptionPane.showMessageDialog(null, "Login com sucesso");
					LoginPanel.this.setVisible(false);
					MainPanel mainPanel = new MainPanel(frame);
					mainPanel.mainPanel();
				}
			}
		});

		JLabel registerLabel = new JLabel("If you're not registered, click bellow !");
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		this.add(registerLabel, cs);

		JButton registerButton = new JButton("Register");
		cs.gridx = 1;
		cs.gridy = 4;
		cs.gridwidth = 4;
		this.add(registerButton, cs);

		frame.add(this);
		
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				LoginPanel.this.setVisible(false);
				
				registerPanel = new RegisterPanel(frame, LoginPanel.this);
				registerPanel.register();
			}
		});
	}	
}
