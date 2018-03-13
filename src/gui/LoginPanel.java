package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel {

	private JPanel login;
	private SignUp logOn = new SignUp();
	

	public LoginPanel() {
		login = new JPanel();
	}

	public JPanel getLogin() {
		return login;
	}

	public SignUp getLogOn() {
		return logOn;
	}

	public void logon() {
		login.setLayout(new GridBagLayout());

		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel userLabel = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		login.add(userLabel, cs);

		JTextField userText = new JTextField(10);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		login.add(userText, cs);

		JLabel passLabel = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		login.add(passLabel, cs);

		JTextField passText = new JTextField(10);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		login.add(passText, cs);

		JButton logButton = new JButton("LogIn");
		cs.gridx = 2;
		cs.gridy = 2;
		cs.gridwidth = 2;
		login.add(logButton, cs);

		logButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean userFounded=false;
				String username = userText.getText();
				String pass = passText.getText();
				ArrayList<User>users=logOn.getUsersRegister();
				for(User i:users)	{
					if(i.getUsername().equals(username)&&i.getPassword().equals(pass))	{
						userFounded=true;
					}
				}
				if(!userFounded)	{
					JOptionPane.showMessageDialog(logButton, "LogIn Sucesfully :)");
					UserFrame frame=new UserFrame();
					frame.openLogin();
				}
				else	{
					JOptionPane.showMessageDialog(logButton, "Something is wrong :(");
				}
			}
		});

		JLabel registerLabel = new JLabel("If you're not registered, click bellow !");
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		login.add(registerLabel, cs);

		JButton registerButton = new JButton("Register");
		cs.gridx = 1;
		cs.gridy = 4;
		cs.gridwidth = 4;
		login.add(registerButton, cs);

		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpFrame frame=new SignUpFrame();
				frame.openLogin();
			}
		});
	}

	
	
	
}
