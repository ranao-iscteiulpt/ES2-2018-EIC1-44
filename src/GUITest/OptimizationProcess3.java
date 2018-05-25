/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUITest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Node;

import files.XMLOperations;
import funcionalities.Form;
import funcionalities.Optimization;
import jMetal.OptimizationProcess;
import objects.Problem;
import objects.User;
import objects.Variable;

/**
 *
 * @author Ricardo
 */
public class OptimizationProcess3 extends javax.swing.JPanel {

	private Form form;
	private String fileDirectory;
	private Optimization optimization = new Optimization();
	private OptimizationProcess5 optimizationPanel;
	private DefaultListModel<String> algorithmsChosenList = new DefaultListModel<String>();
	private ArrayList<Variable> variableList = new ArrayList<Variable>();
	private File file;
	private int variableCounter=0;
	private Variable variable;
	private XMLOperations xmlOperations = new XMLOperations();
	private Problem problem;
	private OptimizationProcess optimizationProcess = new OptimizationProcess();
	private String variableType=""; 
	private DefaultTableModel fitnessVariables;
	private ButtonGroup radioButtonGroup = new ButtonGroup();
	private User userLoggedIn;
	private ArrayList<String> jarList;

	/** Creates new form OptimizationProcess3 */
	public OptimizationProcess3(Form form, String fileDirectory, DefaultTableModel fitnessVariables, User userLoggedIn, ArrayList<String> jarList) {
		this.form = form;
		this.userLoggedIn = userLoggedIn;
		this.fileDirectory = fileDirectory;
		this.fitnessVariables = fitnessVariables;
		this.jarList= jarList;
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	public void initComponents() {

		manualConfigRButton = new javax.swing.JRadioButton();
		automaticConfigRButton = new javax.swing.JRadioButton();
		titleLabel = new javax.swing.JLabel();
		configPanel = new javax.swing.JPanel();
		filesComboBox = new javax.swing.JComboBox<>();
		xmlFilesLabel = new javax.swing.JLabel();
		algorithmLabel = new javax.swing.JLabel();
		algorithmComboBox = new javax.swing.JComboBox<>();
		addButton = new javax.swing.JButton();
		algorithmChosenListScrollPane = new javax.swing.JScrollPane();
		algorithmList = new javax.swing.JList<>();
		removeButton = new javax.swing.JButton();
		chosenAlgorithmLabel = new javax.swing.JLabel();
		finishButton = new javax.swing.JButton();
		loggedInLabel = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 255));

		manualConfigRButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		manualConfigRButton.setText("Manual");

		automaticConfigRButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		automaticConfigRButton.setText("Automatic");

		titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		titleLabel.setText("Choose a type of configuration");

		// filesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

		xmlFilesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		xmlFilesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		xmlFilesLabel.setText("XML Files");

		algorithmLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		algorithmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		algorithmLabel.setText("Algorithm");

		algorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

		addButton.setText("Add");

		algorithmList.setModel(algorithmsChosenList);
		algorithmChosenListScrollPane.setViewportView(algorithmList);

		removeButton.setText("Remove");
		removeButton.setToolTipText("");

		chosenAlgorithmLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		chosenAlgorithmLabel.setText("Chosen Algorithms");

		finishButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		finishButton.setText("Finish");
		finishButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		finishButton.setFocusable(false);
		radioButtonGroup.add(automaticConfigRButton);
		radioButtonGroup.add(manualConfigRButton);

		configPanel.setEnabled(false);

		System.out.println(fileDirectory);
		File[] fileList = optimization.searchFiles(fileDirectory);
		System.out.println(fileList);

		for (File f: fileList) {
			filesComboBox.addItem(f.getName());
			//resetComboBoxValues();
			if(filesComboBox.getSelectedItem().equals(f.getName())) {
				receiveData(f);
			}
		}

		automaticConfigRButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				configPanel.setEnabled(true);
				resetComboBoxValues();
				resetChoosenAlgorithms();
				fillAlgorithmComboBoxAutomaticConfig();
			}
		});

		manualConfigRButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				configPanel.setEnabled(true);
				resetComboBoxValues();
				resetChoosenAlgorithms();
				fillAlgorithmComboBoxManualConfig();				
			}
		});

		filesComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetChoosenAlgorithms();

				if(filesComboBox.getSelectedIndex() != 0 ) {
					for (File f: fileList) {
						resetComboBoxValues();
						if(filesComboBox.getSelectedItem().equals(f.getName())) {
							receiveData(f);
						}
						fillAlgorithmComboBoxAutomaticConfig();
					}	
				}

			}
		});

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if( !isOnList())
					algorithmsChosenList.addElement(algorithmComboBox.getSelectedItem().toString());	
			}
		});

		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeSelectedAlgorithm();
			}
		});


		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fitnessVariables.getRowCount() > 1) {

					nextPanel();
				} else 				
					JOptionPane.showMessageDialog(null, "Please add more than 1 fitness variable");

			}
		});

		javax.swing.GroupLayout configPanelLayout = new javax.swing.GroupLayout(configPanel);
		configPanel.setLayout(configPanelLayout);
		configPanelLayout.setHorizontalGroup(
				configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(configPanelLayout.createSequentialGroup()
						.addGap(29, 29, 29)
						.addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(algorithmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(xmlFilesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
										.addComponent(filesComboBox, 0, 272, Short.MAX_VALUE))
								.addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
						.addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createSequentialGroup()
												.addComponent(algorithmChosenListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(73, 73, 73))
										.addGroup(configPanelLayout.createSequentialGroup()
												.addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap()))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createSequentialGroup()
										.addComponent(chosenAlgorithmLabel)
										.addGap(170, 170, 170))))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		configPanelLayout.setVerticalGroup(
				configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(configPanelLayout.createSequentialGroup()
						.addGap(30, 30, 30)
						.addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(xmlFilesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(chosenAlgorithmLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(configPanelLayout.createSequentialGroup()
										.addComponent(filesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(39, 39, 39)
										.addComponent(algorithmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(algorithmChosenListScrollPane))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(removeButton)
								.addComponent(addButton))
						.addGap(18, 18, 18)
						.addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		loggedInLabel.setText("Logged in as : " + userLoggedIn.getUsername());

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addComponent(manualConfigRButton)
										.addGap(65, 65, 65)
										.addComponent(automaticConfigRButton)
										.addGap(279, 279, 279))))
				.addGroup(layout.createSequentialGroup()
						.addGap(213, 213, 213)
						.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
						.addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(26, 26, 26)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(manualConfigRButton)
								.addComponent(automaticConfigRButton))
						.addGap(18, 18, 18)
						.addComponent(configPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
	}// </editor-fold>//GEN-END:initComponents

	private void nextPanel() {
		//optimizationProcess.init(problem,variableType,algorithmsChosenList,fitnessVariables);
		optimizationPanel = new OptimizationProcess5(form, problem , variableType, algorithmsChosenList, fitnessVariables,userLoggedIn,jarList);
		//System.out.println("P: " + problem+ ", VarType: "+ variableType+",Algorithms: "+ algorithmsChosenList+",fitness: "+ fitnessVariables);
		form.create(optimizationPanel);
		//optimizationPanel.optimizationStart();
	}

	public boolean isOnList() {
		for(int i = 0; i < algorithmsChosenList.getSize() ; i++ ) {
			if(algorithmsChosenList.get(i).equals(algorithmComboBox.getSelectedItem())) {
				return true;
			}
		}
		return false;
	}

	public void resetComboBoxValues() {
		algorithmComboBox.removeAllItems();		
	}

	public void resetChoosenAlgorithms() {
		algorithmsChosenList.removeAllElements();		
	}

	public void removeSelectedAlgorithm() {
		if(algorithmsChosenList.getSize() > 0 ) {
			int selectedItem = algorithmList.getSelectedIndex();
			algorithmsChosenList.removeElementAt(selectedItem);
		}
	}

	public void fillAlgorithmComboBoxAutomaticConfig() {

		variableType = ((Variable) problem.getVariableList().get(0)).getType(); //integer or double or binary
		if( variableType.equals("double")){
			for(String algorithm : optimizationProcess.getAlgorithmsDouble()) {
				algorithmComboBox.addItem(algorithm);
			}	
		}

		if(variableType.equals("integer")) {
			for(String algorithm : optimizationProcess.getAlgorithmsInteger() ) {
				algorithmComboBox.addItem(algorithm);
			}				
		}

		if(variableType.equals("binary")) {
			for(String algorithm : optimizationProcess.getAlgorithmsBinary()) {
				algorithmComboBox.addItem(algorithm);
			}				
		}	

	}

	public void fillAlgorithmComboBoxManualConfig() {
		for(String algorithm: optimizationProcess.getAlgorithmsManual()) {
			algorithmComboBox.addItem(algorithm);
		}
	}


	public void receiveData (File jfc) {

		variableList.clear();
		String name=""; 
		String description = "";
		String waitTime = "";
		String invalidValue = "";
		String firstInvalidValue ="";
		String secondInvalidValue = "";

		try {
			file = jfc;
			Node[] xmlFile = xmlOperations.readXML(file);
			name = xmlFile[0].getTextContent();
			description = xmlFile[1].getTextContent();
			waitTime = xmlFile[2].getTextContent();

			for(Node n : xmlFile) {

				if(n.getNodeName().equals("variable") )	{
					variableCounter++;
					String variableName = "";
					String variableType = "";
					String variableMinimumValue = "";
					String variableMaximumValue = "";

					for(int i=0; i < n.getChildNodes().getLength(); i++) {
						if(n.getChildNodes().item(i).getNodeName().equals("name"))
							variableName = n.getChildNodes().item(i).getTextContent();
						if(n.getChildNodes().item(i).getNodeName().equals("type"))
							variableType = n.getChildNodes().item(i).getTextContent();
						if(n.getChildNodes().item(i).getNodeName().equals("minimumValue"))
							variableMinimumValue = n.getChildNodes().item(i).getTextContent();
						if(n.getChildNodes().item(i).getNodeName().equals("maximumValue"))
							variableMaximumValue = n.getChildNodes().item(i).getTextContent();
					}

					if(variableType.equals("integer"))
						variable = new Variable (variableName, variableType, Integer.parseInt(variableMinimumValue), Integer.parseInt(variableMaximumValue));
					if(variableType.equals("double"))
						variable = new Variable (variableName, variableType, Double.parseDouble(variableMinimumValue), Double.parseDouble(variableMaximumValue));
					if(variableType.equals("binary"))
						variable = new Variable (variableName, variableType, Integer.parseInt(variableMinimumValue), Integer.parseInt(variableMaximumValue));

					variableList.add(variable);
				}

				if(n.getNodeName().equals("invalidValues"))
					invalidValue = n.getTextContent();
				if(n.getNodeName().equals("firstInvalidValue"))
					firstInvalidValue = n.getTextContent();
				if(n.getNodeName().equals("secondInvalidValue"))
					secondInvalidValue = n.getTextContent();
			}
		} catch(Exception e ) {	}
		if(!invalidValue.equals("")) {
			problem = new Problem(name,description,waitTime,Integer.parseInt(invalidValue),variableCounter,variableList);
		} else {
			problem = new Problem(name,description,waitTime,Integer.parseInt(firstInvalidValue),Integer.parseInt(secondInvalidValue),variableCounter,variableList);
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addButton;
	private javax.swing.JScrollPane algorithmChosenListScrollPane;
	private javax.swing.JComboBox<String> algorithmComboBox;
	private javax.swing.JLabel algorithmLabel;
	private javax.swing.JList<String> algorithmList;
	private javax.swing.JRadioButton automaticConfigRButton;
	private javax.swing.JLabel chosenAlgorithmLabel;
	private javax.swing.JPanel configPanel;
	private javax.swing.JComboBox<String> filesComboBox;
	private javax.swing.JButton finishButton;
	private javax.swing.JLabel loggedInLabel;
	private javax.swing.JRadioButton manualConfigRButton;
	private javax.swing.JButton removeButton;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JLabel xmlFilesLabel;
	// End of variables declaration//GEN-END:variables

}
