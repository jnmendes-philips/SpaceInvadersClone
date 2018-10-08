package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Campo extends JPanel {

    public Campo(JFrame tela) {
        this.setBounds(tela.getBounds());
        this.setBackground(Color.BLACK);
    }
    
}
