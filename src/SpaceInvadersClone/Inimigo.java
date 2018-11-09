package SpaceInvadersClone;

import java.util.Random;

public class Inimigo extends Personagem {
    int stack  = new Random().nextInt(100);
    public Inimigo(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        super(imagem, x, y, largura, altura, linhas, colunas);
    }

    @Override
    public Tiro atirar() {
        
        return (new Tiro("Tiro", (this.x + (largura /2)), this.y, 5 , 16, 1, 1, false));
    }

    @Override
    public void mover() {
    }

}