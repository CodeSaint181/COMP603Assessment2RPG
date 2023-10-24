/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assessment2rpg;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sahil
 */
public class GameStartFrame extends javax.swing.JFrame {

    /**
     * Creates new form GameStartFrame
     */
    public GameStartFrame() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        classImage = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_ClassDescription = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Warrior = new javax.swing.JRadioButton();
        Mage = new javax.swing.JRadioButton();
        Monk = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        playerName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        relicImage = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_RelicDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        FlameBlade = new javax.swing.JRadioButton();
        LightningBracer = new javax.swing.JRadioButton();
        HolyStone = new javax.swing.JRadioButton();
        confirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Creation");

        classImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Warrior.jpg"))); // NOI18N
        classImage.setText("classImage");

        jTextArea_ClassDescription.setColumns(20);
        jTextArea_ClassDescription.setRows(5);
        jScrollPane3.setViewportView(jTextArea_ClassDescription);

        jLabel2.setText("Classes");

        buttonGroup1.add(Warrior);
        Warrior.setText("Warrior");
        Warrior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WarriorActionPerformed(evt);
            }
        });

        buttonGroup1.add(Mage);
        Mage.setText("Mage");
        Mage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MageActionPerformed(evt);
            }
        });

        buttonGroup1.add(Monk);
        Monk.setText("Monk");
        Monk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Warrior)
                            .addComponent(Mage)
                            .addComponent(Monk)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(169, 169, 169)
                        .addComponent(classImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(classImage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Warrior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Mage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Monk)
                        .addGap(30, 30, 30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307))
        );

        jLabel1.setText("Welcome to the Character Selector Please enter your name!");

        playerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNameActionPerformed(evt);
            }
        });
        playerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                playerNameKeyTyped(evt);
            }
        });

        nameLabel.setText("Name:");

        jLabel4.setText("Now please select a Class and Relic");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        relicImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/flame blade.jpg"))); // NOI18N
        relicImage.setText("jLabel5");

        jTextArea_RelicDescription.setColumns(20);
        jTextArea_RelicDescription.setRows(2);
        jScrollPane4.setViewportView(jTextArea_RelicDescription);

        jLabel3.setText("Relics");

        buttonGroup2.add(FlameBlade);
        FlameBlade.setText("Flame Blade");
        FlameBlade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlameBladeActionPerformed(evt);
            }
        });

        buttonGroup2.add(LightningBracer);
        LightningBracer.setText("Lightning  Bracer");
        LightningBracer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LightningBracerActionPerformed(evt);
            }
        });

        buttonGroup2.add(HolyStone);
        HolyStone.setText("Holy Stone");
        HolyStone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HolyStoneActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm Choices");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LightningBracer)
                                    .addComponent(FlameBlade)
                                    .addComponent(HolyStone)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel3)))
                        .addGap(123, 123, 123)
                        .addComponent(relicImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(confirmButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FlameBlade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LightningBracer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HolyStone)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(relicImage, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmButton)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WarriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WarriorActionPerformed
        classImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Warrior.jpg")));
        classImage.setText("Warrior");
        charCreatorClass = "warrior";
        jTextArea_ClassDescription.setText("Ah so you are a warrior!\n"
                            + "You rely on your strong attacks and high defence to reduce damage.\n"
                            + "You can use your skills to counter attack and deliver a large number of blows\n"
                            + "And your special abilities are 'Cross Slash', 'Swift Counter', and 'Blade Dance'.\n\n"
                            + "Cross Slash - Perform a heavy blow against your enemy. Deals 10*2 Base Damage. Mana Cost: 10\n\n"
                            + "Swift Counter - Get into a counter stance and parry attacks for the rest of the turn. Deals damage taken this turn. Mana Cost: 15\n\n" 
                            + "Blade Dance - Charge up for this turn and next, and perform a deadly flurry of attacks on the third turn. Deals 8*5 Base Damage. Mana Cost: 20");
        
        
    }//GEN-LAST:event_WarriorActionPerformed

    private void MageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MageActionPerformed
        classImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Mage.jpg")));
        classImage.setText("Mage");
        charCreatorClass = "mage";
        jTextArea_ClassDescription.setText("Ah very impressive, you are a mage!\n"
                            + "You use your high mana to cast elemental spells and inflict debuffs.\n"
                            + "You can cast your Mage Armour to reduce damage.\n"
                            + "And your special abilities are 'Fire Bolts', 'Mage Armour', and 'Lightning Storm'.\n\n"
                            + "Fire Bolt - Shoot up to 5 magical flame bolts at your enemy each costing 8 mana. Deals 7 Base Damage each and inflicts 2 stack of burn.\n- [Burn] - Deal 1 damage per stack and reduce stack by 1 at end of turn. Mana Cost: 8\n\n"
                            + "Mage Armour - Summon a set of magical armour around yourself damaging foes that attack you.\nGain 4 defense this round and deal 4 damage to enemies that hit you. Mana Cost: 10\n\n" 
                            + "Lightning Storm - Charge a lightning storm for this turn and next. Deals 15 Base Damage and inflicts 4 shock each turn.\n- [Shock] - take 1 extra damage for each stack. Mana Cost: 40");
    }//GEN-LAST:event_MageActionPerformed

    private void MonkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonkActionPerformed
        classImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Monk.png")));
        classImage.setText("Monk");
        charCreatorClass = "monk";
        jTextArea_ClassDescription.setText("I see, you are a monk!\n"
                            + "You use your high agility to dodge attacks instead of block.\n"
                            + "You can use your skills to heal yourself and attack multiple times a turn.\n"
                            + "And your special abilities are 'Quivering Palm', 'Golden Soul', and 'Flurry of Blows'.\n\n"
                            + "Quivering Palm - Strike your foe and cause them to take more damage for 2 turns. Deals 8 Base Damage, ignores Defence and inflicts 3 Vulnerable.\n-[Vulnerable] - take 2x damage from attacks. Mana Cost: 15\n\n"
                            + "Golden Soul - Harness the energy in your body to heal yourself of ailments. Lose all Status Effects and heal 30 health. Mana Cost: 15\n\n" 
                            + "Flurry of Blows - Harness your inner energy to temporarily enhance your striking speed.\n Attack 3 times a turn for the next 2 turns and ignore defense. Mana Cost: 20");
    }//GEN-LAST:event_MonkActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        if (!"".equals(playerName.getText()))
        {
            if (!"".equals(charCreatorClass) && !"".equals(charCreatorRelic))
            {
                newPlayer = new RPGPlayer(playerName.getText(), charCreatorClass, charCreatorRelic);
                System.out.println("Created new player with Name: "+playerName.getText()+" Class "+ charCreatorClass+" relic: "+charCreatorRelic);
            }
            else
            {
                JFrame frame = new JFrame("Error Box");
                JOptionPane.showMessageDialog(frame, "Select a Class and Relic.");
            }
        }
        else
        {
            JFrame frame = new JFrame("Error Box");
            JOptionPane.showMessageDialog(frame, "Enter a valid player name.");
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void playerNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playerNameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_playerNameKeyTyped

    private void LightningBracerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LightningBracerActionPerformed
        relicImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Lightning Bracer.jpg")));
        relicImage.setText("LightningBracer");
        charCreatorRelic = "lightning bracer";
        jTextArea_RelicDescription.setText("Lightning Bracer - Deal 2-5 damage to enemies when they attack you with a 50% of shock.\n"
                        + "[Shock] - take 1 extra damage for each stack and reduce stack by 1 at end of turn.");
    }//GEN-LAST:event_LightningBracerActionPerformed

    private void FlameBladeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlameBladeActionPerformed
        relicImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Flame Blade.jpg")));
        relicImage.setText("FlameBlade");
        charCreatorRelic = "flame blade";
        jTextArea_RelicDescription.setText("Flame Blade - Inflict 2 burn stacks on every hit. \n"
                        + "[Burn] - Deal 1 damage per stack and reduce stack by 1 at end of turn.");
    }//GEN-LAST:event_FlameBladeActionPerformed

    private void HolyStoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HolyStoneActionPerformed
        relicImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assessment2rpg/Images/Holy Stone.jpg")));
        relicImage.setText("HolyStone");
        charCreatorRelic = "holy stone";
        jTextArea_RelicDescription.setText("Holy Stone - Heal half the damage you deal at end of turn.");
    }//GEN-LAST:event_HolyStoneActionPerformed

    private void playerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerNameActionPerformed

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
            java.util.logging.Logger.getLogger(GameStartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameStartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameStartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameStartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameStartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton FlameBlade;
    private javax.swing.JRadioButton HolyStone;
    private javax.swing.JRadioButton LightningBracer;
    private javax.swing.JRadioButton Mage;
    private javax.swing.JRadioButton Monk;
    private javax.swing.JRadioButton Warrior;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel classImage;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea_ClassDescription;
    private javax.swing.JTextArea jTextArea_RelicDescription;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField playerName;
    private javax.swing.JLabel relicImage;
    // End of variables declaration//GEN-END:variables
    public String charCreatorClass="";
    public String charCreatorRelic="";
    public RPGPlayer newPlayer = null;

}
