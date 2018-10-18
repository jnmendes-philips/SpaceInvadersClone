package SpaceInvadersClone;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Campo extends JPanel {
    
    ArrayList<Inimigo> inimigos = new ArrayList<>();
    Barreira[] barreiras = new Barreira[4];
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
        inimigos.add(new Inimigo("inimigo1", 100, 100, 50, 29, 1, 2));
        inimigos.add(new Inimigo("inimigo2", 100, 200, 68, 29, 1, 2));
        inimigos.add(new Inimigo("inimigo3", 100, 300, 72, 29, 1, 2));
        barreiras[0] = new Barreira("barreira", 100, 500, 66, 56, 1, 1);
        barreiras[1] = new Barreira("barreira", 100+65+60, 500, 66, 56, 1, 1);
        barreiras[2] = new Barreira("barreira", this.getWidth()-100-65-60-60, 500, 66, 56, 1, 1);
        barreiras[3] = new Barreira("barreira", this.getWidth()-100-60, 500, 66, 56, 1, 1);
        jogador = new Jogador("jogador", 55, 580, 40, 29, 1, 1);
        jogador.setNumVidas(3);
        linha = new Sprite("linha", 0, this.getHeight()-6,  634, 6, 1, 1);
    }
    
    private void colocarComponentes() {
        for (Inimigo inimigo : inimigos) {
            this.add(inimigo);
        }
        for (Barreira barreira : barreiras) {
            this.add(barreira);
        }
        this.add(jogador);
        this.add(linha);
    }

    public Jogador getJogador() {
        return jogador;
    }
    
}
