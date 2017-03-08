package net.smyhk.android.memorygame;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mScoreTextView;
    TextView mDifficultyTextView;
    TextView mWatchGoTextView;

    Button mButtonOne;
    Button mButtonTwo;
    Button mButtonThree;
    Button mButtonFour;
    Button mButtonReplay;

    // for threading
    int difficultyLevel = 3;
    int[] sequenceToCopy = new int[100]; // holds randomly generated sequence

    private Handler mHandler;
    // playing sequence?
    boolean mPlaySequence = false;
    // which element of sequence are we on?
    int mElementToPlay = 0;

    // for checking player's answer
    int mPlayerResponses;
    int mPlayerScore;
    boolean mIsResponding;

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
