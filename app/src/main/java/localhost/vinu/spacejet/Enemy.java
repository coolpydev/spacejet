package localhost.vinu.spacejet;

/**
 * Created by vinu on 18/08/2017.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.util.Random;
public class Enemy {
   //bitmap for enemy
    private Bitmap bitmap;
    private int x,maxX,minX;
    private int y,minY,maxY;
    private int speed =1;
    private Rect detectCollision;
    //constructor
    public Enemy(Context context,int screenX,int screenY)
    {
        //gettting bitmap from drawable
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.enemy);
        //init max and min coordinate
        maxX=screenX;
        maxY=screenY;
        minX=maxY=0;
        //generating a random coordinate to enemy
        Random generator = new Random();
        speed=generator.nextInt(6)+10;
        x=screenX;
        y = generator.nextInt(maxY)-bitmap.getHeight();
        //init rect obj
        detectCollision = new Rect(x,y,bitmap.getWidth(),bitmap.getHeight());
    }
    public void update(int playerSpeed)
    {
        //decrese x coordinate
        x-=playerSpeed;
        x-=speed;
        if (x<minX-bitmap.getWidth())
        {  //adding random enemy\
            Random generator = new Random();
            speed = generator.nextInt(10)+10;
            x=maxX;
            y=generator.nextInt(maxY)-bitmap.getHeight();}
        //adding the N,S,E,W obj
        detectCollision.left=x;
        detectCollision.top=y;
        detectCollision.bottom=x+bitmap.getWidth();
        detectCollision.right=y+bitmap.getHeight();
    }
    //adding a setter to x so we change it
    public void setX(int X)
    {this.x=x;}
    //one more getter for getting the rect obj
    public  Rect getDetectCollision()
    {return detectCollision;}
    //getters
    public Bitmap getBitmap()
    { return bitmap;}
   public int getX()
   { return x;}
    public int getY()
    { return y;}
   public int getSpeed()
   { return speed;}

}
