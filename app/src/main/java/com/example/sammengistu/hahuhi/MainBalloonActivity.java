package com.example.sammengistu.hahuhi;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    private ObjectAnimator mObjectAnimator1;
    private ObjectAnimator mObjectAnimator2;
    private ObjectAnimator mObjectAnimator3;
    private ObjectAnimator mObjectAnimator4;
    private ObjectAnimator mObjectAnimator5;

    private List<Animator> mAnimationsForBalloon1 = new ArrayList<>();
    private List<Animator> mAnimationsForBalloon2 = new ArrayList<>();
    private List<Animator> mAnimationsForBalloon3 = new ArrayList<>();
    private List<Animator> mAnimationsForBalloon4 = new ArrayList<>();
    private List<Animator> mAnimationsForBalloon5 = new ArrayList<>();

    private AnimatorSet mAnimatorSetForBalloon1;
    private AnimatorSet mAnimatorSetForBalloon2;
    private AnimatorSet mAnimatorSetForBalloon3;
    private AnimatorSet mAnimatorSetForBalloon4;
    private AnimatorSet mAnimatorSetForBalloon5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ballon);

        initialize();

        mAnimationsForBalloon1.add(mObjectAnimator1);
        mAnimationsForBalloon2.add(mObjectAnimator2);
        mAnimationsForBalloon3.add(mObjectAnimator3);
        mAnimationsForBalloon4.add(mObjectAnimator4);
        mAnimationsForBalloon5.add(mObjectAnimator5);

        mAnimatorSetForBalloon1 = new AnimatorSet();
        mAnimatorSetForBalloon2 = new AnimatorSet();
        mAnimatorSetForBalloon3 = new AnimatorSet();
        mAnimatorSetForBalloon4 = new AnimatorSet();
        mAnimatorSetForBalloon5 = new AnimatorSet();

        mAnimatorSetForBalloon1.playTogether(mAnimationsForBalloon1);
        mAnimatorSetForBalloon2.playTogether(mAnimationsForBalloon2);
        mAnimatorSetForBalloon3.playTogether(mAnimationsForBalloon3);
        mAnimatorSetForBalloon4.playTogether(mAnimationsForBalloon4);
        mAnimatorSetForBalloon5.playTogether(mAnimationsForBalloon5);

        mAnimatorSetForBalloon1.start();
        mAnimatorSetForBalloon2.start();
        mAnimatorSetForBalloon3.start();
        mAnimatorSetForBalloon4.start();
        mAnimatorSetForBalloon5.start();

        mBalloonPortrait1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAnimatorSetForBalloon1.cancel();

                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(0).getAudioId());
                mediaPlayer.start();

                mAnimatorSetForBalloon1.start();
            }
        });

        mBalloonPortrait2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAnimatorSetForBalloon2.cancel();

                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(1).getAudioId());
                mediaPlayer.start();

                mAnimatorSetForBalloon2.start();

            }
        });

        mBalloonPortrait3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAnimatorSetForBalloon3.cancel();

                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(2).getAudioId());
                mediaPlayer.start();

                mAnimatorSetForBalloon3.start();
            }
        });

        mBalloonPortrait4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAnimatorSetForBalloon4.cancel();

                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(3).getAudioId());
                mediaPlayer.start();

                mAnimatorSetForBalloon4.start();
            }
        });

        mBalloonPortrait5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAnimatorSetForBalloon5.cancel();

                MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
                        mBalloonArrayList.get(4).getAudioId());
                mediaPlayer.start();

                mAnimatorSetForBalloon5.start();
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

    }

    private void initialize(){
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

        mObjectAnimator1 =  ObjectAnimator.ofFloat(mBalloonPortrait1,
            "translationY", -750);
        mObjectAnimator1.setDuration(5000);

        mObjectAnimator1.setRepeatCount(ObjectAnimator.INFINITE);
        mObjectAnimator1.setRepeatMode(ObjectAnimator.RESTART);
        mObjectAnimator1.setInterpolator(new LinearInterpolator());

        mObjectAnimator2 =  ObjectAnimator.ofFloat(mBalloonPortrait2,
            "translationY", -750);
        mObjectAnimator2.setDuration(5000);

        mObjectAnimator2.setRepeatCount(ObjectAnimator.INFINITE);
        mObjectAnimator2.setRepeatMode(ObjectAnimator.RESTART);
        mObjectAnimator2.setInterpolator(new LinearInterpolator());

        mObjectAnimator3 =  ObjectAnimator.ofFloat(mBalloonPortrait3,
            "translationY", -750);
        mObjectAnimator3.setDuration(5000);

        mObjectAnimator3.setRepeatCount(ObjectAnimator.INFINITE);
        mObjectAnimator3.setRepeatMode(ObjectAnimator.RESTART);
        mObjectAnimator3.setInterpolator(new LinearInterpolator());

        mObjectAnimator4 =  ObjectAnimator.ofFloat(mBalloonPortrait4,
            "translationY", -750);
        mObjectAnimator4.setDuration(5000);

        mObjectAnimator4.setRepeatCount(ObjectAnimator.INFINITE);
        mObjectAnimator4.setRepeatMode(ObjectAnimator.RESTART);
        mObjectAnimator4.setInterpolator(new LinearInterpolator());

        mObjectAnimator5 =  ObjectAnimator.ofFloat(mBalloonPortrait5,
            "translationY", -750);
        mObjectAnimator5.setDuration(5000);

        mObjectAnimator5.setRepeatCount(ObjectAnimator.INFINITE);
        mObjectAnimator5.setRepeatMode(ObjectAnimator.RESTART);
        mObjectAnimator5.setInterpolator(new LinearInterpolator());
    }


    /**
     * Gets the first five balloons to float up to the screen to be played with
     */
    private void startGameAnimation(){

        for (ImageView balloon: mBalloonsImageViewsList){
//            balloon.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
//                    R.anim.float_away));

            ObjectAnimator animator = ObjectAnimator.ofFloat(balloon,
                "translationY", -750);
            animator.setDuration(5000);

            animator.setRepeatCount(ObjectAnimator.INFINITE);
            animator.setRepeatMode(ObjectAnimator.RESTART);
            animator.setInterpolator(new LinearInterpolator());
            animator.start();

        }

//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    sleep(8000);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            startGameAnimation();
//                        }
//                    });
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        thread.start();

    }

    /**
     * Makes a balloon fall and rise back up and starts another animation
     * after the duration of the fall and rise and makes it float again
     * @param balloon - the balloon to be animated
     */
//    private void balloonFallAndFloat(final ImageView balloon){
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//
//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            balloon.startAnimation(AnimationUtils.loadAnimation(
//                                    getApplicationContext(), R.anim.start_game_animation));
//                        }
//                    });
//
//
//            }
//        };
//
//        thread.start();
//
//    }

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
