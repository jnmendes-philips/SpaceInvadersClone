package SpaceInvadersClone;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;


public class Tela extends JFrame {

    public Tela() {
        this.setSize(630, 800);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height)/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.moveFrame();
        this.setVisible(true);
        colocarComponentes();
    }

    private void colocarComponentes() {
        this.add(new Placar(this));
        this.add(new Campo(this));
    }
    
    // Possibilita mover o frame apenas clicando e arrastando com o curso do mouse
    private void moveFrame() {
        MouseAdapter ma = new MouseAdapter() {
            int mousePressedX;
            int mousePressedY;
            
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressedX = e.getXOnScreen();
                mousePressedY = e.getYOnScreen();
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getLocationOnScreen().x + e.getXOnScreen() - mousePressedX,
                        getLocationOnScreen().y + e.getYOnScreen() - mousePressedY);
                mousePressedX = e.getXOnScreen();
                mousePressedY = e.getYOnScreen();
            }
        };
        this.addMouseListener(ma);
        this.addMouseMotionListener(ma);
    }
    
}
