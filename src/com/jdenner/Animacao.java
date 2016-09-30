package com.jdenner;

/**
 *
 * @author Juliano
 */
public class Animacao extends Thread {

    private Jogador jogador;
    private int ox;
    private int oy;
    private int dx;
    private int dy;

    public Animacao(Jogador jogador, int dx, int dy) {
        this.jogador = jogador;
        this.ox = jogador.getX();
        this.oy = jogador.getY();
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void run() {
        float contador = 0;
        float progresso = 0;

        while (progresso < 1) {
            try {
                Thread.sleep(5);
                contador++;
                progresso = contador / 100;
                if (progresso > 1f) {
                    progresso = 1f;
                }
                int x = (int) ox + Math.round((dx - ox) * progresso);
                int y = (int) oy + Math.round((dy - oy) * progresso);
                jogador.setLocation(x, y);
                jogador.setNomePosicao();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            }
        }
    }
}
