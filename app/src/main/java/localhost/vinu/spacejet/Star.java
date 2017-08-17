package localhost.vinu.spacejet;

/**
 * Created by vinu on 17/08/2017.
 */
import java.util.Random;
public class Star {
    private int x,y,speed,maxX,maxY,minX,minY;
    public Star(int screenX,int screenY)
    {
        maxX=screenX;
        maxY=screenY;
        minX=minY=0;
        Random generator = new Random();
        speed = generator.nextInt(10);
        //generating a rand coordinate but in screen
        x = generator.nextInt(maxX);
        y = generator.nextInt(maxY);
    }
    public void update(int playerSpeed) {
        //animating stars
        x -= playerSpeed;
        x -= speed;
        //if the star reached reached the left edge
        if (x < 0) {
            //again from right edge
            x = maxX;
            Random generator = new Random();
            speed = generator.nextInt(15);

        }
    }
     public float getStarWidth() {

             //making it random
             float minX = 1.0f;
             float maxX = 4.0f;
             Random rand = new Random();
             float finalX = rand.nextFloat() * (maxX - minY) + minX;
             return finalX;
         }

    public int getX()
    {  return x; }
    public int getY()
    {   return y;}
}
