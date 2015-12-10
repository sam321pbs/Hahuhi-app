package com.example.sammengistu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import HahuhiGame.hahuhi.R;

public class MainBalloonActivity extends FragmentActivity {

    private static final String TAG = "MainBalloonActivity";
    private final String ANIMATION_TYPE = "translationY";
    private final int ANIMATION_DISTANCE_TO_TRAVEL = -750;


    private ArrayList<ImageView> mBalloonsImageViewsList;
    private BalloonList mBalloonList;

    private ImageView mBalloonPortrait1;
    private ImageView mBalloonPortrait2;
    private ImageView mBalloonPortrait3;
    private ImageView mBalloonPortrait4;
    private ImageView mBalloonPortrait5;

    private ImageView mRandomImageView;
    private ImageView mSequentialImageView;

    private ObjectAnimator mObjectAnimatorFloatAway1;
    private ObjectAnimator mObjectAnimatorFloatAway2;
    private ObjectAnimator mObjectAnimatorFloatAway3;
    private ObjectAnimator mObjectAnimatorFloatAway4;
    private ObjectAnimator mObjectAnimatorFloatAway5;

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

    private List<Balloon> mBalloonsOnScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ballon);

        initialize();

        setUpFloatAwayAnimationAndStart();

        mBalloonPortrait1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Balloon = " + mBalloonsOnScreen.get(0).getBalloonLetter());
                Log.i(TAG, "BalloonAudio = " + mBalloonsOnScreen.get(0).getAlphabetLetterNumber());

                mAnimatorSetForBalloon1.cancel();

                playSoundOfLetter(0);

                balloonPopAndStartNextBalloon(
                    mBalloonPortrait1,
                    mAnimatorSetForBalloon1,
                    mBalloonsOnScreen.get(0).getBalloonPoppedImageId(),
                    0);


            }
        });

        mBalloonPortrait2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Balloon = " + mBalloonsOnScreen.get(1).getBalloonLetter());
                Log.i(TAG, "BalloonAudio = " + mBalloonsOnScreen.get(1).getAlphabetLetterNumber());

                mAnimatorSetForBalloon2.cancel();

                playSoundOfLetter(1);

                balloonPopAndStartNextBalloon(
                    mBalloonPortrait2,
                    mAnimatorSetForBalloon2,
                    mBalloonsOnScreen.get(1).getBalloonPoppedImageId(),
                    1);

            }
        });

        mBalloonPortrait3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Balloon = " + mBalloonsOnScreen.get(2).getBalloonLetter());
                Log.i(TAG, "BalloonAudio = " + mBalloonsOnScreen.get(2).getAlphabetLetterNumber());

                mAnimatorSetForBalloon3.cancel();

                playSoundOfLetter(2);

                balloonPopAndStartNextBalloon(
                    mBalloonPortrait3,
                    mAnimatorSetForBalloon3,
                    mBalloonsOnScreen.get(2).getBalloonPoppedImageId(),
                    2);

            }
        });

        mBalloonPortrait4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Balloon = " + mBalloonsOnScreen.get(3).getBalloonLetter());
                Log.i(TAG, "BalloonAudio = " + mBalloonsOnScreen.get(3).getAlphabetLetterNumber());

                mAnimatorSetForBalloon4.cancel();

                playSoundOfLetter(3);

                balloonPopAndStartNextBalloon(
                    mBalloonPortrait4,
                    mAnimatorSetForBalloon4,
                    mBalloonsOnScreen.get(3).getBalloonPoppedImageId(),
                    3);
            }
        });

        mBalloonPortrait5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Balloon = " + mBalloonsOnScreen.get(4).getBalloonLetter());
                Log.i(TAG, "BalloonAudio = " + mBalloonsOnScreen.get(4).getAlphabetLetterNumber());

                mAnimatorSetForBalloon5.cancel();

                playSoundOfLetter(4);

                balloonPopAndStartNextBalloon(
                    mBalloonPortrait5,
                    mAnimatorSetForBalloon5,
                    mBalloonsOnScreen.get(4).getBalloonPoppedImageId(),
                    4);
            }
        });

        mRandomImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBalloonList.shuffleBalloons();

                updateBalloonsOnScreen();

                startAnimations();
            }
        });

        mSequentialImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBalloonList.sortAlphabetically();

                updateBalloonsOnScreen();

                startAnimations();
            }
        });

        for (ImageView balloonView: mBalloonsImageViewsList){
            makeAllBalloonsBigger(balloonView);
        }

        setFirst5Balloons();
    }

    private void makeAllBalloonsBigger(ImageView balloonView){
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(balloonView, "scaleX", 1.0f, 1.3f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(balloonView, "scaleY", 1.0f, 1.3f);

        AnimatorSet scaleAnim = new AnimatorSet();
        scaleAnim.setDuration(1000);
        scaleAnim.play(scaleX).with(scaleY);

        scaleAnim.start();
    }

    /**
     * Updates the balloonsOnScreen List and also updates the images on the screen
     */
    private void updateBalloonsOnScreen() {

        for (int i = 0; i < mBalloonsImageViewsList.size(); i++) {

            mBalloonsOnScreen.set(i, mBalloonList.getBalloon(i));

            mBalloonsImageViewsList.get(i).setImageResource(
                mBalloonsOnScreen.get(i).getBalloonNonPoppedImageId()
            );
        }
    }

    /**
     * Plays the sound associated with the balloon
     *
     * @param balloonNumber - gets the sound of the balloon
     */
    private void playSoundOfLetter(int balloonNumber) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(MainBalloonActivity.this,
            mBalloonsOnScreen.get(balloonNumber).getAudioId());
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });

    }

    /**
     * Sets up the Animators with float and starts the animation
     */
    private void setUpFloatAwayAnimationAndStart() {
        mAnimationsForBalloon1.add(mObjectAnimatorFloatAway1);
        mAnimationsForBalloon2.add(mObjectAnimatorFloatAway2);
        mAnimationsForBalloon3.add(mObjectAnimatorFloatAway3);
        mAnimationsForBalloon4.add(mObjectAnimatorFloatAway4);
        mAnimationsForBalloon5.add(mObjectAnimatorFloatAway5);

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

        startAnimations();
    }

    /**
     * Stops any playing animations and makes the images invisible
     * Then restarts the animations from the beginning
     */
    private void startAnimations() {

        mAnimatorSetForBalloon1.cancel();
        mAnimatorSetForBalloon2.cancel();
        mAnimatorSetForBalloon3.cancel();
        mAnimatorSetForBalloon4.cancel();
        mAnimatorSetForBalloon5.cancel();

        for (ImageView balloonImageView : mBalloonsImageViewsList) {
            balloonImageView.setVisibility(View.INVISIBLE);
        }

        mAnimatorSetForBalloon1.start();
        mBalloonPortrait1.setVisibility(View.VISIBLE);

        startBalloonAnimationDelayed(400, mAnimatorSetForBalloon2, mBalloonPortrait2);

        startBalloonAnimationDelayed(200, mAnimatorSetForBalloon3, mBalloonPortrait3);

        startBalloonAnimationDelayed(2000, mAnimatorSetForBalloon4, mBalloonPortrait4);

        startBalloonAnimationDelayed(1500, mAnimatorSetForBalloon5, mBalloonPortrait5);

    }

    /**
     * Starts the balloon animation with delay
     *
     * @param delayTime             - amount of time to delay
     * @param animatorSetForBalloon - which animation to start
     * @param balloonPortrait       - the balloon image view to change visibility
     */
    private void startBalloonAnimationDelayed(int delayTime,
                                              final AnimatorSet animatorSetForBalloon,
                                              final ImageView balloonPortrait) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animatorSetForBalloon.start();
                balloonPortrait.setVisibility(View.VISIBLE);

            }
        }, delayTime);
    }

    /**
     * Sets up the first 5 balloons on the screen at the start of the game
     */
    private void setFirst5Balloons() {

        int counter = 0;
        for (ImageView balloonImageView : mBalloonsImageViewsList) {
            balloonImageView.setImageResource(
                mBalloonList.getBalloonNonPopped(
                    mBalloonList.getBalloonTracker())
            );

            mBalloonsOnScreen.add(mBalloonList.getBalloon(counter++));
        }
    }

    /**
     * Initializes all objects
     */
    private void initialize() {

        mBalloonsImageViewsList = new ArrayList<>();
        mBalloonsOnScreen = new ArrayList<>();
        mBalloonList = new BalloonList();
        List<ObjectAnimator> objectAnimatorList = new ArrayList<>();

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

        initializeFloatAways();

        setListenerForFloatAway();

        objectAnimatorList.add(mObjectAnimatorFloatAway1);
        objectAnimatorList.add(mObjectAnimatorFloatAway2);
        objectAnimatorList.add(mObjectAnimatorFloatAway3);
        objectAnimatorList.add(mObjectAnimatorFloatAway4);
        objectAnimatorList.add(mObjectAnimatorFloatAway5);

        for (ObjectAnimator objectAnimator : objectAnimatorList) {

            int duration = 13000;
            objectAnimator.setDuration(duration);

            objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            objectAnimator.setRepeatMode(ObjectAnimator.RESTART);
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
    }

    /**
     * Sets listener for the animation
     * when the Animation repeats it will update the balloon on screen to the next balloon
     * in balloon list
     */
    private void setListenerForFloatAway() {

        mObjectAnimatorFloatAway1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

                changeBalloonOnScreen(mBalloonsOnScreen, 0,
                    mBalloonList.getBalloon(mBalloonList.getBalloonTracker()),
                    mBalloonPortrait1);


            }
        });

        mObjectAnimatorFloatAway2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                changeBalloonOnScreen(mBalloonsOnScreen, 1,
                    mBalloonList.getBalloon(mBalloonList.getBalloonTracker()),
                    mBalloonPortrait2);
            }
        });


        mObjectAnimatorFloatAway3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                changeBalloonOnScreen(mBalloonsOnScreen, 2,
                    mBalloonList.getBalloon(mBalloonList.getBalloonTracker()),
                    mBalloonPortrait3);
            }
        });

        mObjectAnimatorFloatAway4.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                changeBalloonOnScreen(mBalloonsOnScreen, 3,
                    mBalloonList.getBalloon(mBalloonList.getBalloonTracker()),
                    mBalloonPortrait4);
            }
        });

        mObjectAnimatorFloatAway5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                changeBalloonOnScreen(mBalloonsOnScreen, 4,
                    mBalloonList.getBalloon(mBalloonList.getBalloonTracker()),
                    mBalloonPortrait5);
            }
        });
    }

    /**
     * Updates the balloons on the screen at the completion of the animation
     *
     * @param balloonsOnScreen     - list of the balloons on the screen
     * @param whichBalloonOnScreen - which balloon on screen to update
     * @param balloon              - the next balloon on the list
     * @param balloonPortrait      - which image view on the screen to change its image
     */
    private void changeBalloonOnScreen(List<Balloon> balloonsOnScreen, int whichBalloonOnScreen,
                                       Balloon balloon, ImageView balloonPortrait) {

        balloonsOnScreen.set(whichBalloonOnScreen, balloon);

        balloonPortrait.setImageResource(
            balloonsOnScreen.get(whichBalloonOnScreen).getBalloonNonPoppedImageId());
    }

    private void initializeFloatAways() {
        mObjectAnimatorFloatAway1 = ObjectAnimator.ofFloat(mBalloonPortrait1,
            ANIMATION_TYPE, ANIMATION_DISTANCE_TO_TRAVEL);

        mObjectAnimatorFloatAway2 = ObjectAnimator.ofFloat(mBalloonPortrait2,
            ANIMATION_TYPE, ANIMATION_DISTANCE_TO_TRAVEL);

        mObjectAnimatorFloatAway3 = ObjectAnimator.ofFloat(mBalloonPortrait3,
            ANIMATION_TYPE, ANIMATION_DISTANCE_TO_TRAVEL);

        mObjectAnimatorFloatAway4 = ObjectAnimator.ofFloat(mBalloonPortrait4,
            ANIMATION_TYPE, ANIMATION_DISTANCE_TO_TRAVEL);

        mObjectAnimatorFloatAway5 = ObjectAnimator.ofFloat(mBalloonPortrait5,
            ANIMATION_TYPE, ANIMATION_DISTANCE_TO_TRAVEL);
    }

    /**
     * Starts the animation to make the balloon bigger and then shows the popped balloon
     *
     * @param balloonView                     - balloons image view
     * @param animatorSet                     - to restart the float animation
     * @param poppedBalloonId                 - the image of the popped balloon
     * @param changeBalloonOnScreenListNumber - the balloon on screen number
     */
    private void balloonPopAndStartNextBalloon(final ImageView balloonView,
                                               final AnimatorSet animatorSet,
                                               final int poppedBalloonId,
                                               final int changeBalloonOnScreenListNumber) {

        makeBalloonBiggerThenPop(balloonView, poppedBalloonId);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                balloonView.setVisibility(View.INVISIBLE);

                returnBalloonToOriginalSize(balloonView, animatorSet);

                mBalloonsOnScreen.set(changeBalloonOnScreenListNumber, mBalloonList.getBalloon(mBalloonList.getBalloonTracker()));

                balloonView.setImageResource(
                    mBalloonsOnScreen.get(changeBalloonOnScreenListNumber).getBalloonNonPoppedImageId());
            }
        }, 500);
    }

    /**
     * Starts the animation that makes the balloon bigger then pops it
     * @param balloonView - the balloon view to make bigger
     * @param poppedBalloonId - popped balloon Image view
     */
    private void makeBalloonBiggerThenPop(final ImageView balloonView, final int poppedBalloonId){
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(balloonView, "scaleX", 1.3f, 1.6f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(balloonView, "scaleY", 1.3f, 1.6f);

        AnimatorSet scaleAnim = new AnimatorSet();
        scaleAnim.setDuration(1000);
        scaleAnim.play(scaleX).with(scaleY);

        scaleAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                balloonView.setImageResource(poppedBalloonId);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        scaleAnim.start();
    }

    /**
     * returns the balloon to the original size
     *
     * @param balloonView - balloon view to turn visibility back on
     * @param animatorSet - float away animiation to start
     */
    private void returnBalloonToOriginalSize(final ImageView balloonView, final AnimatorSet animatorSet) {

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(balloonView, "scaleX", 1.6f, 1.3f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(balloonView, "scaleY", 1.6f, 1.3f);

        AnimatorSet scaleAnim = new AnimatorSet();
        scaleAnim.setDuration(100);
        scaleAnim.play(scaleX).with(scaleY);

        scaleAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animatorSet.start();
                balloonView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        scaleAnim.start();
    }

}
