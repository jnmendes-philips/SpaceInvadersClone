package SpaceInvadersClone;

public class Jogador extends Personagem {

    int numVidas;

    public Jogador(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        super(imagem, x, y, largura, altura, linhas, colunas);
    }

    public void setNumVidas(int numVidas) {
        this.numVidas = numVidas;
    }
    
    @Override
    public void atirar() {
        
    }

    @Override
    public void mover() {
        
    }
    
}
