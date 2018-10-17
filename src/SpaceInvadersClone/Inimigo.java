package SpaceInvadersClone;

import java.util.Timer;
import java.util.TimerTask;

public class Inimigo extends Personagem {

    public Inimigo(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        super(imagem, x, y, largura, altura, linhas, colunas);
    }

    @Override
    public void atirar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void animacao() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Inimigo inimigo = Inimigo.this;
                if (inimigo.frame < inimigo.sprites.length - 1) {
                    inimigo.frame++;
                } else {
                    inimigo.frame = 0;
                }
            }
        }, 0, 1000L);
    }

}
