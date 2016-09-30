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

    private Jogador jogadores[] = new Jogador[11];

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
        comandos = new javax.swing.JPanel();
        lbFormacao = new javax.swing.JLabel();
        btFormacao1 = new javax.swing.JButton();
        btFormacao2 = new javax.swing.JButton();

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

        comandos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        lbFormacao.setText("Formação:");
        comandos.add(lbFormacao);

        btFormacao1.setText("4-2-4");
        btFormacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFormacao1ActionPerformed(evt);
            }
        });
        comandos.add(btFormacao1);

        btFormacao2.setText("4-3-3");
        btFormacao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFormacao2ActionPerformed(evt);
            }
        });
        comandos.add(btFormacao2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(comandos, gridBagConstraints);

        setBounds(0, 0, 636, 429);
    }// </editor-fold>//GEN-END:initComponents

    private void btFormacao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFormacao1ActionPerformed
        float x[] = {0f, 0.15f, 0.1f, 0.1f, 0.15f, 0.4f, 0.4f, 0.7f, 0.75f, 0.75f, 0.7f};
        float y[] = {0.5f, 0.2f, 0.4f, 0.6f, 0.8f, 0.4f, 0.6f, 0.2f, 0.4f, 0.6f, 0.8f};
        mover(x, y);
    }//GEN-LAST:event_btFormacao1ActionPerformed

    private void btFormacao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFormacao2ActionPerformed
        float x[] = {0f, 0.15f, 0.1f, 0.1f, 0.15f, 0.4f, 0.4f, 0.4f, 0.7f, 0.75f, 0.7f};
        float y[] = {0.5f, 0.2f, 0.4f, 0.6f, 0.8f, 0.3f, 0.5f, 0.7f, 0.3f, 0.5f, 0.7f};
        mover(x, y);
    }//GEN-LAST:event_btFormacao2ActionPerformed

    /*
    * Método que anima a troca de posições
     */
    private void mover(float x[], float y[]) {
        for (int i = 0; i < 11; i++) {
            int w = jogadores[i].getParent().getWidth();
            int h = jogadores[i].getParent().getHeight();
            int nx = Math.round(w * x[i]);
            int ny = Math.round(h * y[i]) - 28;
            new Animacao(jogadores[i], nx, ny).start();
        }
    }

    /*
    * Método que cria os jogadores (JLabel) dentro do campo (JPanel)
     */
    private void adicionarJogadores() {

        for (int i = 0; i < 11; i++) {
            Jogador jogador = new Jogador(i);
            campo.add(jogador);
            jogador.setBounds(35 * i, 50 * ((i + 1) % 2), 100, 100);
            jogadores[i] = jogador;
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
    private javax.swing.JButton btFormacao1;
    private javax.swing.JButton btFormacao2;
    private javax.swing.JPanel campo;
    private javax.swing.JPanel comandos;
    private javax.swing.JLabel lbFormacao;
    // End of variables declaration//GEN-END:variables

}
