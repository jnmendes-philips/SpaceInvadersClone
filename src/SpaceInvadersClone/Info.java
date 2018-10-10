package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Info extends JPanel {

    LabelBit qtdVidas;
    LabelBit creditos;
    LabelBit qtdCreditos;
    
    public Info(JFrame tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), 50);
        this.setLocation(0, tela.getHeight() - this.getHeight());
        this.setBackground(Color.BLACK);
        init();
        colocarComponentes();
    }
    
    private void init() {
        qtdVidas = new LabelBit(this, "3", 28, (this.getWidth()-80), 0);
        creditos = new LabelBit(this, "CREDIT", 28, -(this.getWidth()-80)+231, 0);
        qtdCreditos = new LabelBit(this, "00", 28, -(this.getWidth()-80)+42, 0);
        qtdCreditos.atualizarLocal(-(this.getWidth()-80)+qtdCreditos.getWidth(), 0);
    }

    private void colocarComponentes() {
        // irá ser adicionado no lugar do 3 o numero de vidas
        this.add(qtdVidas);
        /* 
        ao lado do numero de vidas deve ficar o numero de naves que 
        deve ser o equivalente ao numero de vidas -1
        comentarios de exemplo abaixo caso sejam 3 vidas
         */
        //this.add(new Sprite(param));
        //this.add(new Sprite(param));
        this.add(creditos);
        // o numero 00 deve ser substituido pelo numero de creditos
        this.add(qtdCreditos);
    }
}
