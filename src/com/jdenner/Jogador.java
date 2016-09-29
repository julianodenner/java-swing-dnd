package com.jdenner;

import java.awt.event.MouseEvent;

/**
 *
 * @author Juliano
 */
public class Jogador extends javax.swing.JPanel {

    private int xMouseInicial;
    private int yMouseInicial;
    private int xObjeto;
    private int yObjeto;

    /**
     * Método que cria o formulário
     *
     * @param i
     */
    public Jogador(int i) {
        initComponents();

        lbTexto.setText("Jogador " + i);
        lbPosicao.setText("");

        if (i == 0) {
            lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/img/icone2.png")));
            lbTexto.setText("Goleiro");
            lbPosicao.setText("");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbImagem = new javax.swing.JLabel();
        lbTexto = new javax.swing.JLabel();
        lbPosicao = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/img/icone1.png"))); // NOI18N
        lbImagem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbImagemMouseDragged(evt);
            }
        });
        lbImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbImagemMousePressed(evt);
            }
        });
        add(lbImagem, new java.awt.GridBagConstraints());

        lbTexto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTexto.setForeground(new java.awt.Color(255, 255, 51));
        lbTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTexto.setText("Jogador");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(lbTexto, gridBagConstraints);

        lbPosicao.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        lbPosicao.setForeground(new java.awt.Color(255, 255, 51));
        lbPosicao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosicao.setText("Posição");
        lbPosicao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(lbPosicao, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lbImagemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImagemMousePressed
        inicioMovimento(evt);
    }//GEN-LAST:event_lbImagemMousePressed

    private void lbImagemMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImagemMouseDragged
        mover(evt);
    }//GEN-LAST:event_lbImagemMouseDragged

    /*
    * Método que marca a posição inicial do mouse e do jogador a ser arrastado
     */
    private void inicioMovimento(MouseEvent evt) {
        xObjeto = getX();
        yObjeto = getY();
        xMouseInicial = (int) evt.getLocationOnScreen().getX();
        yMouseInicial = (int) evt.getLocationOnScreen().getY();
    }

    /*
    * Método que altera a posição do jogador (JLabel) conforme o mouse é arrastado
     */
    private void mover(MouseEvent evt) {
        int xMouseAtual = (int) evt.getLocationOnScreen().getX();
        int yMouseAtual = (int) evt.getLocationOnScreen().getY();
        int xDiferencaMouse = xMouseAtual - xMouseInicial;
        int yDiferencaMouse = yMouseAtual - yMouseInicial;
        int xNovaPosicaoObjeto = xObjeto + xDiferencaMouse;
        int yNovaPosicaoObjeto = yObjeto + yDiferencaMouse;
        xNovaPosicaoObjeto -= xNovaPosicaoObjeto % 10;
        yNovaPosicaoObjeto -= yNovaPosicaoObjeto % 10;
        setLocation(xNovaPosicaoObjeto, yNovaPosicaoObjeto);
        setNomePosicao(evt);
    }

    /*
    * Método que define o nome da posição
     */
    private void setNomePosicao(MouseEvent evt) {
        if (lbTexto.getText().equalsIgnoreCase("goleiro")) {
            return;
        }
        String posicoes[][] = new String[6][3];
        posicoes[0][0] = "Lateral Esquerdo";
        posicoes[0][1] = "Zagueiro";
        posicoes[0][2] = "Lateral Direito";
        posicoes[1][0] = "Ala Esquerdo";
        posicoes[1][1] = "Volante";
        posicoes[1][2] = "Ala Direito";
        posicoes[2][0] = "Meio-campo-lateral Esquerdo";
        posicoes[2][1] = "Meio-campo-centro";
        posicoes[2][2] = "Meio-campo-lateral Direito";
        posicoes[3][0] = "Meia-armador Esquerdo";
        posicoes[3][1] = "Meia-ofencivo";
        posicoes[3][2] = "Meia-armador Direito";
        posicoes[4][0] = "Avanço-lateral Esquerdo";
        posicoes[4][1] = "Segundo-atacante";
        posicoes[4][2] = "Avanço-lateral Direito";
        posicoes[5][0] = "Avanço-lateral Esquerdo";
        posicoes[5][1] = "Centro-avante";
        posicoes[5][2] = "Avanço-lateral Direito";

        int ix = Math.round(6f * ((getX() - 34) * 1f / getParent().getWidth()));
        int iy = Math.round(3f * ((getY() - 40) * 1f / getParent().getHeight()));

        ix = (ix < 0) ? 0 : ix;
        iy = (iy < 0) ? 0 : iy;

        ix = (ix > 5) ? 5 : ix;
        iy = (iy > 2) ? 2 : iy;

        lbPosicao.setText(posicoes[ix][iy]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbPosicao;
    private javax.swing.JLabel lbTexto;
    // End of variables declaration//GEN-END:variables

}
