package sg.edu.np.mad.week3t04;

import static sg.edu.np.mad.week3t04.R.id.textView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String TITLE ="Main Activity";
    boolean FollowedStatus = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create!");
        User myUser = new User();
        myUser.getDescription();
        myUser.getName();

        Intent myReceiveIntent = getIntent();
        Integer myReceiveInt = 0;
        myReceiveInt = myReceiveIntent.getIntExtra("integer", 0);
        Log.v(TITLE, "Received integer: " + myReceiveInt);

        TextView titleText = findViewById(R.id.textView);
        titleText.setText("MAD " + myReceiveInt);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TITLE, "On Pause!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "On Resume");

        Button messageButton = findViewById(R.id.button3);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_message_group);
            }
        });

        Button followButton =findViewById(R.id.button2);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "FollowButton pressed");
                if(FollowedStatus == true){
                    FollowedStatus = false;
                    followButton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Unfollowed!", Toast.LENGTH_SHORT).show();
                } else if (FollowedStatus == false) {
                    FollowedStatus = true;
                    followButton.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Followed!", Toast.LENGTH_SHORT).show();
                }

            }


        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy");
    }
}