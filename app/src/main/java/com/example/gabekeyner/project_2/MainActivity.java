package com.example.gabekeyner.project_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare your buttons

    Button myDrinksBtn;
    Button exploreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//TODO Set on click listener to your {My_drinks Button}
//TODO and {Explore Button} to start those separate activities


        myDrinksBtn = (Button) findViewById(R.id.my_drinks);
        myDrinksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyDrinks.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Welcome Back Old Friend", Toast.LENGTH_SHORT).show();

            }
        });


//have explore button start Explore Activity

        exploreBtn = (Button) findViewById(R.id.explore);
        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Explore.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Lets Find A New Drink", Toast
                        .LENGTH_SHORT)
                        .show();
            }
        });

    }
}
