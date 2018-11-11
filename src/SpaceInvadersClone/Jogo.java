package SpaceInvadersClone;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Jogo extends JPanel implements Runnable {

    SpaceInvadersClone tela;

    Placar placar;
    Campo campo;
    Info info;

    final int QUADROS_POR_SEGUNDO = 60;
    final double TAXA_ATUALIZACAO = 1000 / QUADROS_POR_SEGUNDO;
    double mediaQuadros;
    double tempoInicial;
    double tempoExecucao;
    double tempoTotal;
    double contTempo;
    int stack = 60;
    int contFrame;
    int contFrameMaximo;

    boolean running;

    int contFileira1 = 0;
    int contFileira2 = 0;
    int contFileira3 = 0;
    int contFileira4 = 0;
    int contFileira5 = 0;

    public Jogo(SpaceInvadersClone tela) {

        this.tela = tela;
        this.setLayout(null);
        this.setSize(tela.getSize());
        this.setLocation(0, 0);
        init();
        tela.setVisible(true);
        colocarComponentes();
        handleEvents();
    }

    private void init() {
        placar = new Placar(this);
        campo = new Campo(this);
        info = new Info(this);
        contTempo = 0;
        contFrame = 0;
        contFrameMaximo = 60;
        tempoTotal = 0;
        running = true;

    }

    private void colocarComponentes() {
        this.add(placar);
        this.add(campo);
        this.add(info);

    }

    private void update() {
        campo.jogador.mover();
        animacoes(10);
        colisoes();
    }

    private void colisoes() {

        //colisão player
        if (campo.jogador.x <= 0) {
            campo.jogador.x = 1;
        } else if (campo.jogador.x >= 595) {
            campo.jogador.x = 594;
        }
        //colisão tiros
        ArrayList<Tiro> tiros = new ArrayList<>();
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        for (Inimigo ini : campo.inimigos) {
            for (Tiro tiro : campo.tiros) {
                if (tiro.type) {
                    //colisão da bala do player aqui
                    if (tiro.y < 0) {
                        tiros.add(tiro);
                    }

                    if (ini.imagem.equals("inimigo1")) {
                        if ((((tiro.x + (tiro.largura / 2) >= ini.x) && (tiro.x + (tiro.largura / 2) < ini.x + 25))) && (tiro.y <= ini.y)) {
                            tiros.add(tiro);
                            inimigos.add(ini);
                            break;
                        }
                    } else if (ini.imagem.equals("inimigo2")) {
                        if ((((tiro.x + (tiro.largura / 2) >= ini.x) && (tiro.x + (tiro.largura / 2) < ini.x + 34))) && (tiro.y <= ini.y)) {
                            tiros.add(tiro);
                            inimigos.add(ini);
                            break;
                        }
                    } else if (ini.imagem.equals("inimigo3")) {
                        if ((((tiro.x + (tiro.largura / 2) >= ini.x) && (tiro.x + (tiro.largura / 2) < ini.x + 36))) && (tiro.y <= ini.y)) {
                            tiros.add(tiro);
                            inimigos.add(ini);
                            break;
                        }
                    }

                } else {
                    //colisão da bala do inimigo aqui
                }
            }
        }

        for (Tiro tiro : tiros) {
            campo.tiros.remove(tiro);
            campo.remove(tiro);

        }

        for (Inimigo inimigo : inimigos) {
            campo.inimigos.remove(inimigo);
            campo.remove(inimigo);
            if (inimigo.imagem == "inimigo1") {
                addPonto(30);
            } else if (inimigo.imagem == "inimigo2") {
                addPonto(20);
            } else {
                addPonto(10);
            }
        }

    }

    public void addPonto(int q) {
        placar.score += q;
        String score2 = Integer.toString(placar.score);
        while (score2.length() < 4) {
            score2 = "0" + score2;
        }
        placar.pontosJogador1.setText(score2);
    }

    private void movimentoInimigos(int velX, Inimigo inimigo, int periodo) {
        if (contTempo == frequencia(periodo)) {
            inimigo.x += velX;
        }
    }

    private void animacoes(int periodo) {
        //System.out.println(tempoTotal);
        if (contTempo == frequencia(periodo)) {
            if (contFileira1 == campo.fileira1.length) {
                contFileira1 = 0;
            }
            if (contFileira2 == campo.fileira1.length) {
                contFileira2 = 0;
            }
            if (contFileira3 == campo.fileira1.length) {
                contFileira3 = 0;
            }
            if (contFileira4 == campo.fileira1.length) {
                contFileira4 = 0;
            }
            if (contFileira5 == campo.fileira1.length) {
                contFileira5 = 0;
            }
            Inimigo inimigoFileira1 = campo.fileira1[contFileira1];
            Inimigo inimigoFileira2 = campo.fileira2[contFileira2];
            Inimigo inimigoFileira3 = campo.fileira3[contFileira3];
            Inimigo inimigoFileira4 = campo.fileira4[contFileira4];
            Inimigo inimigoFileira5 = campo.fileira5[contFileira5];
            /*
                é possível alterar a frequencia em que as animações 
                trocam de frame apenas alterando o parametro frequencia
             */

            if (contFileira1 >= 0 && contFileira2 == 0 && contFileira3 == 0 && contFileira4 == 0 && contFileira5 == 0) {
                frequenciaTrocaFrame(periodo, inimigoFileira1);
                movimentoInimigos(7, inimigoFileira1, periodo);
                ++contFileira1;
            }
            if (contFileira1 == 11 || contFileira2 != 0) {
                frequenciaTrocaFrame(periodo, inimigoFileira2);
                movimentoInimigos(7, inimigoFileira2, periodo);
                ++contFileira2;
            }
            if (contFileira2 == 11 || contFileira3 != 0) {
                frequenciaTrocaFrame(periodo, inimigoFileira3);
                movimentoInimigos(7, inimigoFileira3, periodo);
                ++contFileira3;
            }
            if (contFileira3 == 11 || contFileira4 != 0) {
                frequenciaTrocaFrame(periodo, inimigoFileira4);
                movimentoInimigos(7, inimigoFileira4, periodo);
                ++contFileira4;
            }
            if (contFileira4 == 11 || contFileira5 != 0) {
                frequenciaTrocaFrame(periodo, inimigoFileira5);
                movimentoInimigos(7, inimigoFileira5, periodo);
                ++contFileira5;
            }
            
        }
    }

    /**
     *
     * @param frequencia precisa ser entre 0 e 59
     */
    private void frequenciaTrocaFrame(int frequencia, Sprite sprite) {
        int j;
        for (int i = 1; i <= frequencia; i++) {
            if (i == frequencia) {
                j = 59;
            } else {
                j = 60;
            }
            sprite.animacao(periodo(((double) j / frequencia) * i), contTempo);
        }
    }

    private double frequencia(int frequencia) {
        int j;
        for (int i = 1; i <= frequencia; i++) {
            if (i == frequencia) {
                j = 59;
            } else {
                j = 60;
            }
            if (periodo(((double) j / frequencia) * i) == contTempo) {
                return periodo(((double) j / frequencia) * i);
            }
        }
        return -1;
    }

    // frames vao de 0 a 59 a cada segundo
    private double periodo(double frame) {
        return TAXA_ATUALIZACAO * frame;
    }

    private void render() {
        this.repaint();
        stack -= 1;
        ArrayList<Tiro> tiros = new ArrayList<>();
        for (Tiro tiro : campo.tiros) {
            tiros.add(tiro);
            campo.add(tiro);
        }
        for (Tiro tiro : tiros) {
            for (Tiro tiro2 : campo.tiros) {
                if (tiro == tiro2) {
                    if (tiro2.type) {
                        tiro2.y -= 5;
                    } else {
                        tiro2.y += 5;
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        while (running) {
            tempoInicial = System.currentTimeMillis();
            update();
            render();
            tempoExecucao = (double) System.currentTimeMillis() - tempoInicial;
            try {
                Thread.sleep((long) Math.abs(TAXA_ATUALIZACAO - tempoExecucao));
            } catch (InterruptedException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            tempoTotal += System.currentTimeMillis() - tempoInicial;
            contTempo += TAXA_ATUALIZACAO;
            contFrame++;
            if (contFrame == contFrameMaximo) {
                mediaQuadros = 1000 / ((tempoTotal / contFrame));
                contFrame = 0;
                tempoTotal = 0;
                contTempo = 0;
            }
        }
    }

    private void handleEvents() {
        tela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    running = false;
                    tela.dispose();
                }
                if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (stack <= 0) {
                        campo.tiros.add(campo.jogador.atirar());
                        stack = 60;
                    }

                }
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    campo.jogador.velX = 5;
                } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    campo.jogador.velX = -5;
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_ALT) {
                    /*
                        esse ou serve para evitar um bug em que se o jogador
                        apertasse e soltasse a tecla alt enquanto andando
                        quando fosse solta a tecla de andar o personagem
                        continuaria andando infinitamente.
                        Em verdade, se for pressionada a tecla alt,
                        e então apertado para cima ou para baixo,
                        é exibida as opções da janela, padrão do windows.
                        Agora o jogador não fica andando infinitamente, porém,
                        ele fica parado no mapa. O mais certo aqui seria
                        ativar um pause game enquanto ele estiver com a tecla
                        alt apertada. Até lá serve esse tapa buraco.
                        Para desenvolver essa pause game, acredito que precise
                        apenas exibir uma nova JPanel em cima das outras.
                        E dar stop da thread enquanto o jogador não apertar
                        alt de novo.
                     */
                    campo.jogador.velX = 0;
                } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    campo.jogador.velX = 0;
                }
            }

        });
    }

}
