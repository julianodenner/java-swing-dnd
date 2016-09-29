package com.jdenner;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Juliano
 */
public class Campo extends javax.swing.JFrame {

    public Campo() {
        initComponents();
        adicionarJogadores();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        campo = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon(getClass().getResource("/com/jdenner/img/background1.jpg")).getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        campo.setBackground(new java.awt.Color(255, 255, 255));
        campo.setOpaque(false);
        campo.setLayout(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(campo, gridBagConstraints);

        setBounds(0, 0, 636, 405);
    }// </editor-fold>//GEN-END:initComponents

    /*
    * Método que cria os jogadores (JLabel) dentro do campo (JPanel)
     */
    private void adicionarJogadores() {

        for (int i = 0; i < 11; i++) {
            Jogador jogador = new Jogador(i);
            campo.add(jogador);
            jogador.setBounds(35 * i, 50 * ((i + 1) % 2), 100, 100);
        }
    }

    /*
    * Método que inicia a aplicação
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Campo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel campo;
    // End of variables declaration//GEN-END:variables

}
