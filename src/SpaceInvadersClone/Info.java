package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JPanel;

public class Info extends JPanel {

    Tela tela;
    
    LabelBit qtdVidas;
    LabelBit creditos;
    LabelBit qtdCreditos;
    
    Sprite[] vidas;
    
    public Info(Tela tela) {
        this.tela = tela;
        this.setLayout(null);
        this.setSize(tela.getWidth(), 50);
        this.setLocation(0, tela.getHeight() - this.getHeight());
        this.setBackground(Color.BLACK);
        init();
        colocarComponentes();
    }
    
    private void init() {
        qtdVidas = new LabelBit(this, String.valueOf(tela.campo.jogador.numVidas), 28, (this.getWidth()-80), 25);
        creditos = new LabelBit(this, "CREDIT", 28, -(this.getWidth()-80)+231, 25);
        qtdCreditos = new LabelBit(this, "00", 28, -(this.getWidth()-80)+42, 25);
        qtdCreditos.atualizarLocal(-(this.getWidth()-80)+qtdCreditos.getWidth(), 25);
        vidas = new Sprite[tela.campo.jogador.numVidas-1];
        vidas[0] = new Sprite("jogador", 74, this.getHeight()-29-23, 40, 29, 1, 1);
        for (int i = 1; i < vidas.length; i++) {
            vidas[i] = new Sprite("jogador", vidas[i-1].getX()+(i+50), this.getHeight()-29-23, 40, 29, 1, 1);
        }
    }

    private void colocarComponentes() {
        this.add(qtdVidas);
        /* 
        ao lado do numero de vidas deve ficar o numero de naves que 
        deve ser o equivalente ao numero de vidas -1
        comentarios de exemplo abaixo caso sejam 3 vidas
         */
        //this.add(new Sprite(param));
        //this.add(new Sprite(param));
        for (int i = 0; i < vidas.length; i++) {
            this.add(vidas[i]);
        }
        this.add(creditos);
        // o numero 00 deve ser substituido pelo numero de creditos
        this.add(qtdCreditos);
    }
}
