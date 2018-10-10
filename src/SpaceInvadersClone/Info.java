package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Info extends JPanel {

    public Info(JFrame tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), 50);
        this.setLocation(0, tela.getHeight()-this.getHeight());
        this.setBackground(Color.BLACK);
        colocarComponentes();
    }

    private void colocarComponentes() {
        this.add(new LabelBit(this, "3", 28, 0, 0));
    }
}
