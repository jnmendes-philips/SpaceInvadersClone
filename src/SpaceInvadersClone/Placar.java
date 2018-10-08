package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Placar extends JPanel {

    public Placar(JFrame tela) {
        this.setSize(tela.getWidth(), 100);
        this.setLocation(0, 0);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setVisible(true);
        colocarComponentes();
    }

    private void colocarComponentes() {
        this.add(new LabelBit(this, "score", 50, 0, 0));
    }
    
}
