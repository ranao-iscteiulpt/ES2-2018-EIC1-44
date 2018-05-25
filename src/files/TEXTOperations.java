package files;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import objects.Problem;
import objects.User;

public class TEXTOperations {

	private FileWriter fileWriter;
	private File f = new File("Records");
	private File fileGraph = new File("graph/optimization-results.tsv");
	private DefaultTableModel fitnessVariables;
	private FileWriter fw;
	private Problem problem;

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

	public void createGraph(ArrayList<String> jarList, DefaultListModel<String> algorithmsChosenList, Problem problem ) {


		try {
			if(fileGraph.exists()) {
				fileGraph.delete();
			}
			fileGraph.createNewFile();
			fw = new FileWriter(fileGraph, true);
			String initial = "Algoritmos";
			for(int i=0; i < jarList.size(); i++) {
				initial+= "	"+jarList.get(i);
			}
			initial+="	Tempo de Execucao\n";
			fw.write(initial);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i < algorithmsChosenList.size(); i++) {
			//Mudar directorio
			File bestResults = new File("experimentBaseDirectory/ExperimentsDoubleExternalViaJAR/data/"+algorithmsChosenList.get(i)+"/MyProblemDoubleExternalViaJAR/BEST_HV_FUN.tsv");

			Scanner sc = null;

			try {
				sc = new Scanner(bestResults);
				while(sc.hasNext()) {
					String line = sc.nextLine();
					String[] tokens = line.split(" ");
					boolean isInvalid = false;
					//Obter algoritmo, colunas da otimização (FP,FN) e tempo de execução
					//aqui fazer outro for para os jars
					String values = algorithmsChosenList.get(i);
					for(int j =0; j < jarList.size(); j++) {
						//problem.getfirstinvalidvalue
						//problem.getsecondinvalidvalue
						if( Double.parseDouble(tokens[j]) >= problem.getFirstInvalidValue() && Double.parseDouble(tokens[j]) <= problem.getSecondInvalidValue())
							isInvalid = true;
						values+="	" + tokens[j];

					}
					values+="	300\n";
					try {
						if(!isInvalid) {
							fw.append(values);
						} else {
						System.out.println("falhei no append");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fw.close();
			Desktop.getDesktop().browse(new File("graph/optimizationGraph.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
