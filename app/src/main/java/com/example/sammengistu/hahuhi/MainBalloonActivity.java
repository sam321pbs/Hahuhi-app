package com.example.sammengistu.hahuhi;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainBalloonActivity extends FragmentActivity {

    private ArrayList<Balloon> mBalloonArrayList;
    private ArrayList<ImageView> mBalloonsImageViewsList;

    private ImageView mBalloonPortrait1;
    private ImageView mBalloonPortrait2;
    private ImageView mBalloonPortrait3;
    private ImageView mBalloonPortrait4;
    private ImageView mBalloonPortrait5;

    private ImageView mRandomImageView;
    private ImageView mSequentialImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ballon);

        mBalloonArrayList = new ArrayList<>();
        mBalloonsImageViewsList = new ArrayList<>();

        Balloon balloon1 = new Balloon(R.drawable.chih, R.raw.chih_, 1);
        Balloon balloon2 = new Balloon(R.drawable.fe, R.raw.fe_, 2);
        Balloon balloon3 = new Balloon(R.drawable.je, R.raw.je_, 3);
        Balloon balloon4 = new Balloon(R.drawable.mae, R.raw.mae_, 4);
        Balloon balloon5 = new Balloon(R.drawable.weh, R.raw.weh_, 5);

        mBalloonArrayList.add(balloon1);
        mBalloonArrayList.add(balloon2);
        mBalloonArrayList.add(balloon3);
        mBalloonArrayList.add(balloon4);
        mBalloonArrayList.add(balloon5);


        mBalloonPortrait1 = (ImageView) findViewById(R.id.activity_main_balloon_image_view_1);
        mBalloonPortrait2 = (ImageView) findViewById(R.id.activity_main_balloon_image_view_2);
        mBalloonPortrait3 = (ImageView) findViewById(R.id.activity_main_balloon_image_view_3);
        mBalloonPortrait4 = (ImageView) findViewById(R.id.activity_main_balloon_image_view_4);
        mBalloonPortrait5 = (ImageView) findViewById(R.id.activity_main_balloon_image_view_5);

        mBalloonsImageViewsList.add(mBalloonPortrait1);
        mBalloonsImageViewsList.add(mBalloonPortrait2);
        mBalloonsImageViewsList.add(mBalloonPortrait3);
        mBalloonsImageViewsList.add(mBalloonPortrait4);
        mBalloonsImageViewsList.add(mBalloonPortrait5);

        mRandomImageView = (ImageView) findViewById(R.id.random_button_image_view);
        mSequentialImageView = (ImageView) findViewById(R.id.sequential_button_image_view);

        mBalloonPortrait1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(0).getAudioId());
                mediaPlayer.start();

                mBalloonPortrait1.startAnimation(AnimationUtils.loadAnimation(
                        getApplicationContext(),
                        R.anim.fall));


                balloonFallAndFloat(mBalloonPortrait1);

            }
        });

        mBalloonPortrait2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(1).getAudioId());
                mediaPlayer.start();

                mBalloonPortrait2.startAnimation(AnimationUtils.loadAnimation(
                        getApplicationContext(),
                        R.anim.fall));

                balloonFallAndFloat(mBalloonPortrait2);

            }
        });

        mBalloonPortrait3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(2).getAudioId());
                mediaPlayer.start();

                mBalloonPortrait3.startAnimation(AnimationUtils.loadAnimation(
                        getApplicationContext(),
                        R.anim.fall));

                balloonFallAndFloat(mBalloonPortrait3);
            }
        });

        mBalloonPortrait4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(3).getAudioId());
                mediaPlayer.start();

                mBalloonPortrait4.startAnimation(AnimationUtils.loadAnimation(
                        getApplicationContext(),
                        R.anim.fall));
                balloonFallAndFloat(mBalloonPortrait4);
            }
        });

        mBalloonPortrait5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(4).getAudioId());
                mediaPlayer.start();

                mBalloonPortrait5.startAnimation(AnimationUtils.loadAnimation(
                        getApplicationContext(),
                        R.anim.fall));
                balloonFallAndFloat(mBalloonPortrait5);
            }
        });

        mRandomImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.shuffle(mBalloonArrayList);

                for (int i = 0; i < mBalloonsImageViewsList.size(); i++) {
                    mBalloonsImageViewsList.get(i).setImageResource(
                            mBalloonArrayList.get(i).getBalloonImageId());
                }
            }
        });

        mSequentialImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sortAlphabetically();

                for (int i = 0; i < mBalloonsImageViewsList.size(); i++) {
                    mBalloonsImageViewsList.get(i).setImageResource(
                            mBalloonArrayList.get(i).getBalloonImageId());
                }
            }
        });



        startGameAnimation();

    }

    /**
     * Gets the first five balloons to float up to the screen to be played with
     */
    private void startGameAnimation(){

        for (ImageView balloon: mBalloonsImageViewsList){
            balloon.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.start_game_animation));
        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            for (ImageView balloon: mBalloonsImageViewsList){
                                balloon.startAnimation(AnimationUtils.loadAnimation(
                                        getApplicationContext(),
                                        R.anim.move));

                            }
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

    }

    /**
     * Makes a balloon fall and rise back up and starts another animation
     * after the duration of the fall and rise and makes it float again
     * @param balloon - the balloon to be animated
     */
    private void balloonFallAndFloat(final ImageView balloon){
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(6000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            balloon.startAnimation(AnimationUtils.loadAnimation(
                                    getApplicationContext(), R.anim.move));
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

    }

    /**
     * sorts the letters alphabetically based on the number count
     * so it actually sorts it numerically
     */
    private void sortAlphabetically() {
        Collections.sort(mBalloonArrayList, new Comparator<Balloon>() {
            @Override
            public int compare(Balloon lhs, Balloon rhs) {
                Integer leftHand = lhs.getAlphabetLetterNumber();
                Integer rightHand = rhs.getAlphabetLetterNumber();

                return leftHand.compareTo(rightHand);


            }
        });
    }

}
