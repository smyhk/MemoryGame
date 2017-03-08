package net.smyhk.android.memorygame;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

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
    int mDifficultyLevel = 3;
    int[] mSequenceToCopy = new int[100]; // holds randomly generated sequence

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

        // reference UI elements
        mScoreTextView = (TextView) findViewById(R.id.textScore);
        mScoreTextView.setText(getString(R.string.score_text, mPlayerScore));

        mDifficultyTextView = (TextView) findViewById(R.id.textDifficulty);
        mDifficultyTextView.setText(getString(R.string.difficulty_text, mDifficultyLevel));

        mWatchGoTextView = (TextView) findViewById(R.id.textWatchGo);

        mButtonOne = (Button) findViewById(R.id.button1);
        mButtonOne.setOnClickListener(this);

        mButtonTwo = (Button) findViewById(R.id.button2);
        mButtonTwo.setOnClickListener(this);

        mButtonThree = (Button) findViewById(R.id.button3);
        mButtonThree.setOnClickListener(this);

        mButtonFour = (Button) findViewById(R.id.button4);
        mButtonFour.setOnClickListener(this);

        mButtonReplay = (Button) findViewById(R.id.buttonReplay);
        mButtonReplay.setOnClickListener(this);

        // this code defines the thread
        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (mPlaySequence) {
                    // to be continued
                }
                mHandler.sendEmptyMessageDelayed(0, 900);
            }
        }; // end thread
    }

    @Override
    public void onClick(View view) {

    }

    public void createSequence() {
        Random randInt = new Random();
        int ourRandom;

        for (int i = 0; i < mDifficultyLevel; i++) {
            ourRandom = randInt.nextInt(4) + 1; // ensure non-zero
            // save to array
            mSequenceToCopy[i] = ourRandom;
        }
    }
}
