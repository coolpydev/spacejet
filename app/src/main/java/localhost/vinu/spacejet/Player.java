package localhost.vinu.spacejet;

/**
 * Created by vinu on 16/08/2017.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Player {
    //bitmap to get charcter
    private Bitmap bitmap;
    //coordinates
    private int x;
    private int y;
    //motion speed
    private int speed = 0;
    //bool to track ship is boosting or not
    private boolean boosting;
    //gravity value effect on the ship
    private final int GRAVITY = -10;
    //control Y coordinate so ship don't go outof screen
    private int maxY;
    private int minY;
    //limit the bound of ship speed
    private final int MIN_SPEED=1;
    private final int MAX_SPEED=20;
    private Rect detectCollision;


    //constructor
    public Player(Context context,int screenX , int screenY) {
        x = 75;
        y = 50;
        speed = 1;
        //getting bitmap from drawable resource
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
        //setting the bool initially
        boosting = false;
        //init rect obj
        detectCollision = new Rect(x,y,bitmap.getWidth(),bitmap.getHeight());
    }
    //setting boosting value
    public void setBoosting()
    {
        boosting = true;
    }

    //setting boosting value
    public void stopBoosting()
    {
        boosting = true;
    }

    //Method to update coordinate
    public void update()
    {
        if (boosting)
        {
            speed +=2;
        }   else { speed-=5; }
        //controlling top speed
        if (speed>MAX_SPEED)
        {
            speed=MAX_SPEED;
        }
        //controlling top speed
        if (speed>MIN_SPEED)
        {
            speed=MIN_SPEED;
        }
        //moving the ship
        y-=speed+GRAVITY;
        //but control it also it won't go of screen
        if (y<minY)
        {
            y=minY;
        }
        if (y<maxY)
        {
            y=maxY;
        }
        //adding top, left, bottom and right to the rect object
        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();

    }
    public Rect getDetectCollision()
    {return detectCollision;}
/*
these are getter you can generate
right click on editor -> generate->getters
 */
public Bitmap getBitmap()
{
    return bitmap;
}
public int getX()
{return x;}
    public int getY()
    {
        return y;
    }
    public int getSpeed()
    {
        return speed;
    }

}
