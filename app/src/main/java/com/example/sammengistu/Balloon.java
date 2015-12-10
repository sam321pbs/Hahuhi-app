package com.example.sammengistu;

/**
 * Created by SamMengistu on 11/20/15.
 */
public class Balloon {

    private int mBalloonNonPoppedImageId;
    private int mAudioId;
    private int mAlphabetLetterNumber;
    private int mBalloonPoppedImageId;
    private String mBalloonLetter;

    public Balloon (int balloonNonPoppedImageId,
                    int balloonPoppedImageId,
                    int audioId, int alphabetLetterNumber,
                    String balloonLetter){
        this.mBalloonNonPoppedImageId = balloonNonPoppedImageId;
        this.mAudioId = audioId;
        this.mAlphabetLetterNumber = alphabetLetterNumber;
        this.mBalloonPoppedImageId = balloonPoppedImageId;
        mBalloonLetter = balloonLetter;
    }

    public int getBalloonNonPoppedImageId() {
        return mBalloonNonPoppedImageId;
    }

    public int getAudioId() {
        return mAudioId;
    }

    public int getAlphabetLetterNumber() {
        return mAlphabetLetterNumber;
    }

    public int getBalloonPoppedImageId (){
        return mBalloonPoppedImageId;
    }

    public String getBalloonLetter() {
        return mBalloonLetter;
    }
}
