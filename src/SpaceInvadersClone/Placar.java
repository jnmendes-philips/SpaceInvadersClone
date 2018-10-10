package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Placar extends JPanel {

    public Placar(JFrame tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), 100);
        this.setLocation(0, 0);
        this.setBackground(Color.BLACK);
        colocarComponentes();
    }

    private void colocarComponentes() {
        // primeira linha
        this.add(new LabelBit(this, "SCORE<1>", 28, 550-157, 70));
        this.add(new LabelBit(this, "HI-SCORE", 28, 0, 70));
        this.add(new LabelBit(this, "SCORE<2>", 28, -550+162, 70));
        // segunda linha
        /*
        Função para implementar abaixo
        */
        //this.add(new LabelBit(this, scoreJogador1, 28, 630-tamScore, 90));
        //this.add(new LabelBit(this, maiorScore, 28, 0, 90));
        //this.add(new LabelBit(this, scoreJogador2, 28, 630-tamScore, 90));
        
    }
    
}
