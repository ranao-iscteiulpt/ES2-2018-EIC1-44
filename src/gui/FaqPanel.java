/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Claudio
 */
public class FaqPanel extends javax.swing.JPanel {

    /**
     * Creates new form FaqPanel
     */
    public FaqPanel() {
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

        faqTitleLabel = new javax.swing.JLabel();
        faqQ1Label = new javax.swing.JLabel();
        faqA1Label = new javax.swing.JLabel();
        faqQ2Label = new javax.swing.JLabel();
        faqA2Label = new javax.swing.JLabel();
        faqQ3Label = new javax.swing.JLabel();
        faqA3Label = new javax.swing.JLabel();
        faqQ4Label = new javax.swing.JLabel();
        faqA4Label = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        faqTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        faqTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        faqTitleLabel.setText("F.A.Q.");
        faqTitleLabel.setToolTipText("");

        faqQ1Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        faqQ1Label.setText("Q: How do you create Problems?");
        faqQ1Label.setToolTipText("");

        faqA1Label.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        faqA1Label.setText("A: On the menu you have to follow this path: Actions -> New Problem");

        faqQ2Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        faqQ2Label.setText("Q: Do i receive updates on the state of the optimization?");

        faqA2Label.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        faqA2Label.setText("A: Yes , the administrator will send you emails with analysis of the optimization");

        faqQ3Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        faqQ3Label.setText("Q: Can I be in the optimization process with more than one problem?");

        faqA3Label.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        faqA3Label.setText("A:Yes , you can have various optimizations being done at the same time");

        faqQ4Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        faqQ4Label.setText("Q: What is a JAR file ?");

        faqA4Label.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        faqA4Label.setText("A: A java file that contains java code and can be executed");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(faqQ1Label)
                            .addComponent(faqQ2Label)
                            .addComponent(faqA2Label)
                            .addComponent(faqQ3Label)
                            .addComponent(faqA3Label)
                            .addComponent(faqQ4Label)
                            .addComponent(faqA4Label)
                            .addComponent(faqA1Label)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(faqTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(faqTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(faqQ1Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(faqA1Label)
                .addGap(18, 18, 18)
                .addComponent(faqQ2Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(faqA2Label)
                .addGap(18, 18, 18)
                .addComponent(faqQ3Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(faqA3Label)
                .addGap(18, 18, 18)
                .addComponent(faqQ4Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(faqA4Label)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel faqA1Label;
    private javax.swing.JLabel faqA2Label;
    private javax.swing.JLabel faqA3Label;
    private javax.swing.JLabel faqA4Label;
    private javax.swing.JLabel faqQ1Label;
    private javax.swing.JLabel faqQ2Label;
    private javax.swing.JLabel faqQ3Label;
    private javax.swing.JLabel faqQ4Label;
    private javax.swing.JLabel faqTitleLabel;
    // End of variables declaration//GEN-END:variables
}
