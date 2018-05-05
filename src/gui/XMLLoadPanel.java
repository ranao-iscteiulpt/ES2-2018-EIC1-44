
package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import org.w3c.dom.Node;

import files.XMLOperations;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Component;

public class XMLLoadPanel extends JPanel {

	final JFileChooser fc = new JFileChooser();
	XMLOperations xmlOperations = new XMLOperations();
	private JTextField textField;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable(model);
	

	/**
	 * Create the panel.			
			
			
	 */
	 public XMLLoadPanel() {
		 
		 SpringLayout springLayout = new SpringLayout();
			setLayout(springLayout);
			
			model.addColumn("Name");
			model.addColumn("Type");
			model.addColumn("Value");
			
			//model.addRow(new Object[]{"asd","aewe3","123asd"});

			JLabel lblNewLabel = new JLabel("Title");
			springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 35, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -351, SpringLayout.SOUTH, this);
			springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -456, SpringLayout.EAST, this);
			add(lblNewLabel);

			JLabel lblVariabels = new JLabel("Variables");
			springLayout.putConstraint(SpringLayout.SOUTH, lblVariabels, -199, SpringLayout.SOUTH, this);
			add(lblVariabels);

			JLabel lblWaitTime = new JLabel("Wait Time");
			springLayout.putConstraint(SpringLayout.EAST, lblVariabels, 0, SpringLayout.EAST, lblWaitTime);
			springLayout.putConstraint(SpringLayout.WEST, lblWaitTime, 0, SpringLayout.WEST, lblNewLabel);
			add(lblWaitTime);

			JLabel lblInvalidValue = new JLabel("Invalid Value");
			springLayout.putConstraint(SpringLayout.NORTH, lblInvalidValue, 0, SpringLayout.NORTH, lblWaitTime);
			add(lblInvalidValue);

			JButton btnImport = new JButton("Import");
			springLayout.putConstraint(SpringLayout.WEST, btnImport, -96, SpringLayout.EAST, this);
			springLayout.putConstraint(SpringLayout.SOUTH, btnImport, -10, SpringLayout.SOUTH, this);
			springLayout.putConstraint(SpringLayout.EAST, btnImport, -10, SpringLayout.EAST, this);
			add(btnImport);



			JLabel lblDescriptioni = new JLabel("Description");
			springLayout.putConstraint(SpringLayout.NORTH, lblWaitTime, 34, SpringLayout.SOUTH, lblDescriptioni);
			springLayout.putConstraint(SpringLayout.NORTH, lblDescriptioni, 29, SpringLayout.SOUTH, lblNewLabel);
			springLayout.putConstraint(SpringLayout.WEST, lblDescriptioni, 0, SpringLayout.WEST, lblNewLabel);
			add(lblDescriptioni);


			

			JScrollPane scrollPane = new JScrollPane(table);
			springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 17, SpringLayout.SOUTH, lblVariabels);
			springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblNewLabel);
			springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -63, SpringLayout.SOUTH, this);
			springLayout.putConstraint(SpringLayout.EAST, scrollPane, -131, SpringLayout.EAST, this);
			add(scrollPane);
			
			JLabel lblTitletext = new JLabel("New label");
			springLayout.putConstraint(SpringLayout.NORTH, lblTitletext, 0, SpringLayout.NORTH, lblNewLabel);
			springLayout.putConstraint(SpringLayout.WEST, lblTitletext, 72, SpringLayout.EAST, lblNewLabel);
			springLayout.putConstraint(SpringLayout.EAST, lblTitletext, -200, SpringLayout.EAST, this);
			add(lblTitletext);
			
			JLabel lblDescriptionText = new JLabel("New label");
			springLayout.putConstraint(SpringLayout.NORTH, lblDescriptionText, 0, SpringLayout.NORTH, lblDescriptioni);
			springLayout.putConstraint(SpringLayout.WEST, lblDescriptionText, 0, SpringLayout.WEST, lblTitletext);
			springLayout.putConstraint(SpringLayout.EAST, lblDescriptionText, 193, SpringLayout.EAST, lblDescriptioni);
			add(lblDescriptionText);
			
			JLabel lblWaittimeText = new JLabel("New label");
			springLayout.putConstraint(SpringLayout.NORTH, lblWaittimeText, 0, SpringLayout.NORTH, lblWaitTime);
			springLayout.putConstraint(SpringLayout.WEST, lblWaittimeText, 0, SpringLayout.WEST, lblTitletext);
			springLayout.putConstraint(SpringLayout.EAST, lblWaittimeText, 199, SpringLayout.EAST, lblWaitTime);
			add(lblWaittimeText);
			
			JLabel lblInvalidValues = new JLabel("New label");
			springLayout.putConstraint(SpringLayout.WEST, lblInvalidValues, 387, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, lblInvalidValues, -10, SpringLayout.EAST, this);
			springLayout.putConstraint(SpringLayout.EAST, lblInvalidValue, -19, SpringLayout.WEST, lblInvalidValues);
			springLayout.putConstraint(SpringLayout.NORTH, lblInvalidValues, 0, SpringLayout.NORTH, lblWaitTime);
			add(lblInvalidValues);
		 
		 btnImport.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {

				 JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				 int returnValue = jfc.showOpenDialog(null);
				 // int returnValue = jfc.showSaveDialog(null);

				 if (returnValue == JFileChooser.APPROVE_OPTION) {
					 File selectedFile = jfc.getSelectedFile();
					 //System.out.println(selectedFile.getAbsolutePath());

					 Node[] xmlFile = xmlOperations.readXML(selectedFile);
					 lblTitletext.setText( xmlFile[0].toString());
//					 lblDescriptionText.setText(xmlFile[1].getTextContent().toString());
//					 lblWaittimeText.setText(xmlFile[2].getTextContent().toString());
//
					 for(Node n : xmlFile) {

						 if(n.getNodeName().equals("variable") )	{
							 
							 String variableName = null;
							 String variableType = null;
							 String variableValue = null;

							 //model.addElement("AAA");
							 for(int i=0; i < n.getChildNodes().getLength()-1; i++) {
								 //System.out.println(n.getChildNodes().item(i).getTextContent());
								// model.addElement(n.getChildNodes().item(i).getTextContent());
								 if(n.getChildNodes().item(i).getNodeName().equals("name"))
									 variableName = n.getChildNodes().item(i).getTextContent();
								 if(n.getChildNodes().item(i).getNodeName().equals("type"))
									 variableType = n.getChildNodes().item(i).getTextContent();
								 if(n.getChildNodes().item(i).getNodeName().equals("value"))
									 variableValue = n.getChildNodes().item(i).getTextContent();
							 }
							 
							 model.addRow(new Object[]{variableName,variableType,variableValue});
						 }
						 
						 if(n.getNodeName().equals("invalidValues"))
							 lblInvalidValues.setText(n.getTextContent());
							 
					 }
					 //lblInvalidText.setText(xmlFile[xmlFile.length]);
				 }

				 //System.out.println(model.getSize());
			 }
		 });

	 }


}
