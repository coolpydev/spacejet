package localhost.vinu.spacejet;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class GameActivity extends AppCompatActivity {
    //declaring gameview
   static private GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //intializing game view obj
        //adding it to contentview\
        setContentView(gameView);
        //getting display obj
        Display display = getWindowManager().getDefaultDisplay();
        //getting the screen res
        Point size=new Point();
        display.getSize(size);
        //init game viw obj
        gameView = new GameView(this,size.x,size.y);
    }
    //pausing game when activity
    @Override
    protected void onPause()
    {
        super.onPause();
        gameView.pause();
    }
    @Override
    protected void onResume()
    {}


}
