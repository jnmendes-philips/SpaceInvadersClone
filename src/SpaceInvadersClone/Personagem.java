package SpaceInvadersClone;

public abstract class Personagem extends Sprite {

    public Personagem(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        super(imagem, x, y, largura, altura, linhas, colunas);
    }
    
    public abstract void atirar();    
    public abstract void mover();
    public abstract void animacao();
    
}
