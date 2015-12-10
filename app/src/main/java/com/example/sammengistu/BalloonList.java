package com.example.sammengistu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import HahuhiGame.hahuhi.R;

/**
 * Created by SamMengistu on 11/20/15.
 */
public class BalloonList {

    private List<Balloon> mBalloonArrayList;
    private int mBalloonTracker;

    public BalloonList (){
        mBalloonTracker = 0;
        mBalloonArrayList = new ArrayList<>();
        addAllBalloons();

    }

    public int balloonTrackerNumber(){
        return mBalloonTracker;
    }

    public Balloon getBalloon (int i){
        return mBalloonArrayList.get(i);
    }

    public int getBalloonTracker() {
        if (mBalloonTracker == mBalloonArrayList.size()){
            mBalloonTracker = 0;
        }

        return mBalloonTracker++;
    }


    public int getBalloonAudio(int i){
        return mBalloonArrayList.get(i).getAudioId();
    }

    public int getBalloonNonPopped(int i){
        return mBalloonArrayList.get(i).getBalloonNonPoppedImageId();
    }

    public int getBalloonPopped(int i){
        return mBalloonArrayList.get(i).getBalloonPoppedImageId();
    }

    /**
     * sorts the letters alphabetically based on the number count
     * so it actually sorts it numerically
     */
    public void sortAlphabetically() {
        Collections.sort(mBalloonArrayList, new Comparator<Balloon>() {
            @Override
            public int compare(Balloon lhs, Balloon rhs) {
                Integer leftHand = lhs.getAlphabetLetterNumber();
                Integer rightHand = rhs.getAlphabetLetterNumber();

                return leftHand.compareTo(rightHand);

            }
        });
    }

    public void shuffleBalloons(){
        Collections.shuffle(mBalloonArrayList);
    }

    private void addAllBalloons(){
        Balloon balloon1 = new Balloon(R.drawable.ha_1, R.drawable.ha_1_crack, R.raw.ha_1, 1, "ha");
        Balloon balloon2 = new Balloon(R.drawable.hu_2, R.drawable.hu_2_crack, R.raw.hu_2, 2, "hu");
        Balloon balloon3 = new Balloon(R.drawable.he_3,R.drawable.he_3_crack, R.raw.he_3, 3, "he");
        Balloon balloon4 = new Balloon(R.drawable.haa_4, R.drawable.haa_4_crack, R.raw.haa_4, 4, "haa");
        Balloon balloon5 = new Balloon(R.drawable.hae_5, R.drawable.hae_5_crack, R.raw.hae_5, 5, "hae");
        Balloon balloon6 = new Balloon(R.drawable.hhe_6, R.drawable.hhe_6_crack, R.raw.hhe_6, 6, "hhe");
        Balloon balloon7 = new Balloon(R.drawable.ho_7, R.drawable.ho_7_crack, R.raw.ho_7, 7, "ho");
        Balloon balloon8 = new Balloon(R.drawable.le_8, R.drawable.le_8_crack, R.raw.le_8, 8, "le");
        Balloon balloon9 = new Balloon(R.drawable.lu_9, R.drawable.lu_9_crack, R.raw.lu_9, 9, "lu");
        Balloon balloon10 = new Balloon(R.drawable.lee_10, R.drawable.lee_10_crack, R.raw.lee_10, 10, "lee");
        Balloon balloon11 = new Balloon(R.drawable.la_11, R.drawable.la_11_crack, R.raw.la_11, 11, "la");
        Balloon balloon12 = new Balloon(R.drawable.lae_12, R.drawable.lae_12_crack, R.raw.lae_12, 12, "lae");
        Balloon balloon13 = new Balloon(R.drawable.lle_13, R.drawable.lle_13_crack, R.raw.lle_13, 13 , "lle");
        Balloon balloon14 = new Balloon(R.drawable.loo_14, R.drawable.loo_14_crack, R.raw.loo_14, 14, "loo");
        Balloon balloon15 = new Balloon(R.drawable.ha_ha_15, R.drawable.ha_ha_15_crack, R.raw.ha_ha_15, 15, "ha ha");
        Balloon balloon16 = new Balloon(R.drawable.ha_hu_16, R.drawable.ha_hu_16_crack, R.raw.ha_hu_16, 16, "ha hu");
        Balloon balloon17 = new Balloon(R.drawable.ha_he_17, R.drawable.ha_he_17_crack, R.raw.ha_he_17, 17, "ha he");
        Balloon balloon18 = new Balloon(R.drawable.ha_haa_18, R.drawable.ha_haa_18_crack, R.raw.ha_haa_18, 18, "ha haa");
        Balloon balloon19 = new Balloon(R.drawable.ha_hae_19, R.drawable.ha_hae_19_crack, R.raw.ha_hae_19, 19, "ha hae");



        mBalloonArrayList.add(balloon1);
        mBalloonArrayList.add(balloon2);
        mBalloonArrayList.add(balloon3);
        mBalloonArrayList.add(balloon4);
        mBalloonArrayList.add(balloon5);
        mBalloonArrayList.add(balloon6);
        mBalloonArrayList.add(balloon7);
        mBalloonArrayList.add(balloon8);
        mBalloonArrayList.add(balloon9);
        mBalloonArrayList.add(balloon10);
        mBalloonArrayList.add(balloon11);
        mBalloonArrayList.add(balloon12);
        mBalloonArrayList.add(balloon13);
        mBalloonArrayList.add(balloon14);
        mBalloonArrayList.add(balloon15);
        mBalloonArrayList.add(balloon16);
        mBalloonArrayList.add(balloon17);
        mBalloonArrayList.add(balloon18);
        mBalloonArrayList.add(balloon19);

    }


}
