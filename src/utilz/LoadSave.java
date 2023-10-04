package utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static final String PLAYER_ATLAS = "player_sprites.png";

    public static BufferedImage GetSpriteAtlas(String fileName){
        BufferedImage img = null;
        //get the input stream for the sprite image
        InputStream is = LoadSave.class .getResourceAsStream("/" + fileName );
        //try/catch/finally
        try{
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }
}
