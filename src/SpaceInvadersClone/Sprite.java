package SpaceInvadersClone;

import java.awt.Graphics;
import javax.swing.JLabel;

public class Sprite extends JLabel {
    
    String imagem;
    
    public Sprite(String imagem ,int x, int y, int largura, int altura) {
        this.imagem = imagem;
        this.setSize(largura, altura);
        this.setLocation(x, y);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new SpriteSheet(getClass().getResource("/resources/"+ imagem +".png").getFile(), this.getWidth(), this.getHeight(), 1, 1).sprites[0], 0, 0, this);
    }
    
    public void animacao(int inicio, int fim, Graphics g) {
        for (int i = inicio; i < fim; i++) {
            g.drawImage(new SpriteSheet(getClass().getResource("/resources/"+ imagem +".png").getFile(), this.getWidth(), this.getHeight(), 1, 1).sprites[i], 0, 0, this);
        }
    }
    
}
