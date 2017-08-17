package localhost.vinu.spacejet;

/**
 * Created by vinu on 18/08/2017.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Boom {
    //bitmap obj
    private Bitmap bitmap;
    private int x,y;
    //constructor
    public Boom(Context context)
    {
        //getting boom img
        bitmap=BitmapFactory.decodeResource(context.getResources(),R.drawable.boom);
        //setting the coord outside screen
        x=-250;
        y=-250;
    }
    public void setX(int x)
    {
        this.x=x;

    }
    public void setY(int y) {
        this.y = y;
    }

    //getters
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
