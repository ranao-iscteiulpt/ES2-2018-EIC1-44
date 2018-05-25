/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUITest;

import objects.User;

/**
 *
 * @author Ricardo
 */
public class WelcomePage extends javax.swing.JPanel {

	private User userLoggedIn;
    /**
     * Creates new form WelcomePage
     */
    public WelcomePage(User userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
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

        loggedInLabel = new javax.swing.JLabel();
        welcomeMessageLabel = new javax.swing.JLabel();
        newOptimizationButton = new javax.swing.JButton();
        newEmailButton = new javax.swing.JButton();
        newProblemButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");

        loggedInLabel.setText("Logged in as : @var");

        welcomeMessageLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        welcomeMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeMessageLabel.setText("Welcome to Solutions!! ");

        newOptimizationButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newOptimizationButton.setText("New optimization");
        newOptimizationButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        newOptimizationButton.setBorderPainted(false);
        newOptimizationButton.setContentAreaFilled(false);

        newEmailButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newEmailButton.setText("New email");
        newEmailButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        newEmailButton.setBorderPainted(false);
        newEmailButton.setContentAreaFilled(false);

        newProblemButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newProblemButton.setText("New problem");
        newProblemButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        newProblemButton.setBorderPainted(false);
        newProblemButton.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newEmailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newOptimizationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newProblemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(291, 291, 291))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(welcomeMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(welcomeMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(newProblemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(newOptimizationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(newEmailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel loggedInLabel;
    private javax.swing.JButton newEmailButton;
    private javax.swing.JButton newOptimizationButton;
    private javax.swing.JButton newProblemButton;
    private javax.swing.JLabel welcomeMessageLabel;
    // End of variables declaration//GEN-END:variables
}
