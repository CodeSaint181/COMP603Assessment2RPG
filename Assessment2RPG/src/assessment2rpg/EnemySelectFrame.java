/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assessment2rpg;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sahil
 */
public class EnemySelectFrame extends javax.swing.JFrame {

    /**
     * Creates new form EnemySelectFrame
     * @param player
     */
    public EnemySelectFrame(RPGPlayer player) {
        initComponents();
        createdPlayer = player;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Slime = new javax.swing.JRadioButton();
        Ghost = new javax.swing.JRadioButton();
        Skeleton = new javax.swing.JRadioButton();
        enemyImage = new javax.swing.JLabel();
        jButton_EnemyConfirm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_EnemyDescription = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(0, 0));

        buttonGroup1.add(Slime);
        Slime.setText("Slime");
        Slime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SlimeActionPerformed(evt);
            }
        });

        buttonGroup1.add(Ghost);
        Ghost.setText("Ghost");
        Ghost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GhostActionPerformed(evt);
            }
        });

        buttonGroup1.add(Skeleton);
        Skeleton.setText("Skeleton");
        Skeleton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkeletonActionPerformed(evt);
            }
        });

        enemyImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/placeholder.jpg"))); // NOI18N
        enemyImage.setText("jLabel2");

        jButton_EnemyConfirm.setText("Confirm");
        jButton_EnemyConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnemyConfirmActionPerformed(evt);
            }
        });

        jTextArea_EnemyDescription.setColumns(20);
        jTextArea_EnemyDescription.setLineWrap(true);
        jTextArea_EnemyDescription.setRows(5);
        jScrollPane1.setViewportView(jTextArea_EnemyDescription);

        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setText("Easy");

        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Medium");

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Hard");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_EnemyConfirm)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Slime)
                            .addComponent(Skeleton)
                            .addComponent(Ghost))))
                .addGap(54, 54, 54)
                .addComponent(enemyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Slime)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ghost)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Skeleton)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45)
                        .addComponent(jButton_EnemyConfirm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(enemyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setText("Now, you must select which opponent you will face down in battle!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(249, 249, 249))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SlimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SlimeActionPerformed
        enemyImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Slime.jpg")));
        enemyImage.setText("slime");
        enemySelectorClass = "slime";
        jTextArea_EnemyDescription.setFont(f);
        jTextArea_EnemyDescription.setText("'Slime' - A very agile monster, it can flatten it's body to evade attacks and can suck up objects\nto throw at opponents. It has the ability to\nthrow acidic slime to melt through your armour.\n");
    }//GEN-LAST:event_SlimeActionPerformed

    private void GhostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GhostActionPerformed
        enemyImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Ghost.jpg")));
        enemyImage.setText("ghost");
        enemySelectorClass = "ghost";
        jTextArea_EnemyDescription.setFont(f);
        jTextArea_EnemyDescription.setText("'Ghost' - A spectral monster, it can occasionally phase though attacks. It's spiritual powers give\nit the ability to fire bolts of ghostly energies\nthat pierce your soul. Be careful of it's\nghost lightning.\n\nWait, since when could ghosts throw lightning?.\n");
    }//GEN-LAST:event_GhostActionPerformed

    private void SkeletonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkeletonActionPerformed
        enemyImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Skeleton.jpg")));
        enemyImage.setText("skeleton");
        enemySelectorClass = "skeleton";
        jTextArea_EnemyDescription.setFont(f);
        jTextArea_EnemyDescription.setText("'Skeleton' - A skeletal warrior, it wears armour\nand has a high health. It can throw it's own\nbones like a boomerang but it seems to hurt\nitself. It can channel the necromantic energy\npowering it to heal itself.\n\nThis skeleton seems strangely angry... be ready for a tough fight!\n");
    }//GEN-LAST:event_SkeletonActionPerformed

    private void jButton_EnemyConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnemyConfirmActionPerformed
        if (!"".equals(enemySelectorClass))
            {
                newEnemy = new RPGEnemy(enemySelectorClass);
                System.out.println("Created new enemy with Class "+ enemySelectorClass);
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new PreBattleConfirmationFrame(createdPlayer, newEnemy).setVisible(true);
                    }
                });
                this.setVisible(false);
            }
            else
            {
                JFrame frame = new JFrame("Error Box");
                JOptionPane.showMessageDialog(frame, "Select a Enemy to fight.");
            }
    }//GEN-LAST:event_jButton_EnemyConfirmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnemySelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnemySelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnemySelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnemySelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnemySelectFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Ghost;
    private javax.swing.JRadioButton Skeleton;
    private javax.swing.JRadioButton Slime;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel enemyImage;
    private javax.swing.JButton jButton_EnemyConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_EnemyDescription;
    // End of variables declaration//GEN-END:variables
    public String enemySelectorClass="";
    public RPGEnemy newEnemy = null;
    public RPGPlayer createdPlayer = null;
    Font f = new Font("Verdana", Font.PLAIN, 16);
}
