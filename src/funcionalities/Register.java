package funcionalities;

import java.util.ArrayList;

import javax.swing.JTextField;

import gui.User;

public class Register {

	private String userText;
	private String emailText;
	private String passwordText;
	private ArrayList<User> users = new ArrayList<>();
	
	public Register(String userText, String emailText, String passwordText){
		
		this.userText = userText;
		this.emailText = emailText;
		this.passwordText = passwordText;	
	}
	
	public void newRegister(){
		users.add(new User(userText, passwordText, emailText));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}	
}
