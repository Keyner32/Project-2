package com.example.gabekeyner.project_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyDrinks extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drinks);

//TODO set on click listeners to three categories
//TODO  Beer/Wine/Mixed Drinks(USE Switch Case

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
//
//            // show table that has saved beer choices
//            case R.id.beerBtn:
//                Intent intent = new Intent(this, "put your universal class here for beeres");
//                startActivity(intent);
//                break;
//
//            // show table that has saved wine choices
//            case R.id.wineBtn:
//                Intent intent1 = new Intent(this,"put your universal class here for wines");
//                startActivity(intent1);
//                break;
//
//            // show table that has saved mixed drinks choices
//            case R.id.mixedDrinksBtn:
//                Intent intent2 = new Intent(this,"put your universal class here for mixed" );
//                startActivity(intent2);
//                break;
        }
    }

}
