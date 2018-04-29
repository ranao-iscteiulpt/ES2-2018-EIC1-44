/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.omg.PortableInterceptor.DISCARDING;
import org.w3c.dom.Node;

import files.XMLOperations;

/**
 *
 * @author Ricardo
 */
public class OpenXMLPanel extends javax.swing.JPanel {

	private File file;
	XMLOperations xmlOperations = new XMLOperations();

	/**
	 * Creates new form OpenXMLPanel
	 */

	public OpenXMLPanel(File jfc) {
		initComponents();
		receiveData(jfc);
	}

	public void receiveData (File jfc) {
		try {
			model.setRowCount(0);
			file = jfc;
			Node[] xmlFile = xmlOperations.readXML(file);
			nameTF.setText( xmlFile[0].getTextContent().toString());
			descriptionTA.setText(xmlFile[1].getTextContent().toString());
			waitTimeTF.setText(xmlFile[2].getTextContent().toString());

			for(Node n : xmlFile) {

				if(n.getNodeName().equals("variable") )	{

					String variableName = "";
					String variableType = "";
					String variableMinimumValue = "";
					String variableMaximumValue = "";

					//model.addElement("AAA");
					for(int i=0; i < n.getChildNodes().getLength(); i++) {
						System.out.println(n.getChildNodes().item(i).getTextContent());
						// model.addElement(n.getChildNodes().item(i).getTextContent());
						if(n.getChildNodes().item(i).getNodeName().equals("name"))
							variableName = n.getChildNodes().item(i).getTextContent();
						if(n.getChildNodes().item(i).getNodeName().equals("type"))
							variableType = n.getChildNodes().item(i).getTextContent();
						if(n.getChildNodes().item(i).getNodeName().equals("minimumValue"))
							variableMinimumValue = n.getChildNodes().item(i).getTextContent();
						if(n.getChildNodes().item(i).getNodeName().equals("maximumValue"))
							variableMaximumValue = n.getChildNodes().item(i).getTextContent();
					}

					model.addRow(new Object[]{variableName,variableType,variableMinimumValue,variableMaximumValue});
				}

				if(n.getNodeName().equals("invalidValues"))
					invalidValueTF.setText(n.getTextContent());

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//lblInvalidText.setText(xmlFile[xmlFile.length]);
	}



	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        waitTimeLabel = new javax.swing.JLabel();
        invalidValueLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        variablesTable = new javax.swing.JTable();
        variableNameLabel = new javax.swing.JLabel();
        variableNameTF = new javax.swing.JTextField();
        varMinLabel = new javax.swing.JLabel();
        variableMinValueTF = new javax.swing.JTextField();
        varMaxLabel = new javax.swing.JLabel();
        variableMaxValueTF = new javax.swing.JTextField();
        variableTypeTF = new javax.swing.JTextField();
        varTypeLabel = new javax.swing.JLabel();
        addVariableButton = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        editWaitTimeButton = new javax.swing.JButton();
        editNameButton = new javax.swing.JButton();
        editInvalidValueButton = new javax.swing.JButton();
        editDescriptionButton = new javax.swing.JButton();
        nameTF = new javax.swing.JTextField();
        invalidValueTF = new javax.swing.JTextField();
        waitTimeTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTA = new javax.swing.JTextArea();

        waitTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        waitTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        waitTimeLabel.setText("Wait Time");

        invalidValueLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        invalidValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invalidValueLabel.setText("Invalid Value");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nameLabel.setText("Name");

        model = new javax.swing.table.DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		variablesTable.setModel(model);
		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Min Value");
		model.addColumn("Max Value");
        jScrollPane1.setViewportView(variablesTable);

        variableNameLabel.setText("Name");

        variableNameTF.setEditable(false);
        varMinLabel.setText("Min Value");

        variableMinValueTF.setEditable(false);
        variableMinValueTF.setName(""); // NOI18N
        varMaxLabel.setText("Max Value");

        variableMaxValueTF.setEditable(false);
        variableTypeTF.setEditable(false);
        varTypeLabel.setText("Type");

        addVariableButton.setText("Add");

        descriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLabel.setText("Description");

        editWaitTimeButton.setForeground(new java.awt.Color(51, 102, 255));
        editWaitTimeButton.setText("Editar");
        editWaitTimeButton.setBorderPainted(false);
        editWaitTimeButton.setContentAreaFilled(false);
        editWaitTimeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
editWaitTimeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(waitTimeTF.isEditable()) {
					waitTimeTF.setEditable(false);
					waitTimeTF.setBackground(new Color(240,240,240));
				} else {
					waitTimeTF.setEditable(true);
					waitTimeTF.setBackground(new Color(255,255,255));
				}				
			}
		});

        editNameButton.setForeground(new java.awt.Color(51, 102, 255));
        editNameButton.setText("Editar");
        editNameButton.setBorderPainted(false);
        editNameButton.setContentAreaFilled(false);
        editNameButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        editNameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameTF.isEditable()) {
					nameTF.setEditable(false);
					nameTF.setBackground(new Color(240,240,240));
				} else {
					nameTF.setEditable(true);
					nameTF.setBackground(new Color(255,255,255));
				}
			}
		});

        editInvalidValueButton.setForeground(new java.awt.Color(51, 102, 255));
        editInvalidValueButton.setText("Editar");
        editInvalidValueButton.setBorderPainted(false);
        editInvalidValueButton.setContentAreaFilled(false);
        editInvalidValueButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        editInvalidValueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(invalidValueTF.isEditable()) {
					invalidValueTF.setEditable(false);
					invalidValueTF.setBackground(new Color(240,240,240));
				} else {
					invalidValueTF.setEditable(true);
					invalidValueTF.setBackground(new Color(255,255,255));
				}

			}
		});

        editDescriptionButton.setForeground(new java.awt.Color(51, 102, 255));
        editDescriptionButton.setText("Editar");
        editDescriptionButton.setBorderPainted(false);
        editDescriptionButton.setContentAreaFilled(false);
        editDescriptionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        editDescriptionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(descriptionTA.isEditable()) {
					descriptionTA.setEditable(false);
					descriptionTA.setBackground(new Color(240,240,240));
				} else {
					descriptionTA.setEditable(true);
					descriptionTA.setBackground(new Color(255,255,255));
				}
			}
		});

        nameTF.setEditable(false);
        nameTF.setBorder(null);

        invalidValueTF.setEditable(false);
        invalidValueTF.setBorder(null);

        waitTimeTF.setEditable(false);
        waitTimeTF.setBorder(null);

        descriptionTA.setEditable(false);
        descriptionTA.setColumns(20);
        descriptionTA.setRows(5);
        descriptionTA.setBorder(null);
        jScrollPane2.setViewportView(descriptionTA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(waitTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invalidValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(invalidValueTF, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(waitTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editWaitTimeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editInvalidValueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addVariableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(varMaxLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(varMinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(variableMinValueTF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(variableMaxValueTF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(varTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(variableNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(variableTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(variableNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(editDescriptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editNameButton))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(waitTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editWaitTimeButton)
                    .addComponent(waitTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invalidValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editInvalidValueButton)
                    .addComponent(invalidValueTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(variableNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(variableNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(variableTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varMinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(variableMinValueTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varMaxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(variableMaxValueTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(addVariableButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(editDescriptionButton)))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVariableButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionTA;
    private javax.swing.JButton editDescriptionButton;
    private javax.swing.JButton editInvalidValueButton;
    private javax.swing.JButton editNameButton;
    private javax.swing.JButton editWaitTimeButton;
    private javax.swing.JLabel invalidValueLabel;
    private javax.swing.JTextField invalidValueTF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel varMaxLabel;
    private javax.swing.JLabel varMinLabel;
    private javax.swing.JLabel varTypeLabel;
    private javax.swing.JTextField variableMaxValueTF;
    private javax.swing.JTextField variableMinValueTF;
    private javax.swing.JLabel variableNameLabel;
    private javax.swing.JTextField variableNameTF;
    private javax.swing.JTextField variableTypeTF;
    private javax.swing.JTable variablesTable;
    private javax.swing.JLabel waitTimeLabel;
    private javax.swing.JTextField waitTimeTF;
    // End of variables declaration//GEN-END:variables

	private javax.swing.table.DefaultTableModel model;


}