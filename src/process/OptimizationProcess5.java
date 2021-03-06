/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import files.TEXTOperations;
import funcionalities.Email;
import funcionalities.Form;
import jMetal.OptimizationProcess;
import objects.Problem;
import objects.User;

/**
 *
 * @author Ricardo
 */
public class OptimizationProcess5 extends javax.swing.JPanel {

	private Form form;
	private OptimizationProcess optimizationProcess = new OptimizationProcess();
	private Problem problem;
	private String variableType;
	private DefaultListModel<String> algorithmsChosenList;
	private DefaultTableModel fitnessVariables;
	private int progressPercent=0;
	private User userLoggedIn;
	private ArrayList<String> jarList;
	private TEXTOperations textOperations = new TEXTOperations();
	private WelcomePage welcomePage;
	private Email email = new Email();
	private String oldMessage ="";
	private String fileDirectory;
	/**
	 * Creates new form OptimizationProcess5
	 * @param fitnessVariables 
	 * @param algorithmsChosenList 
	 * @param variableType 
	 * @param problem 
	 */
	public OptimizationProcess5(Form form, Problem problem, String variableType, DefaultListModel<String> algorithmsChosenList, DefaultTableModel fitnessVariables, User userLoggedIn,ArrayList<String> jarList, String fileDirectory) {
		this.form = form;
		this.userLoggedIn = userLoggedIn;
		this.problem = problem;
		this.variableType = variableType;
		this.algorithmsChosenList = algorithmsChosenList;
		this.fitnessVariables = fitnessVariables;
		this.jarList = jarList;
		this.fileDirectory = fileDirectory;
		initComponents(); 
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		titleLabel = new javax.swing.JLabel();
		optimizationProgressBar = new javax.swing.JProgressBar();
		optimizationProgressLabel = new javax.swing.JLabel();
		loggedInLabel = new javax.swing.JLabel();
		nextButton = new javax.swing.JButton("Menu");
		startButton = new javax.swing.JButton();

		setBackground(new java.awt.Color(255, 255, 255));

		titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titleLabel.setText("Optimization Status");

		optimizationProgressBar.setValue(0);

		optimizationProgressLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		optimizationProgressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		optimizationProgressLabel.setText("0%");
		optimizationProgressLabel.setVisible(false);
		optimizationProgressBar.setVisible(false);

		loggedInLabel.setText("Logged in as: " + userLoggedIn.getUsername());

		nextButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		nextButton.setFocusable(false);
		nextButton.setVisible(false);

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nextPanel();				
			}
		});

		startButton.setText("Start Optimization");
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setVisible(false);
				optimizationProgressLabel.setVisible(true);
				optimizationProgressBar.setVisible(true);

				Thread t1 = new Thread() {
					public void run() {
						String mailMessage = "Muito obrigado por usar esta  plataforma de otimiza��o. "
								+ "Ser� informado por email sobre o progresso do processo de otimiza��o,"
								+ " quando o processo de otimiza��o tiver atingido 25%, 50%, 75%  do  total "
								+ " do (n�mero  de  avalia��es  ou) tempo estimado,  e  tamb�m  quando  o  "
								+ "processo  tiver terminado, com sucesso ou devido � ocorr�ncia de erros.";
						email.sendEmailWithAttachment(userLoggedIn.getEmail(), userLoggedIn.getPassword(), "Optimization in course "+problem.getName(), mailMessage, fileDirectory,problem.getName());
						optimizationStart();

						if(variableType.equals("double"))
							textOperations.createGraph(jarList,algorithmsChosenList,problem,variableType,optimizationProcess.getExperimentsDouble().getEstimatedTime());
						if(variableType.equals("integer"))
							textOperations.createGraph(jarList,algorithmsChosenList,problem,variableType,optimizationProcess.getExperimentsInteger().getEstimatedTime());
						if(variableType.equals("binary"))
							textOperations.createGraph(jarList,algorithmsChosenList,problem,variableType,optimizationProcess.getExperimentsBinary().getEstimatedTime());
						nextButton.setVisible(true);

					}
				};
				t1.start();				
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(45, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(optimizationProgressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(348, 348, 348))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(247, 247, 247))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(optimizationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(35, 35, 35))))
				.addGroup(layout.createSequentialGroup()
						.addGap(315, 315, 315)
						.addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(15, 15, 15)
						.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(73, 73, 73)
						.addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(optimizationProgressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(optimizationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
						.addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Method to remove the current panel and add the next one
	 */

	private void nextPanel() {
		welcomePage = new WelcomePage(form,userLoggedIn);
		form.create(welcomePage);
	}

	/**
	 * Method to start the optimization process
	 */

	public void optimizationStart() {
		System.out.println(problem+" type "+ variableType + " algorithmsChosenlist " + algorithmsChosenList + " fitness " + fitnessVariables);
		optimizationProcess.init(problem,variableType,algorithmsChosenList,fitnessVariables,this);
	}

	/**
	 * Method fill the progress bar with percentage completed
	 */

	public void updateProgressBar()	{
		t.start();
	}

	Thread t = new Thread(){
		public void run(){
			while(progressPercent <= 100) {
				optimizationProgressBar.setValue(progressPercent);
				optimizationProgressBar.repaint();
				if(progressPercent == 25)
					updateMessage("Optimization progress reached 25%");
				if(progressPercent == 50)
					updateMessage("Optimization progress reached 50%");
				if(progressPercent == 75)
					updateMessage("Optimization progress reached 75%");	
				if(progressPercent == 100)
					updateMessage("Optimization progress reached 100%");	
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {}
			}
		}
	};

	/**
	 * Method to change message sent based on percentage completed
	 * @param mailMessage message text to change
	 */

	public void updateMessage(String mailMessage) {
		if(!oldMessage.equals(mailMessage)) {
			email.updateUser(mailMessage);
		}
		oldMessage = mailMessage;
	}

	/**
	 * Method to change the number of percentage completed
	 * @param percent 
	 */

	public void setProgressPercent(int percent) {
		if(percent<=100) {
			progressPercent = percent;
			optimizationProgressLabel.setText(String.valueOf(percent)+"%");
		}

	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel loggedInLabel;
	private javax.swing.JButton nextButton;
	private javax.swing.JProgressBar optimizationProgressBar;
	private javax.swing.JLabel optimizationProgressLabel;
	private javax.swing.JButton startButton;
	private javax.swing.JLabel titleLabel;
	// End of variables declaration//GEN-END:variables
}
