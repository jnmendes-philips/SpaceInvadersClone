package SpaceInvadersClone;

public class Inimigo extends Personagem {
    
    public Inimigo(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        super(imagem, x, y, largura, altura, linhas, colunas);
    }

    @Override
    public Tiro atirar() {
        
        return (new Tiro("tiro", (this.x + (largura /2)), this.y, 10 , 10, 1, 1, false));
    }

    @Override
    public void mover() {
    }

}