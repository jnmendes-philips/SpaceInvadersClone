package SpaceInvadersClone;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

public class Barreira extends JLabel {

    public Barreira(int x, int y) {
        this.setSize(60, 50);
        this.setLocation(x, y);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    
}
