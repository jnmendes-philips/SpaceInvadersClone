package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Campo extends JPanel {

    public Campo(JFrame tela) {
        this.setSize(tela.getWidth(), tela.getHeight() - 100);
        this.setLocation(0, 50);
        this.setBackground(Color.CYAN);
        colocarComponentes();
    }

    private void colocarComponentes() {
        //this.add(new LabelBit("score", 100));
    }
    
}
