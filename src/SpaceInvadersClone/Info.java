package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Info extends JPanel {

    public Info(JFrame tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), 50);
        this.setLocation(0, tela.getHeight() - this.getHeight());
        this.setBackground(Color.BLACK);
        colocarComponentes();
    }

    private void colocarComponentes() {
        // irá ser adicionado no lugar do 3 o numero de vidas
        this.add(new LabelBit(this, "3", 28, 550, 0));
        /* 
        ao lado do numero de vidas deve ficar o numero de naves que 
        deve ser o equivalente ao numero de vidas -1
        comentarios de exemplo abaixo caso sejam 3 vidas
         */
        //this.add(new Sprite(param));
        //this.add(new Sprite(param));
        this.add(new LabelBit(this, "CREDIT", 28, -550+231, 0));
        // o numero 00 deve ser substituido pelo numero de creditos
        this.add(new LabelBit(this, "00", 28, -550+42, 0));
    }
}
