/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Node;

import files.XMLOperations;
import funcionalities.Optimization;
import jMetal.AntiSpamFilterAutomaticConfiguration;
import jMetal.OptimizationProcess;
import objects.Problem;
import objects.Variable;

/**
 *
 * @author Ricardo
 */
public class OptimizationPanel extends javax.swing.JPanel {

	/**
	 * Creates new form OptimizePanel
	 */
	public OptimizationPanel() {
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

		jScrollBar1 = new javax.swing.JScrollBar();
		optimizationTitle = new javax.swing.JLabel();
		problemLabel = new javax.swing.JLabel();
		problemCB = new javax.swing.JComboBox<>();
		algorithmLabel = new javax.swing.JLabel();
		algorithmCB = new javax.swing.JComboBox<>();
		jScrollPane1 = new javax.swing.JScrollPane();
		variablesTable = new javax.swing.JTable();
		variaveisTitleLabel = new javax.swing.JLabel();
		fitnessName = new javax.swing.JTextField();
		fitnessNameLabel = new javax.swing.JLabel();
		fitnessJarLabel = new javax.swing.JLabel();
		fitnessJarFile = new javax.swing.JTextField();
		addFitnessVariableButton = new javax.swing.JButton();
		optimizeButton = new javax.swing.JButton();
		manualConfigRB = new javax.swing.JRadioButton();
		automaticConfigRB = new javax.swing.JRadioButton();
		addAlgorithmButton = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		algorithmList = new javax.swing.JList<>();
		removeAlgorithmButton = new javax.swing.JButton();
		chosenAlgorithmLabel = new javax.swing.JLabel();
		importJarFileButton = new javax.swing.JButton();

		setPreferredSize(new java.awt.Dimension(660, 628));

		optimizationTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		optimizationTitle.setText("Optimization");

		problemLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		problemLabel.setText("Problem");

		//problemCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		algorithmLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		algorithmLabel.setText("Algorithm");

		algorithmCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

		fitnessVariables.addColumn("Name");
		fitnessVariables.addColumn("JAR file");
		variablesTable.setModel(fitnessVariables);
		jScrollPane1.setViewportView(variablesTable);

		variaveisTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		variaveisTitleLabel.setText("Fitness Variables");

		fitnessNameLabel.setText("Name");

		fitnessJarLabel.setText("JAR");

		addFitnessVariableButton.setText("Add Variable");

		optimizeButton.setText("Done");

		manualConfigRB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		manualConfigRB.setText("Manual Configuration");

		automaticConfigRB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		automaticConfigRB.setText("Automatic Configuration");

		addAlgorithmButton.setText("Add");

		algorithmList.setModel(algorithmsChosenList);
		jScrollPane2.setViewportView(algorithmList);

		removeAlgorithmButton.setText("Remove");

		chosenAlgorithmLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		chosenAlgorithmLabel.setText("Chosen Algorithms");

		importJarFileButton.setText("Import");

		/*  **************************** METODOS CRIADOS **************************** */


		File[] fileList = optimization.searchFiles();

		//metodo que popula combo box
		for (File f: fileList) {
			problemCB.addItem(f.getName());
		}

		for (File f: fileList) {
			resetComboBoxValues();
			if(problemCB.getSelectedItem().equals(f.getName())) {
				receiveData(f);
			}
			fillAlgorithmComboBox();
		}

		problemCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				algorithmsChosenList.removeAllElements();

				if(problemCB.getSelectedIndex() != 0 ) {
					for (File f: fileList) {
						resetComboBoxValues();
						if(problemCB.getSelectedItem().equals(f.getName())) {
							receiveData(f);
						}
						fillAlgorithmComboBox();
					}	
				}
				else {
					for (File f: fileList) {
						resetComboBoxValues();
						if(problemCB.getSelectedItem().equals(f.getName())) {
							receiveData(f);
						}
						fillAlgorithmComboBox();
					}	
				}

			}
		});

		addAlgorithmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if( !isOnList())
					algorithmsChosenList.addElement(algorithmCB.getSelectedItem().toString());	
			}
		});

		removeAlgorithmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(algorithmsChosenList.getSize() > 0 ) {
					int selectedItem = algorithmList.getSelectedIndex();
					algorithmsChosenList.removeElementAt(selectedItem);
				}
			}
		});

		optimizeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fitnessVariables.getRowCount() > 1) {
					optimizationProcess.init(problem,variableType,algorithmsChosenList,fitnessVariables);
				} else 				
				JOptionPane.showMessageDialog(null, "Please add more than 1 fitness variable");
			} 
		});

		addFitnessVariableButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addFitnessVariable();

			}
		});

		importJarFileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String filePath;

				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					filePath = jfc.getSelectedFile().getAbsolutePath();
					String escapedFilepath = filePath.replace("\\","\\\\"); 
					fitnessJarFile.setText(escapedFilepath);
					
				}	
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(275, 275, 275)
										.addComponent(optimizationTitle))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(36, 36, 36)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(problemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(algorithmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(chosenAlgorithmLabel)
																.addComponent(variaveisTitleLabel))
														.addGap(32, 32, 32)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(jScrollPane2)
																.addComponent(algorithmCB, 0, 279, Short.MAX_VALUE)
																.addComponent(problemCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addGroup(layout.createSequentialGroup()
														.addGap(27, 27, 27)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(fitnessJarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(fitnessJarFile))
																.addGroup(layout.createSequentialGroup()
																		.addComponent(fitnessNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(fitnessName, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
														.addContainerGap()
														.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(addAlgorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(removeAlgorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(addFitnessVariableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(importJarFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup()
														.addGap(86, 86, 86)
														.addComponent(optimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(manualConfigRB)
						.addGap(58, 58, 58)
						.addComponent(automaticConfigRB)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(29, 29, 29)
						.addComponent(optimizationTitle)
						.addGap(34, 34, 34)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(manualConfigRB)
								.addComponent(automaticConfigRB))
						.addGap(36, 36, 36)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(problemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(problemCB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(algorithmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(algorithmCB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addAlgorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(removeAlgorithmButton)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(chosenAlgorithmLabel)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(variaveisTitleLabel)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(198, 198, 198)
										.addComponent(optimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(fitnessNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(fitnessName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(fitnessJarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(fitnessJarFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(importJarFileButton))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(21, 21, 21)
														.addComponent(addFitnessVariableButton))
												.addGroup(layout.createSequentialGroup()
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addGap(20, 20, 20))
				);
	}// </editor-fold>//GEN-END:initComponents

	public boolean isOnList() {
		for(int i = 0; i < algorithmsChosenList.getSize() ; i++ ) {
			if(algorithmsChosenList.get(i).equals(algorithmCB.getSelectedItem())) {
				return true;
			}
		}
		return false;
	}

	public void resetComboBoxValues() {
		algorithmCB.removeAllItems();		
	}

	public void fillAlgorithmComboBox() {

		variableType = ((Variable) problem.getVariableList().get(0)).getType(); //integer or double or binary
		if( variableType.equals("double")){
			for(String algorithm : optimizationProcess.getAlgorithmsDouble()) {
				algorithmCB.addItem(algorithm);
			}	
		}

		if(variableType.equals("integer")) {
			for(String algorithm : optimizationProcess.getAlgorithmsInteger() ) {
				algorithmCB.addItem(algorithm);
			}				
		}

		if(variableType.equals("binary")) {
			for(String algorithm : optimizationProcess.getAlgorithmsBinary()) {
				algorithmCB.addItem(algorithm);
			}				
		}	

	}

	public void receiveData (File jfc) {

		variableList.clear();
		String name=""; 
		String description = "";
		String waitTime = "";
		String invalidValue = "";

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
			}
		} catch(Exception e ) {	}
		problem = new Problem(name,description,waitTime,Integer.parseInt(invalidValue),variableCounter,variableList);
	}

	private void addFitnessVariable() {
		fitnessVariables.addRow(new Object[] {fitnessName.getText(),fitnessJarFile.getText()});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addAlgorithmButton;
	private javax.swing.JButton addFitnessVariableButton;
	private javax.swing.JComboBox<String> algorithmCB;
	private javax.swing.JLabel algorithmLabel;
	private javax.swing.JList<String> algorithmList;
	private javax.swing.JRadioButton automaticConfigRB;
	private javax.swing.JLabel chosenAlgorithmLabel;
	private javax.swing.JTextField fitnessJarFile;
	private javax.swing.JLabel fitnessJarLabel;
	private javax.swing.JTextField fitnessName;
	private javax.swing.JLabel fitnessNameLabel;
	private javax.swing.JButton importJarFileButton;
	private javax.swing.JScrollBar jScrollBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JRadioButton manualConfigRB;
	private javax.swing.JLabel optimizationTitle;
	private javax.swing.JButton optimizeButton;
	private javax.swing.JComboBox<String> problemCB;
	private javax.swing.JLabel problemLabel;
	private javax.swing.JButton removeAlgorithmButton;
	private javax.swing.JTable variablesTable;
	private javax.swing.JLabel variaveisTitleLabel;
	// End of variables declaration//GEN-END:variables
	private Optimization optimization = new Optimization();
	private XMLOperations xmlOperations = new XMLOperations();
	private AntiSpamFilterAutomaticConfiguration antiSpamFilter = new AntiSpamFilterAutomaticConfiguration();
	private Problem problem;
	private OptimizationProcess optimizationProcess = new OptimizationProcess();
	private Variable variable;
	private ArrayList<Variable> variableList = new ArrayList<Variable>();
	private File fileTemp;
	private File file;
	private int variableCounter=0;
	private File choosenFile;
	private DefaultListModel<String> algorithmsChosenList = new DefaultListModel<String>();
	private String variableType=""; 
	private DefaultTableModel fitnessVariables = new DefaultTableModel();

}
