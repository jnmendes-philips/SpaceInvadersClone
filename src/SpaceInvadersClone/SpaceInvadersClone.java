package SpaceInvadersClone;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class SpaceInvadersClone extends JFrame {

    Jogo jogo;

    final int QUADROS_POR_SEGUNDO = 60;
    final double TAXA_ATUALIZACAO = 1000 / QUADROS_POR_SEGUNDO;
    double mediaQuadros;
    double tempoInicial;
    double tempoExecucao;
    double tempoTotal = 0;

    int contFrame = 0;
    int contFrameMaximo = 60;

    public SpaceInvadersClone() {
        this.setLayout(null);
        this.setSize(635, 800);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);
        this.setUndecorated(true);
        this.moveFrame();
        init();
        colocarComponentes();
    }

    private void init() {
        jogo = new Jogo(this);
    }

    private void colocarComponentes() {
        this.add(jogo);
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

    public static void main(String[] args) {
        new SpaceInvadersClone();
    }

}
