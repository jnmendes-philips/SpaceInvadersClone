package SpaceInvadersClone;

public class Jogador extends Personagem {

    int numVidas;
    int velX;

    public Jogador(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        super(imagem, x, y, largura, altura, linhas, colunas);
        init();
    }
    
    private void init() {
        velX = 0;
    }

    public void setNumVidas(int numVidas) {
        this.numVidas = numVidas;
    }
    
    @Override
    public void atirar() {
        
    }

    @Override
    public void mover() {
        this.x += velX;
    }

    @Override
    public void animacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
