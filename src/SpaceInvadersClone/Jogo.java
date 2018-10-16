package SpaceInvadersClone;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Jogo extends JPanel implements Runnable {

    SpaceInvadersClone tela;

    Thread gameLoop;

    Placar placar;
    Campo campo;
    Info info;

    final int QUADROS_POR_SEGUNDO = 60;
    final double TAXA_ATUALIZACAO = 1000 / QUADROS_POR_SEGUNDO;
    double mediaQuadros;
    double tempoInicial;
    double tempoExecucao;
    double tempoTotal;

    int contFrame;
    int contFrameMaximo;

    public Jogo(SpaceInvadersClone tela) {
        this.tela = tela;
        this.setLayout(null);
        this.setSize(tela.getSize());
        this.setLocation(0, 0);
        init();
        tela.setVisible(true);
        colocarComponentes();
        gameLoop.start();
    }

    private void init() {
        gameLoop = new Thread(this, "Game Loop");
        placar = new Placar(this);
        campo = new Campo(this);
        info = new Info(this);
        contFrame = 0;
        contFrameMaximo = 60;
        tempoTotal = 0;
    }

    private void colocarComponentes() {
        this.add(placar);
        this.add(campo);
        this.add(info);
    }

    private void update() {
        handleEvents();
    }

    private void render() {
        System.out.println("FPS " + mediaQuadros);
    }

    @Override
    public void run() {
        while (true) {
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
            contFrame++;
            if (contFrame == contFrameMaximo) {
                mediaQuadros = 1000 / ((tempoTotal / contFrame));
                contFrame = 0;
                tempoTotal = 0;
            }
        }
    }

    private void handleEvents() {
        tela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                System.exit(0);
            }
        });
    }

}
