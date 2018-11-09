/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvadersClone;

/**
 *
 * @author aluno
 */
public class Tiro extends Sprite{
    boolean type;
    public Tiro(String imagem, int x, int y, int largura, int altura, int linhas, int colunas, boolean type) {
        super(imagem, x, y, largura, altura, linhas, colunas);
        this.type = type;
    }
    
}