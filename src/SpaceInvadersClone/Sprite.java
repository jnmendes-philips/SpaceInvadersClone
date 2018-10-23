package SpaceInvadersClone;

public class Sprite extends SpriteSheet {

    public Sprite(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        super(imagem, x, y, largura, altura, linhas, colunas);
    }

    @Override
    public void animacao(double periodo, double tempoTotal) {
        if (tempoTotal == periodo) {
            if (this.frame < this.sprites.length - 1) {
                this.frame++;
            } else {
                this.frame = 0;
            }
        }
    }
}
