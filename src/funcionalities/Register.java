package funcionalities;

import java.util.ArrayList;

import javax.swing.JTextField;

import files.TEXTOperations;
import objects.User;

public class Register {

	private String userText;
	private String emailText;
	private String passwordText;
	private TEXTOperations tOperations = new TEXTOperations();
	
	public Register(String userText, String emailText, String passwordText){
		
		this.userText = userText;
		this.emailText = emailText;
		this.passwordText = passwordText;	
	}
	
	public void newRegister(){

		tOperations.createRegister(userText, passwordText, emailText);
	}	
}
