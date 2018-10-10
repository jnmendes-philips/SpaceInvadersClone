package SpaceInvadersClone;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelBit extends JLabel {
    
    public LabelBit(JPanel panel, String texto, float tam, int hor, int ver) {
        Font fonte = new FonteBit().fonte(tam);
        this.setText(texto);
        this.setFont(fonte);
        this.setSize(this.getFontMetrics(this.getFont()).stringWidth(texto), this.getFontMetrics(this.getFont()).getHeight());
        this.setBounds(Integer.parseInt(String.valueOf(Math.round((panel.getWidth() - hor - this.getFontMetrics(this.getFont()).stringWidth(texto)) / 2))),
                Integer.parseInt(String.valueOf(Math.round((panel.getHeight() - ver - this.getSize().height) / 2))),
                this.getFontMetrics(this.getFont()).stringWidth(texto), 
                this.getFontMetrics(this.getFont()).getHeight());
        this.setForeground(Color.WHITE);
    }
    
}
