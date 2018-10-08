package SpaceInvadersClone;

import javax.swing.JLabel;

public class LabelBit extends JLabel {

    public LabelBit(String texto, float tam) {
        this.setText(texto);
        this.setFont(new FonteBit().fonte(tam));
    }
    
}
