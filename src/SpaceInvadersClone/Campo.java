package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Campo extends JPanel {

    public Campo(JFrame tela) {
        this.setBounds(tela.getBounds());
        this.setBackground(Color.BLACK);
        colocarComponentes();
    }

    private void colocarComponentes() {
        this.add(new LabelBit("teste", 50));
    }
    
}
