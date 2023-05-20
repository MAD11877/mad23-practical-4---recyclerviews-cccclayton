package sg.edu.np.mad.week3t04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    final String TITLE = "ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> userList = new ArrayList<>();
        for(int i = 0; i<20; i++){
            Random number = new Random();
            Integer nameInt = number.nextInt(10000);
            String name = "Name" + nameInt;
            String description = new String(String.valueOf(number.nextInt(1000)));
            Boolean followed = number.nextBoolean();
            userList.add(new User(name, description, followed));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        MyAdapter myAdapter = new MyAdapter(userList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Random randInt = new Random();

                Integer myInt = randInt.nextInt(500);

                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                myIntent.putExtra("integer", myInt);
                startActivity(myIntent);

                setContentView(R.layout.activity_main);
            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });



//        imageView2.setOnClickListener(new View.OnClickListener(){
//        ImageView imageView2 = findViewById(R.id.imageView2);
//
//
//            @Override
//            public void onClick(View v) {
//                Log.v(TITLE, "Image pressed");
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
//        });





    }
}