package SpaceInvadersClone;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class SpriteSheet extends JLabel {

    String imagem;
    int largura;
    int altura;
    int linhas;
    int colunas;
    int x;
    int y;

    BufferedImage spriteSheet;
    BufferedImage[] sprites;

    public SpriteSheet(String imagem, int x, int y, int largura, int altura, int linhas, int colunas) {
        this.imagem = imagem;
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.setSize(largura, altura);
        this.setLocation(this.x, this.y);
        this.linhas = linhas;
        this.colunas = colunas;
        init();
        criarSprites();
    }

    private void init() {
        try {
            spriteSheet = ImageIO.read(new File(getClass().getResource("/Resources/" + imagem + ".png").getFile()));
        } catch (IOException ex) {
            Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        sprites = new BufferedImage[linhas * colunas];
    }

    private void criarSprites() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                sprites[(i * colunas) + j] = spriteSheet.getSubimage(
                        j * (largura / colunas),
                        i * (altura / linhas),
                        largura / colunas,
                        altura / linhas
                );
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setLocation(x, y);
        g.drawImage(sprites[0], 0, 0, this);
    }

}
