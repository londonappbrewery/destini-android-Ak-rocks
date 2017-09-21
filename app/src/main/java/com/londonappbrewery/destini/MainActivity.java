package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyTextView;
    private Button firstReplyButton;
    private Button secondReplyButton;
    private int currentStoryState = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        firstReplyButton = (Button) findViewById(R.id.buttonTop);
        secondReplyButton = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        firstReplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext()," 1 ", Toast.LENGTH_SHORT).show();
                if(currentStoryState == 1) {
                    updateStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                    currentStoryState = 3;
                }else if(currentStoryState == 2) {
                    updateStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                    currentStoryState = 3;

                }else if(currentStoryState == 3) {
                    updateStory(R.string.T6_End, R.string.T7_Nothing, R.string.T7_Nothing);
                    currentStoryState = 6;
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        secondReplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext()," 2 ", Toast.LENGTH_SHORT).show();
                if(currentStoryState == 1) {
                    updateStory(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                    currentStoryState = 2;
                }else if(currentStoryState == 2) {
                    updateStory(R.string.T4_End, R.string.T7_Nothing, R.string.T7_Nothing);
                    currentStoryState = 4;
                } else if(currentStoryState == 3) {
                    updateStory(R.string.T5_End, R.string.T7_Nothing, R.string.T7_Nothing);
                    currentStoryState = 5;
                }
            }
        });

    }

    private void updateStory(int Story, int Reply1, int Reply2) {
        if((Reply1 == R.string.T7_Nothing) || (Reply2 == R.string.T7_Nothing)) {
            storyTextView.setText(Story);
            firstReplyButton.setVisibility(View.INVISIBLE);
            secondReplyButton.setVisibility(View.INVISIBLE);
        } else {
            storyTextView.setText(Story);
            firstReplyButton.setText(Reply1);
            secondReplyButton.setText(Reply2);
        }
    }
}
