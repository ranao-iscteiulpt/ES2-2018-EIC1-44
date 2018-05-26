package gui;

import java.util.ArrayList;

import objects.User;

public class SignUp {
	
	private ArrayList<User> usersRegister=new ArrayList<User>();

	/**
	 * Method to access all registered users
	 * @return
	 */
	
	public ArrayList<User> getUsersRegister() {
		return usersRegister;
	}
	
	/**
	 * Method to add new account to previous array list
	 * @param username new account username
	 * @param password new account password
	 * @param email new account email
	 * @return new registered account
	 */
	
	public User register(String username,String password,String email)	{
		User u=new User(username, password, email);
		usersRegister.add(u);
		return u;
	}
	
	/**
	 * Method to verify if user's account is valid
	 * @param u user account
	 * @return true if account exists, false if not
	 */
	
	public boolean verifyLogin(User u)	{
		boolean logON=false;
		for(User i:usersRegister)	{
			if(u.getUsername().equals(i.getUsername())&&(u.getPassword().equals(i.getPassword())))
					return true;
		}
		return logON;
	}
	
	
}
