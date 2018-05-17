/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUITest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import funcionalities.Form;

/**
 *
 * @author Ricardo
 */
public class OptimizationProcess4 extends javax.swing.JPanel {


	private Form form;
	private String fileDirectory;
	private OptimizationProcess3 optimizationPanel;
	private DefaultTableModel fitnessVariables = new DefaultTableModel();
	/**
	 * Creates new form OptimizationProcess4
	 */
	public OptimizationProcess4(Form form, String fileDirectory) {
		this.form = form;
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
		nameTextField = new javax.swing.JTextField();
		jarDirectoryTextField = new javax.swing.JTextField();
		browseButton = new javax.swing.JButton();
		variablesScrollPane = new javax.swing.JScrollPane();
		variablesTable = new javax.swing.JTable();
		addButton = new javax.swing.JButton();
		removeButton = new javax.swing.JButton();
		nameLabel = new javax.swing.JLabel();
		jarLabel = new javax.swing.JLabel();
		loggedInLabel = new javax.swing.JLabel();
		nextButton = new javax.swing.JButton();

		setBackground(new java.awt.Color(255, 255, 255));

		titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titleLabel.setText("Add the fitness variables");

		nameTextField.setForeground(new java.awt.Color(153, 153, 153));
		nameTextField.setText("Variable Name (e.g. False Positive)");
		nameTextField.setToolTipText("");
		nameTextField.setMargin(new java.awt.Insets(2, 15, 2, 2));
		nameTextField.setName(""); // NOI18N

		jarDirectoryTextField.setForeground(new java.awt.Color(153, 153, 153));
		jarDirectoryTextField.setText("Browse your computer");
		jarDirectoryTextField.setToolTipText("");
		jarDirectoryTextField.setMargin(new java.awt.Insets(2, 15, 2, 2));

		browseButton.setText("Browse");

		fitnessVariables.addColumn("Name");
		fitnessVariables.addColumn("JAR file");
		variablesTable.setModel(fitnessVariables);
		variablesScrollPane.setViewportView(variablesTable);

		addButton.setText("Add");

		removeButton.setText("Remove");

		nameLabel.setText("Name");

		jarLabel.setText("Jar");

		loggedInLabel.setText("Logged in as : @var");

		nextButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ricardo\\Desktop\\arrowRight.png")); // NOI18N
		nextButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		nextButton.setFocusable(false);

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nextPanel();				
			}
		});

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addFitnessVariable();

			}
		});

		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String filePath;

				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					filePath = jfc.getSelectedFile().getAbsolutePath();
					String escapedFilepath = filePath.replace("\\","\\\\"); 
					jarDirectoryTextField.setText(escapedFilepath);

				}	
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(66, 66, 66)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(variablesScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(jarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(nameTextField)
																.addComponent(jarDirectoryTextField))
														.addGap(18, 18, 18)
														.addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(44, 44, 44))
								.addGroup(layout.createSequentialGroup()
										.addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(41, 41, 41)
										.addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(nextButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(32, 32, 32)
										.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(41, 41, 41)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jarDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(28, 28, 28)
						.addComponent(variablesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(addButton)
								.addComponent(removeButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
						.addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
	}// </editor-fold>//GEN-END:initComponents

	private void nextPanel() {
		optimizationPanel = new OptimizationProcess3(form, fileDirectory, fitnessVariables);
		form.create(optimizationPanel);
	}

	private void addFitnessVariable() {
		fitnessVariables.addRow(new Object[] {nameTextField.getText(),jarDirectoryTextField.getText()});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addButton;
	private javax.swing.JButton browseButton;
	private javax.swing.JTextField jarDirectoryTextField;
	private javax.swing.JLabel jarLabel;
	private javax.swing.JLabel loggedInLabel;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JButton nextButton;
	private javax.swing.JButton removeButton;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JScrollPane variablesScrollPane;
	private javax.swing.JTable variablesTable;
	// End of variables declaration//GEN-END:variables
}