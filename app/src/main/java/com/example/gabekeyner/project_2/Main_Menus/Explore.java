package com.example.gabekeyner.project_2.Main_Menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gabekeyner.project_2.R;

public class Explore extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        Button beerBtn = (Button) findViewById(R.id.beerBtn);
        Button wineBtn = (Button) findViewById(R.id.wineBtn);
        Button mixedDrinkBtn = (Button) findViewById(R.id.mixedDrinksBtn);

        beerBtn.setOnClickListener(this);
        wineBtn.setOnClickListener(this);
        mixedDrinkBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // show table that has to do everything with beer
            case R.id.beerBtn:
                Intent intent = new Intent(Explore.this, ExploreSelection.class);
                startActivity(intent);


            // show table that has to do everything with wine
            case R.id.wineBtn:
                Intent intent1 = new Intent(Explore.this, ExploreSelection.class);
                startActivity(intent1);


            // show table that has to do everything with mixed drinks
            case R.id.mixedDrinksBtn:
                Intent intent2 = new Intent(Explore.this, ExploreSelection.class);
                startActivity(intent2);

        }
    }


}
