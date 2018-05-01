package funcionalities;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import files.TEXTOperations;
import jdk.nashorn.internal.scripts.JO;
import objects.User;

public class Login {

	private String userText;
	private String passText;
	private boolean login = false;
	private TEXTOperations textOperations = new TEXTOperations();
	private ArrayList<User> users = new ArrayList<>();
	
	public Login(String userText, String passText){
		this.userText = userText;
		this.passText = passText;
	}
	
	public void confirmLogin(){
			
		textOperations.fillArray(users);
		
		for(int i = 0; i < users.size(); i++){
						
			if(userText.equals("") && passText.equals("")){
				JOptionPane.showMessageDialog(null, "You didn´t enter the username and password!");
				break;
			}
			if(userText.equals("")){
				JOptionPane.showMessageDialog(null, "You didn´t enter the username!");
				break;
			}
			else{
				if(passText.equals("")){
					JOptionPane.showMessageDialog(null, "You didn´t enter the password!");
					break;
				}
				else{
					
					if(userText.equals(users.get(i).getUsername())){
						if(passText.equals(users.get(i).getPassword())){
							login = true;
							break;
						}
					}
					else{
						if(i == users.size()-1){
							JOptionPane.showMessageDialog(null, "Username or password doesn´t exist!");
						}
					}
				}
			}
		}
		
	}
		
	public boolean getLogin(){
		return login;
	}
}
