package gui;

import java.util.ArrayList;

import objects.User;

public class SignUp {
	
	private ArrayList<User> usersRegister=new ArrayList<User>();

	public ArrayList<User> getUsersRegister() {
		return usersRegister;
	}
	
	public User register(String username,String password,String email)	{
		User u=new User(username, password, email);
		usersRegister.add(u);
		return u;
	}
	
	public boolean verifyLogin(User u)	{
		boolean logON=false;
		for(User i:usersRegister)	{
			if(u.getUsername().equals(i.getUsername())&&(u.getPassword().equals(i.getPassword())))
					return true;
		}
		return logON;
	}
	
	
}
