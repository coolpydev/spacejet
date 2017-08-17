package localhost.vinu.spacejet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //image button
    private ImageButton buttonPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //getting button
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);
        //adding click listener
        buttonPlay.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        //start game
        startActivity(new Intent(this,GameActivity.class));
    }
}
