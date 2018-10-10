package SpaceInvadersClone;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JFrame {

    JPanel placar;
    JPanel campo;
    JPanel info;
    
    public Tela() {
        this.setLayout(null);
        this.setSize(630, 800);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);
        this.setUndecorated(true);
        this.moveFrame();
        init();
        gameLoop();
    }
    
    private void init() {
        placar = new Placar(this);
        campo = new Campo(this);
        info = new Info(this);
    }
    
    private void gameLoop() {
        while (true) {
            update();
            render();
        }
    }
    
    private void update() {
        handleEvents();
    }
    
    private void render() {
        this.add(placar);
        this.add(campo);
        this.add(info);
        this.setVisible(true);
    }
    
    private void handleEvents() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
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
