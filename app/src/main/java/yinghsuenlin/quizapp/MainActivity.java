package yinghsuenlin.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mpreButton;
    private ImageButton mNextButton;
    private Button mHintButton;

    private Question[] mQuestions;
    private int mIndex;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mpreButton = (ImageButton) findViewById(R.id.pre_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mHintButton = (Button) findViewById(R.id.hint_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mpreButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.text_view);

        mQuestions = new Question[5];
        mIndex = 0;

        mQuestions[0] = new Question(R.string.question_1, R.string.question_1_hint, true);
        mQuestions[1] = new Question(R.string.question_2, R.string.question_2_hint, true);
        mQuestions[2] = new Question(R.string.question_3, R.string.question_3_hint, false);
        mQuestions[3] = new Question(R.string.question_4, R.string.question_4_hint, true);
        mQuestions[4] = new Question(R.string.question_5, R.string.question_5_hint, false);

        mTextView.setText(mQuestions[mIndex].getTextResId());
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.true_button) {
            checkAnswer(true);
        }

        else if(view.getId() == R.id.false_button) {
            checkAnswer(false);
        }

        else if(view.getId() == R.id.pre_button) {
            mIndex--;

            if(mIndex >= 0)
            {
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
        }

        else if(view.getId() == R.id.next_button) {
            //Change to the next question...

            //Increment the index by one.
            mIndex++;

            // DO IF STATEMENT HERE:
            // if the mIndex is greater than or equal to mQuestion.length
            if(mIndex < mQuestions.length)
            {
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
            //  - set mIndex to 0
            //  - end the quiz

            //Change text in view
        }

        else if(view.getId() == R.id.hint_button)
        {
            Toast myToast = Toast.makeText(this, mQuestions[mIndex].getHintTextResId(), Toast.LENGTH_LONG);
            myToast.setGravity(Gravity.TOP, 0, 180);
            myToast.show();
        }
    }

    public boolean checkAnswer(boolean userInput)
    {
        if(mQuestions[mIndex].getAnswer() == userInput)
        {
            Toast myToast = Toast.makeText(this, "You are correct!", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP, 0, 180);
            myToast.show();
            return true;
        }
        else
        {
            Toast myToast = Toast.makeText(this, "You are incorrect!", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP, 0, 180);
            myToast.show();
            return false;
        }
    }
}
