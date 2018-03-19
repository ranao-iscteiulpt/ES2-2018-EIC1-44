package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import xml.XMLOperations;



public class ProblemPanel extends JPanel {

	private JTextField titleTextField;
	private JTextField waitTimeTextField;
	private JTextField invalidValueTextField;
	private JTextArea descriptionTextArea;
	private DefaultTableModel model = new DefaultTableModel();
	private XMLOperations xml = new XMLOperations();
	private JTable table = new JTable(model);
	//private String[] columns = {"Title","Tipo", "Valor"};

	/**
	 * Create the panel.
	 */
	public ProblemPanel() {

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Value");

		JLabel lblNewLabel = new JLabel("Title");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 34, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 149, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -342, SpringLayout.EAST, this);
		add(lblNewLabel);

		titleTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, titleTextField, -3, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, titleTextField, 6, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, titleTextField, -153, SpringLayout.EAST, this);
		add(titleTextField);
		titleTextField.setColumns(10);

		JLabel lblVariabels = new JLabel("Variables");
		springLayout.putConstraint(SpringLayout.WEST, lblVariabels, 35, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblVariabels, -346, SpringLayout.SOUTH, this);
		add(lblVariabels);

		JLabel lblWaitTime = new JLabel("Wait Time");
		add(lblWaitTime);

		waitTimeTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, waitTimeTextField, 24, SpringLayout.EAST, lblWaitTime);
		springLayout.putConstraint(SpringLayout.NORTH, lblWaitTime, 3, SpringLayout.NORTH, waitTimeTextField);
		add(waitTimeTextField);
		waitTimeTextField.setColumns(10);

		JLabel lblInvalidValue = new JLabel("Invalid Value");
		springLayout.putConstraint(SpringLayout.EAST, waitTimeTextField, -73, SpringLayout.WEST, lblInvalidValue);
		springLayout.putConstraint(SpringLayout.EAST, lblInvalidValue, -208, SpringLayout.EAST, this);
		add(lblInvalidValue);

		invalidValueTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, invalidValueTextField, 19, SpringLayout.EAST, lblInvalidValue);
		springLayout.putConstraint(SpringLayout.EAST, invalidValueTextField, -89, SpringLayout.EAST, this);
		add(invalidValueTextField);
		invalidValueTextField.setColumns(10);

		JButton btnDone = new JButton("Done");
		springLayout.putConstraint(SpringLayout.WEST, btnDone, -96, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDone, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnDone, -10, SpringLayout.EAST, this);
		add(btnDone);

		descriptionTextArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, descriptionTextArea, 35, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, descriptionTextArea, -59, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, descriptionTextArea, -44, SpringLayout.EAST, this);
		add(descriptionTextArea);



		JLabel lblDescriptioni = new JLabel("Description");
		springLayout.putConstraint(SpringLayout.EAST, lblWaitTime, 0, SpringLayout.EAST, lblDescriptioni);
		springLayout.putConstraint(SpringLayout.NORTH, lblDescriptioni, 253, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, descriptionTextArea, 6, SpringLayout.SOUTH, lblDescriptioni);
		springLayout.putConstraint(SpringLayout.WEST, lblDescriptioni, 32, SpringLayout.WEST, this);
		add(lblDescriptioni);



			

		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -221, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, invalidValueTextField, 6, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, lblInvalidValue, 9, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, waitTimeTextField, 6, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblVariabels);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 35, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -44, SpringLayout.EAST, this);
		add(scrollPane);

		JButton addVariableButton = new JButton("+");
		springLayout.putConstraint(SpringLayout.WEST, addVariableButton, 10, SpringLayout.EAST, lblVariabels);
		springLayout.putConstraint(SpringLayout.SOUTH, addVariableButton, 0, SpringLayout.SOUTH, lblVariabels);
		add(addVariableButton);

		addVariableButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				model.addRow(new Object[]{"","",""});
			}
		});

		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xml.writeXML(titleTextField.getText(), model ,descriptionTextArea.getText(), waitTimeTextField.getText(), invalidValueTextField.getText());

				JOptionPane.showMessageDialog(btnDone, "XML Created");

			}
		});

	}

}

