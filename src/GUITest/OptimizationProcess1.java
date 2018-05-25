/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUITest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import funcionalities.Form;
import objects.User;

/**
 *
 * @author Ricardo
 */
public class OptimizationProcess1 extends javax.swing.JPanel {

	
	private Form form;
	private User userLoggedIn;
	private OptimizationProcess2 optimizationPanel;
    /**
     * Creates new form OptimizationProcess1
     */
    public OptimizationProcess1(Form form, User userLoggedIn) {
    	this.form = form;
    	this.userLoggedIn = userLoggedIn;
    	optimizationPanel = new OptimizationProcess2(form,userLoggedIn);
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
        title2Label = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        loggedInLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setText("Here is where you can start an Optimization. Follow the steps ");

        title2Label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title2Label.setText("and if you have any doubts please send us an email");

        nextButton.setIcon(new javax.swing.ImageIcon("img\\arrowRight.png")); // NOI18N
        nextButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nextButton.setFocusable(false);

        loggedInLabel.setText("Logged in as : " + userLoggedIn.getUsername());
        
    	nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextPanel();				
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loggedInLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(title2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextPanel() {
    	form.create(optimizationPanel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel loggedInLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel title2Label;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
