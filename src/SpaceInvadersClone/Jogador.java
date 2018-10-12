package SpaceInvadersClone;

public class Jogador extends Personagem {

    int numVidas;
    
    public Jogador(String imagem, int x, int y, int largura, int altura) {
        super(imagem, x, y, largura, altura);
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
