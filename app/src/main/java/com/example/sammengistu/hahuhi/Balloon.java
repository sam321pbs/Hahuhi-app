package com.example.sammengistu.hahuhi;

/**
 * Created by SamMengistu on 11/20/15.
 */
public class Balloon {

    private int mBalloonImageId;
    private int mAudioId;
    private int mAlphabetLetterNumber;

    public Balloon (int balloonImageId, int audioId, int alphabetLetterNumber){
        this.mBalloonImageId = balloonImageId;
        this.mAudioId = audioId;
        this.mAlphabetLetterNumber = alphabetLetterNumber;
    }

    public int getBalloonImageId() {
        return mBalloonImageId;
    }

    public int getAudioId() {
        return mAudioId;
    }

    public int getAlphabetLetterNumber() {
        return mAlphabetLetterNumber;
    }
}
