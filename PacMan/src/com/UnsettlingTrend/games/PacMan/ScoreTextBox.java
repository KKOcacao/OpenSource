package com.UnsettlingTrend.games.PacMan;
/*
 
 *** ADD THIS CODE TO LAUNCH SCORE TEXT BOX ***
 java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ScoreTextBox(9123124).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
 * 
 * add string length check
 * on submit botton hit close window
 */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

public class ScoreTextBox extends javax.swing.JFrame {

    /** Creates new form ScoreTextBox */
    private Scores scores = new Scores();
    private Integer newPlayerScore;
    
    public ScoreTextBox(Integer score, PCPanel panel) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setLocation(panel.getLocationOnScreen().x + 200 ,panel.getLocationOnScreen().y+ 200);
        initComponents();
        newPlayerScore = new Integer(score);
        scoreLabel.setText(newPlayerScore.toString());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        submitScorePanel = new javax.swing.JPanel();
        nameTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        newHighScoreLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTextField.setText("Enter Name");
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    submitButtonActionPerformed(evt);
                } catch (BadLocationException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        newHighScoreLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        newHighScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newHighScoreLabel.setText("New High Score!");

        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("jLabel2");

        javax.swing.GroupLayout submitScorePanelLayout = new javax.swing.GroupLayout(submitScorePanel);
        submitScorePanel.setLayout(submitScorePanelLayout);
        submitScorePanelLayout.setHorizontalGroup(
            submitScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(submitScorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(submitScorePanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(submitScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, submitScorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newHighScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        submitScorePanelLayout.setVerticalGroup(
            submitScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(submitScorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newHighScoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scoreLabel)
                .addGap(11, 11, 11)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(submitScorePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(submitScorePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) throws BadLocationException {//GEN-FIRST:event_submitButtonActionPerformed
        String name = new String();
        try {
            name = nameTextField.getText();
            
            if(name.length() <= 30)
                name = name.substring(0, name.length());
            else
                name = name.substring(0,30);
            
           scores.SubmitScore(name, newPlayerScore);//GEN-LAST:event_submitButtonActionPerformed
            this.setVisible(false);
            this.dispose();
            //Panel.setPanelHighScores();     
        } catch (SQLException ex) {
            Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
        }
}

private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_nameTextFieldActionPerformed

    /**
    * @param args the command line arguments
    */
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ScoreTextBox(9123124).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ScoreTextBox.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel newHighScoreLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JPanel submitScorePanel;
    // End of variables declaration//GEN-END:variables

}