package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JPanel;

public class Campo extends JPanel {
    
    Sprite barreira1;
    Sprite barreira2;
    Sprite barreira3;
    Sprite barreira4;
    Jogador jogador;
    Sprite linha;
    
    public Campo(Tela tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), tela.getHeight() - 150);
        this.setLocation(0, 100);
        this.setBackground(Color.BLACK);
        init();
        colocarComponentes();
    }

    private void init() {
        barreira1 = new Barreira("barreira", 100, 500, 66, 56);
        barreira2 = new Barreira("barreira", 100+65+60, 500, 66, 56);
        barreira3 = new Barreira("barreira", this.getWidth()-100-65-60-60, 500, 66, 56);
        barreira4 = new Barreira("barreira", this.getWidth()-100-60, 500, 66, 56);
        jogador = new Jogador("jogador", 55, 580, 40, 29);
        jogador.setNumVidas(5);
        linha = new Sprite("linha", 0, this.getHeight()-6,  634, 6);
    }
    
    private void colocarComponentes() {
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
