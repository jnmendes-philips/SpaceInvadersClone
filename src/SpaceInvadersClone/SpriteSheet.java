package SpaceInvadersClone;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SpriteSheet {

    String image;
    int largura;
    int altura;
    int linhas;
    int colunas;

    BufferedImage spriteSheet;
    BufferedImage[] sprites;

    public SpriteSheet(String image, int largura, int altura, int linhas, int colunas) {
        this.image = image;
        this.largura = largura;
        this.altura = altura;
        this.linhas = linhas;
        this.colunas = colunas;
        init();
        criarSprites();
    }

    private void init() {
        try {
            spriteSheet = ImageIO.read(new File(this.image));
        } catch (IOException ex) {
            Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        sprites = new BufferedImage[linhas * colunas];
    }

    private void criarSprites() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                sprites[(i * colunas) + j] = spriteSheet.getSubimage(
                        j * largura,
                        i * altura,
                        largura,
                        altura
                );
            }
        }
    }

}
