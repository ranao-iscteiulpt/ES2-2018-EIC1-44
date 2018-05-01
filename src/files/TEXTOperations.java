package files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import objects.User;

public class TEXTOperations {
	
	private FileWriter fileWriter;
	private File f = new File("Registos");

	public void createRegister(String userText, String passwordText, String emailText){

		try {
			
			if(!f.exists()){
				f.createNewFile();
			}
			
			fileWriter = new FileWriter(f,true);
			fileWriter.append(userText + " " + passwordText + " " + emailText + "\n");
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fillArray(ArrayList<User> users) {
		
		users.clear();
		
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				String[] tokens = line.split(" ");
				users.add(new User(tokens[0], tokens[1], tokens[2]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
