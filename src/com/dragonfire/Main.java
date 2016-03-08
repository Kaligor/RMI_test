/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dragonfire;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Main extends javax.swing.JFrame
{
    Logic logic;
    Timer timer;
    int Player = -1;
    int Player2 = -1;

    /**
     * Creates new form Main
     */
    public Main()
    { 
        initComponents();
        logic = new Logic();
        try
        {
            Player = logic.stub.assignPlayer();
            otherPlayer();
            System.out.println(Player);
            System.out.println(Player2);
        } catch (RemoteException e)
        {
            System.out.println("Something went wrong in the Constructor");
        }
        startTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        Player2Label = new javax.swing.JLabel();
        Player1Label = new javax.swing.JLabel();
        Value = new javax.swing.JLabel();
        Increase1 = new javax.swing.JButton();
        increaseTimesPlayer1 = new javax.swing.JLabel();
        increaseTimesPlayer2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Player2Label.setText("Player: 2");

        Player1Label.setText("Player: 1");

        Value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Value.setText("0");

        Increase1.setText("Increase");
        Increase1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Increase1ActionPerformed(evt);
            }
        });

        increaseTimesPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        increaseTimesPlayer1.setText("0");

        increaseTimesPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        increaseTimesPlayer2.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Player2Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Increase1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(increaseTimesPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(increaseTimesPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Value, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(200, 200, 200)
                .addComponent(Player1Label)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player2Label)
                    .addComponent(increaseTimesPlayer2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(Value)
                .addGap(137, 137, 137)
                .addComponent(increaseTimesPlayer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Increase1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Player1Label, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Increase1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_Increase1ActionPerformed
    {//GEN-HEADEREND:event_Increase1ActionPerformed
        try
        {
            logic.stub.increaseValue(Player);
        } catch (RemoteException e)
        {
            System.out.println("Increaseing Value, did not work");
        }
    }//GEN-LAST:event_Increase1ActionPerformed

    public final void startTimer()
    {

        timer = new Timer(100, (ActionEvent e)
                -> 
                {
                    try
                    {
                        increaseTimesPlayer1.setText("" + logic.stub.getValue(Player));
                        if (logic.stub.getReady())
                        {
                            increaseTimesPlayer2.setText("" + logic.stub.getValue(Player2));
                        }
                        Value.setText("" + logic.stub.getValue(9));

                    } catch (RemoteException f)
                    {
                        System.out.println("Remote Exception in the Timer");
                    }

        });
        timer.setRepeats(true);
        timer.start();
    }

    public final void otherPlayer()
    {
        if (Player == 1)
        {
            Player2 = 2;
        } else if (Player == 2)
        {
            Player2 = 1;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Increase1;
    private javax.swing.JLabel Player1Label;
    private javax.swing.JLabel Player2Label;
    private javax.swing.JLabel Value;
    private javax.swing.JLabel increaseTimesPlayer1;
    private javax.swing.JLabel increaseTimesPlayer2;
    // End of variables declaration//GEN-END:variables
}
