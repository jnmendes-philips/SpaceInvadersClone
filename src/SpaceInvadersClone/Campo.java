package SpaceInvadersClone;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Campo extends JPanel {

    ArrayList<Inimigo> inimigos = new ArrayList<>();
    ArrayList<Tiro> tiros = new ArrayList<>();
    Inimigo[] fileira1 = new Inimigo[11];
    Inimigo[] fileira2 = new Inimigo[11];
    Inimigo[] fileira3 = new Inimigo[11];
    Inimigo[] fileira4 = new Inimigo[11];
    Inimigo[] fileira5 = new Inimigo[11];
    Barreira[] barreiras = new Barreira[4];
    Jogador jogador;
    Sprite linha;

    public Campo(Jogo tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), tela.getHeight() - 150);
        this.setLocation(0, 100);
        this.setBackground(Color.BLACK);
        init();
        colocarComponentes();
    }

    private void init() {
        for (int i = 1; i < 12; i++) {
            inimigos.add(new Inimigo("inimigo1", 50 * i, 100, 50, 29, 1, 2));
            inimigos.add(new Inimigo("inimigo2", 50 * i, 150, 68, 29, 1, 2));
            inimigos.add(new Inimigo("inimigo2", 50 * i, 200, 68, 29, 1, 2));
            inimigos.add(new Inimigo("inimigo3", 50 * i, 250, 72, 29, 1, 2));
            inimigos.add(new Inimigo("inimigo3", 50 * i, 300, 72, 29, 1, 2));
        }
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        int cont4 = 0;
        int cont5 = 0;
        for (int i = 0; i < 55; i++) {    
            if (inimigos.get(i).y == 300) {
                fileira1[cont1] = inimigos.get(i);
                cont1++;
            }
            if (inimigos.get(i).y == 250) {
                fileira2[cont2] = inimigos.get(i);
                cont2++;
            }
            if (inimigos.get(i).y == 200) {
                fileira3[cont3] = inimigos.get(i);
                cont3++;
            }
            if (inimigos.get(i).y == 150) {
                fileira4[cont4] = inimigos.get(i);
                cont4++;
            }
            if (inimigos.get(i).y == 100) {
                fileira5[cont5] = inimigos.get(i);
                cont5++;
            }
        }
        barreiras[0] = new Barreira("barreira", 100, 500, 66, 56, 1, 1);
        barreiras[1] = new Barreira("barreira", 100 + 65 + 60, 500, 66, 56, 1, 1);
        barreiras[2] = new Barreira("barreira", this.getWidth() - 100 - 65 - 60 - 60, 500, 66, 56, 1, 1);
        barreiras[3] = new Barreira("barreira", this.getWidth() - 100 - 60, 500, 66, 56, 1, 1);
        jogador = new Jogador("jogador", 55, 580, 40, 29, 1, 1);
        jogador.setNumVidas(3);
        linha = new Sprite("linha", 0, this.getHeight() - 6, 634, 6, 1, 1);
    }

    private void colocarComponentes() {
        for (Inimigo inimigo : inimigos) {
            this.add(inimigo);
        }
        for (Barreira barreira : barreiras) {
            this.add(barreira);
        }
        this.add(jogador);
        this.add(linha);
    }

    public Jogador getJogador() {
        return jogador;
    }

}
