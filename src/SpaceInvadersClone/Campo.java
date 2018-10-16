package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JPanel;

public class Campo extends JPanel {
    
    Inimigo inimigo1;
    Inimigo inimigo2;
    Inimigo inimigo3;
    Sprite barreira1;
    Sprite barreira2;
    Sprite barreira3;
    Sprite barreira4;
    Jogador jogador;
    Sprite linha;
    
    public Campo(Jogo tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), tela.getHeight() - 150);
        this.setLocation(0, 100);
        this.setBackground(Color.BLACK);
        init();
        colocarComponentes();
    }

    private void init() {
        inimigo1 = new Inimigo("inimigo1", 100, 100, 50, 29, 1, 2);
        inimigo2 = new Inimigo("inimigo2", 100, 200, 68, 29, 1, 2);
        inimigo3 = new Inimigo("inimigo3", 100, 300, 72, 29, 1, 2);
        barreira1 = new Barreira("barreira", 100, 500, 66, 56, 1, 1);
        barreira2 = new Barreira("barreira", 100+65+60, 500, 66, 56, 1, 1);
        barreira3 = new Barreira("barreira", this.getWidth()-100-65-60-60, 500, 66, 56, 1, 1);
        barreira4 = new Barreira("barreira", this.getWidth()-100-60, 500, 66, 56, 1, 1);
        jogador = new Jogador("jogador", 55, 580, 40, 29, 1, 1);
        jogador.setNumVidas(3);
        linha = new Sprite("linha", 0, this.getHeight()-6,  634, 6, 1, 1);
    }
    
    private void colocarComponentes() {
        this.add(inimigo1);
        this.add(inimigo2);
        this.add(inimigo3);
        this.add(barreira1);
        this.add(barreira2);
        this.add(barreira3);
        this.add(barreira4);
        this.add(jogador);
        this.add(linha);
    }

    public Jogador getJogador() {
        return jogador;
    }
    
}
