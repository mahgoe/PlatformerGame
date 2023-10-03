package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.Directions.*;
import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity{

    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 17;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;
    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update(){
        updateAnimationTick();
        setAnimation();
        updatePosition();
    }

    public void render(Graphics g){
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 160, null);
    }

    public void setDirection(int direction){
        this.playerDir = direction;
        moving = true;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }

    /**
     * Function to update and increment the tick to animate the img
     */
    private void updateAnimationTick() {

        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction))
                aniIndex = 0;
        }
    }

    private void setAnimation(){
        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
    }

    private void updatePosition() {
        if(moving){
            switch (playerDir){
                case LEFT:
                    x -= 1;
                    break;
                case UP:
                    y -= 1;
                    break;
                case RIGHT:
                    x += 1;
                    break;
                case DOWN:
                    y += 1;
                    break;
            }
        }
    }

    /**
     * Function to load animations
     */
    private void loadAnimations() {
        //get the input stream for the sprite image
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        //try/catch/finally
        try{
           BufferedImage img = ImageIO.read(is);
            animations = new BufferedImage[9][6];

            for(int j = 0; j < animations.length; j++)
                for (int i = 0; i < animations[j].length; i++)
                    animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
