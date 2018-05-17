/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUITest;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import funcionalities.Form;
import jMetal.OptimizationProcess;
import objects.Problem;

/**
 *
 * @author Ricardo
 */
public class OptimizationProcess5 extends javax.swing.JPanel {

	private Form form;
	private OptimizationProcess optimizationProcess = new OptimizationProcess();
	private Problem problem;
	private String variableType;
	private DefaultListModel algorithmsChosenList;
	private DefaultTableModel fitnessVariables;
    /**
     * Creates new form OptimizationProcess5
     * @param fitnessVariables 
     * @param algorithmsChosenList 
     * @param variableType 
     * @param problem 
     */
    public OptimizationProcess5(Form form, Problem problem, String variableType, DefaultListModel<String> algorithmsChosenList, DefaultTableModel fitnessVariables) {
    	this.form = form;
        initComponents();
        optimizationStart(); 
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
        nextButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Optimization Status");

        optimizationProgressBar.setValue(50);

        optimizationProgressLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        optimizationProgressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optimizationProgressLabel.setText("50%");

        loggedInLabel.setText("Logged in as : @var");

        nextButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ricardo\\Desktop\\arrowRight.png")); // NOI18N
        nextButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nextButton.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(optimizationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(optimizationProgressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(optimizationProgressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optimizationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void optimizationStart() {
    	optimizationProcess.init(problem,variableType,algorithmsChosenList,fitnessVariables,optimizationProgressBar);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel loggedInLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JProgressBar optimizationProgressBar;
    private javax.swing.JLabel optimizationProgressLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
