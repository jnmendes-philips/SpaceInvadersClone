package SpaceInvadersClone;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SpaceInvadersClone {

    public SpaceInvadersClone() throws InterruptedException {
        new Tela();
    }
    
    public static void main(String[] args) {
        try {
            new SpaceInvadersClone();
        } catch (InterruptedException ex) {
            Logger.getLogger(SpaceInvadersClone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
