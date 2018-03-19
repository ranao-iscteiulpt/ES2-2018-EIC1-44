package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import funcionalities.Login;
import funcionalities.Register;

public class RegisterPanel extends JPanel{
	
	private JFrame frame;
	private JPanel LoginPanel;
	private Register register;
	
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
				
				if(passwordText.getText().equals(passConfirmText.getText()) && !userText.getText().equals("") && !emailText.getText().equals("") && !passwordText.getText().equals("") && !passConfirmText.getText().equals("")){

					register = new Register(userText.getText(), emailText.getText(), passwordText.getText());
					register.newRegister();
					
					JOptionPane.showMessageDialog(null, "Registo com sucesso");
					
					RegisterPanel.this.setVisible(false);
					LoginPanel.setVisible(true);
				}
				
				else{
					
					if(userText.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Não inseriste nome de utilizador");
					else{
						
						if(emailText.getText().equals(""))
							JOptionPane.showMessageDialog(null, "Não inseriste email");
						else{
							if(passwordText.getText().equals("") || passConfirmText.getText().equals(""))
								JOptionPane.showMessageDialog(null, "Não inseriste password ou não confirmaste password!");
							else{
								if(!(passwordText.getText().equals(passConfirmText.getText())))
									JOptionPane.showMessageDialog(null, "Passwords nao são iguais!");
							}
						}
					}
				}
			}
		});
		
	}
	
	public ArrayList<User> getUsers(){
		return register.getUsers();
	}
}
