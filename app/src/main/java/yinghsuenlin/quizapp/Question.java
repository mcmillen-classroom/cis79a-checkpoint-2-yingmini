package yinghsuenlin.quizapp;

public class Question
{
    private int mTextResId;
    private int mHintTextResId;
    private boolean mAnswer;

    //This a constructor.

    public Question(int textResId, int hintTextResId, boolean answer) {
        mTextResId = textResId;
        mHintTextResId = hintTextResId;
        mAnswer = answer;
    }

    public int getHintTextResId() {
        return mHintTextResId;
    }

    public void setHintTextResId(int hintTextResId) {
        mHintTextResId = hintTextResId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
