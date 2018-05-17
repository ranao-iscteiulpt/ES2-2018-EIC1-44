/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUITest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import funcionalities.Form;

/**
 *
 * @author Ricardo
 */
public class ProblemProcess2 extends javax.swing.JPanel {

	private Form form;
	private ProblemProcess3 problemPanel;

	/**
	 * Creates new form ProblemProcess2
	 */
	public ProblemProcess2(Form form) {
		this.form = form;

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

		nameTextfield = new javax.swing.JTextField();
		nextButton = new javax.swing.JButton();
		descriptionLabel = new javax.swing.JLabel();
		descriptionScrollPane = new javax.swing.JScrollPane();
		descriptionTextfield = new javax.swing.JTextArea();
		nameLabel = new javax.swing.JLabel();
		titleLabel = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 255));

		nameTextfield.setForeground(new java.awt.Color(153, 153, 153));
		//nameTextfield.setText("e.g. rule ");
		nameTextfield.setMargin(new java.awt.Insets(2, 15, 2, 2));

		nextButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ricardo\\Desktop\\arrowRight.png")); // NOI18N
		nextButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		nextButton.setFocusable(false);

		descriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		descriptionLabel.setText("Description");

		descriptionTextfield.setColumns(20);
		descriptionTextfield.setForeground(new java.awt.Color(153, 153, 153));
		descriptionTextfield.setRows(5);
		//descriptionTextfield.setText("e.g. this is a problem for our company");
		descriptionTextfield.setMargin(new java.awt.Insets(2, 15, 2, 2));
		descriptionScrollPane.setViewportView(descriptionTextfield);

		nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		nameLabel.setText("Problem name");

		titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titleLabel.setText("Create a problem");


		nextButton.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				if(!nameTextfield.getText().equals("") && !descriptionTextfield.getText().equals("")) {
					nextPanel(nameTextfield.getText(),descriptionTextfield.getText());
				} else if (nameTextfield.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill the name.");
				} else if (descriptionTextfield.getText().equals("") ) {
					JOptionPane.showMessageDialog(null,"Please fill the description.");
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(264, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(212, 212, 212))))
				.addGroup(layout.createSequentialGroup()
						.addGap(61, 61, 61)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(17, 17, 17))
								.addGroup(layout.createSequentialGroup()
										.addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(nameTextfield)
								.addComponent(descriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
						.addGap(0, 0, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(31, 31, 31)
						.addComponent(titleLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(87, 87, 87)
						.addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
	}// </editor-fold>//GEN-END:initComponents

	private void nextPanel(String name, String description) {
		problemPanel = new ProblemProcess3(form,name,description);
		form.create(problemPanel);
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextArea descriptionTextfield;
	private javax.swing.JLabel descriptionLabel;
	private javax.swing.JScrollPane descriptionScrollPane;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextfield;
	private javax.swing.JButton nextButton;
	private javax.swing.JLabel titleLabel;
	// End of variables declaration//GEN-END:variables
}
