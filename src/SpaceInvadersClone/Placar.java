package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JPanel;

public class Placar extends JPanel {

    LabelBit pontuacaoJogador1;
    LabelBit pontuacaoMaior;
    LabelBit pontuacaoJogador2;
    LabelBit pontosJogador1;
    LabelBit pontosMaior;
    LabelBit pontosJogador2;
    
    public Placar(Tela tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), 100);
        this.setLocation(0, 0);
        this.setBackground(Color.BLACK);
        init();
        colocarComponentes();
    }

    private void init() {
        pontuacaoJogador1 = new LabelBit(this, "SCORE<1>", 28, (this.getWidth()-80)-157, 70);
        pontuacaoMaior = new LabelBit(this, "HI-SCORE", 28, 0, 70);
        pontuacaoJogador2 = new LabelBit(this, "SCORE<2>", 28, -(this.getWidth()-80)+162, 70);
        // trocar o "0000" pelos pontos dos jogadores mesmo
        // criar um método atualizarPontos na classe labelbit mais tarde
        // os métodos para atualizar os pontos não ficarão aqui, terão que ficar dentro do gameloop
        // lá também terão que ficar os métodos de atualizar o local
        pontosJogador1 = new LabelBit(this, "0000", 28, (this.getWidth()-80)-84-60, -10);
        pontosJogador1.atualizarLocal((this.getWidth()-80)-pontuacaoJogador1.getWidth(), -10);
        pontosMaior = new LabelBit(this, "0000", 28, 0, -10);
        pontosJogador2 = new LabelBit(this, "0000", 28, -(this.getWidth()-80)+84+60, -10);
        pontosJogador2.atualizarLocal(-(this.getWidth()-80)+pontuacaoJogador2.getWidth(), -10);
    }
    
    private void colocarComponentes() {
        // primeira linha
        this.add(pontuacaoJogador1);
        this.add(pontuacaoMaior);
        this.add(pontuacaoJogador2);
        // segunda linha
        this.add(pontosJogador1);
        this.add(pontosMaior);
        this.add(pontosJogador2);
        
    }
    
}
