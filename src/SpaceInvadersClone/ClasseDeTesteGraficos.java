package SpaceInvadersClone;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

public class ClasseDeTesteGraficos extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(0, 0, 0));
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 620, 1000, 50);
        g.setColor(new Color(0, 0, 255));
        g.fillRect(SpaceInvadersClone.player.x, SpaceInvadersClone.player.y, 50, 20);
        g.setColor(new Color(0, 255, 0));
        g.fillRect(SpaceInvadersClone.bar1.x, SpaceInvadersClone.bar1.y, 150, 120);
        g.fillRect(SpaceInvadersClone.bar2.x, SpaceInvadersClone.bar2.y, 150, 120);
        g.fillRect(SpaceInvadersClone.bar3.x, SpaceInvadersClone.bar3.y, 150, 120);
        g.setColor(new Color(255, 255, 0));
        g.setFont(getFont());
        g.drawString(Integer.toString(SpaceInvadersClone.score), 20, 100);
        g.setColor(new Color(255, 0, 0));
        for(Tiro tiro : SpaceInvadersClone.tiros){
            g.fillRect(tiro.x, tiro.y, 5, 12);
        }
        

    }

    public Font getFont() {
        String path = System.getProperty("user.dir") + File.separator + "8bitoperator.ttf";
        Font fonte = null;
        try {
            fonte = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            fonte = fonte.deriveFont(fonte.getSize() * 50F);
        } catch (FontFormatException ex) {
            System.out.println("vish, não deu de carrega a font");
        } catch (IOException ex) {
            System.out.println("cade o arquivo da fonte?");
        }
        return fonte;
    }
}
