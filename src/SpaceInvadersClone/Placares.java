/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvadersClone;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class Placares extends JPanel{
    
    int score = 0;
    LabelBit pontuacaoJogador1;
    LabelBit pontuacaoMaior;
    LabelBit pontuacaoJogador2;
    LabelBit pontosJogador1;
    LabelBit pontosMaior;
    LabelBit pontosJogador2;
    
    public Placares(Jogo tela) {
        this.setLayout(null);
        this.setSize(tela.getWidth(), 100);
        this.setLocation(0, 0);
        this.setBackground(Color.BLACK);
        init();
        colocarComponentes();
    }
    
    
    private void init() {
        
    }
    
    private void colocarComponentes() {
        
        
    }
}
