package net.smyhk.android.memorygame;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // create media objects
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.button_1);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.button_2);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.button_3);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.button_4);
    }

    @Override
    public void onClick(View view) {

    }
}
