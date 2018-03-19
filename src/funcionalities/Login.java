package funcionalities;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import gui.User;
import jdk.nashorn.internal.scripts.JO;

public class Login {

	private String userText;
	private String passText;
	private boolean login = false;
	private ArrayList<User> users = new ArrayList<>();
	
	public Login(String userText, String passText, ArrayList<User> users){
		this.userText = userText;
		this.passText = passText;
		this.users = users;
	}
	
	public void confirmLogin(){
			
		for(int i = 0; i < users.size(); i++){
			if(userText.equals(""))
					JOptionPane.showMessageDialog(null, "Nao inseriste nome de utilizador");
			else{
				if(passText.equals(""))
					JOptionPane.showMessageDialog(null, "Nao inseriste password");
				
				else{
					
					if(userText.equals(users.get(i).getUsername())){
						if(passText.equals(users.get(i).getPassword())){
							login = true;
						}
					}
					else{
						if(i == users.size()-1){
							JOptionPane.showMessageDialog(null, "Nome de utilizador ou password estão errados!");
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
