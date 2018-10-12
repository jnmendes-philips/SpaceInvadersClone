package SpaceInvadersClone;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Campo extends JPanel {

    JLabel barreira1;
    JLabel barreira2;
    JLabel barreira3;
    JLabel barreira4;
    
    
    public Campo(JFrame tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), tela.getHeight() - 150);
        this.setLocation(0, 100);
        this.setBackground(Color.BLACK);
        init();
        colocarComponentes();
    }

    private void init() {
        barreira1 = new Barreira(100, 500);
        barreira2 = new Barreira(100+65+60, 500);
        barreira3 = new Barreira(this.getWidth()-100-65-60-60, 500);
        barreira4 = new Barreira(this.getWidth()-100-60, 500);
    }
    
    private void colocarComponentes() {
        this.add(barreira1);
        this.add(barreira2);
        this.add(barreira3);
        this.add(barreira4);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, this.getHeight() - 3, this.getWidth(), 3);
    }
}
