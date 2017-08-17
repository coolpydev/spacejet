package localhost.vinu.spacejet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created by vinu on 16/08/2017.
 */

public class GameView extends SurfaceView implements Runnable {
    //bool var to track game is palyed or not
    volatile boolean playing;
    //game thread
    private Thread gameThread = null;
    //adding the player to this class
    private Player player;
    //These obj will be used for drawing
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    //adding enimies obj
    private Enemy[] enemies;
    //adding 3 enimies you may increase size
    private int enemyCount = 3;

    //adding stars
    private ArrayList<Star> stars = new ArrayList<Star>();
    //defining a boom obj
    private Boom boom;

    //class constuctor
    public GameView(Context context,int screenX , int screenY)
    {
        super(context);
        //initializing player object
        player = new Player(context,screenX,screenY);
        //init drawing obj
        surfaceHolder = getHolder();
        paint = new Paint();
        int starNums = 100;
        for (int i=0;i<starNums;i++)
        {  Star s = new Star(screenX,screenY);
           stars.add(s);
        }
        //init enemy obj array
        enemies = new Enemy[enemyCount];
        for (int i=0;i<enemyCount;i++)
        {   enemies[i]=new Enemy(context,screenX,screenY);}
        boom = new Boom(context);
    }
    @Override
    public void run(){
        while (playing){
            //frame update
            update();
        //draw frame
            draw();
        //control
        control();}
    }
    private void update()
    { player.update();
        //setting boom outside screen
        boom.setX(-250);
        boom.setY(-250);
    //updating thee stars with player speed
        for (Star s:stars)
        {  s.update(player.getSpeed()); }
        //updating the enemy coordinate w.r.t to player
        for (int j = 0; j<enemyCount; j++)
        {   enemies[j].update(player.getSpeed());
        //if collision occurs with player
        if (Rect.intersects(player.getDetectCollision(),enemies[j].getDetectCollision()))
        { enemies[j].setX(-200);
          boom.setX(enemies[j].getX());
        boom.setY(enemies[j].getY());}
    }
    }
    private void draw(){
        if (surfaceHolder.getSurface().isValid())
        {
        canvas = surfaceHolder.lockCanvas();
        //draw a bg color
        canvas.drawColor(Color.BLACK);
         //setting the paint color to white
         paint.setColor(Color.WHITE);
            //drawign the stars
            for (Star s:stars)
            {  paint.setStrokeWidth(s.getStarWidth());
               canvas.drawPoint(s.getX(),s.getY(),paint);}
            canvas.drawBitmap(player.getBitmap(),player.getX(),player.getY(),paint);
        //drawing the player
        canvas.drawBitmap(player.getBitmap(),player.getX(),player.getY(),paint);
        //drawing the enemies
            for (int i =0;i<enemyCount;i++)
            { canvas.drawBitmap(enemies[i].getBitmap(),enemies[i].getX(),enemies[i].getY(),paint);   }
           canvas.drawBitmap(boom.getBitmap(),boom.getX(),boom.getY(),paint);
            //unlock the canvas
        surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    private void control() {
        try {
            gameThread.sleep(17);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
        public void pause(){
        //game paused
            playing = false;
            try {
                //stop game
                gameThread.join();
            }
            catch(InterruptedException e){}
    }
    public void resume(){
        //when game resumes
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_MASK:
                //stopping the boost when screen is releases.
                player.stopBoosting();
                break;
            case MotionEvent.ACTION_DOWN:
                //more
                player.setBoosting();
                break;
        }
        return true;
    }
}


