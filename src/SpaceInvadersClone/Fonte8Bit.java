package SpaceInvadersClone;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fonte8Bit extends Font {
    
    public Fonte8Bit(String string, int i, int i1) {
        super(string, i, i1);
        try {
            this.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "8bitoperator.ttf"));
            this.deriveFont(this.getSize() * 50F);
        } catch (FontFormatException ex) {
            Logger.getLogger(Fonte8Bit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fonte8Bit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
