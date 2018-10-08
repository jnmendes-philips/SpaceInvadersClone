package SpaceInvadersClone;

import java.awt.Toolkit;
import javax.swing.JFrame;


public class Tela extends JFrame {

    public Tela() {
        this.setSize(630, 800);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height)/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        colocarComponentes();
    }

    private void colocarComponentes() {
        this.add(new Campo(this));
    }
    
}
