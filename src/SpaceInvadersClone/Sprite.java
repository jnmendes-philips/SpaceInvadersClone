package SpaceInvadersClone;

import java.util.Timer;
import java.util.TimerTask;

public class Sprite extends SpriteSheet {

    public Sprite(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        super(imagem, x, y, largura, altura, linhas, colunas);
    }

    @Override
    public void animacao() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Sprite sprite = Sprite.this;
                if (sprite.frame < sprite.sprites.length - 1) {
                    sprite.frame++;
                } else {
                    sprite.frame = 0;
                }
            }
        }, 0, 1000L);
    }
    
}
