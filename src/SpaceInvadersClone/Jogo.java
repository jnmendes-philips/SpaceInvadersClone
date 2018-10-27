package SpaceInvadersClone;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

    int contFrame;
    int contFrameMaximo;

    boolean running;

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
        movimentoInimigos(5);
        animacoes();
    }

    private void movimentoInimigos(int velX) {
        if (campo.fileira1[0].x == campo.fileira2[0].x
                && campo.fileira2[0].x == campo.fileira3[0].x
                && campo.fileira3[0].x == campo.fileira4[0].x
                && campo.fileira4[0].x == campo.fileira5[0].x) {
            if (contTempo == 480 || contTempo == 944) {
                for (int i = 0; i < campo.fileira1.length; i++) {
                    Inimigo inimigo = campo.fileira1[i];
                    System.out.println(contTempo);
                    inimigo.x += velX;
                }
            }
        } else if (campo.fileira2[0].x == campo.fileira3[0].x
                && campo.fileira3[0].x == campo.fileira4[0].x
                && campo.fileira4[0].x == campo.fileira5[0].x) {
            if (contTempo == 480 || contTempo == 944) {
                for (int i = 0; i < campo.fileira2.length; i++) {
                    Inimigo inimigo = campo.fileira2[i];
                    inimigo.x += velX;
                }
            }
        } else if (campo.fileira3[0].x == campo.fileira4[0].x
                && campo.fileira4[0].x == campo.fileira5[0].x) {
            for (int i = 0; i < campo.fileira3.length; i++) {
                Inimigo inimigo = campo.fileira3[i];
                inimigo.x += velX;
            }
        } else if (campo.fileira4[0].x == campo.fileira5[0].x) {
            for (int i = 0; i < campo.fileira4.length; i++) {
                Inimigo inimigo = campo.fileira4[i];
                inimigo.x += velX;
            }
        } else {
            for (int i = 0; i < campo.fileira5.length; i++) {
                Inimigo inimigo = campo.fileira5[i];
                inimigo.x += velX;
            }
        }
    }

    private void animacoes() {
        //System.out.println(tempoTotal);
        for (Inimigo inimigo : campo.inimigos) {
            /*
                é possível alterar a frequencia em que as animações 
                trocam de frame apenas alterando o parametro frequencia
             */
            frequenciaTrocaFrame(2, inimigo);
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
            sprite.animacao(periodoTrocaFrame(((double) j / frequencia) * i), contTempo);
        }
    }

    // frames vao de 0 a 59 a cada segundo
    private double periodoTrocaFrame(double frame) {
        return TAXA_ATUALIZACAO * frame;
    }

    private void render() {
        this.repaint();
        //System.out.println("FPS " + mediaQuadros);
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
