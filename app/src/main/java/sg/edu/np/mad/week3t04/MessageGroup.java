package sg.edu.np.mad.week3t04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    Button group1button, group2button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        final String TITLE = "MessageGroup";
        Button group1button = findViewById(R.id.group1);
        Button group2button = findViewById(R.id.group2);

        group1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Group1 Pressed");
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragContainer, new group1());
                ft.commit();
            }
        });

        group2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Group2 Pressed");
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragContainer, new group2());
            }
        });


    }
}