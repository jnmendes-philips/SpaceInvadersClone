package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Campo extends JPanel {

    public Campo(JFrame tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), tela.getHeight() - 150);
        this.setLocation(0, 100);
        this.setBackground(Color.CYAN);
        colocarComponentes();
    }

    private void colocarComponentes() {
        
    }
    
}
