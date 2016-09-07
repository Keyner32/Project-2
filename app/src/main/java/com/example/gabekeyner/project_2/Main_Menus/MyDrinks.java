package com.example.gabekeyner.project_2.Main_Menus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gabekeyner.project_2.R;

public class MyDrinks extends AppCompatActivity implements View.OnClickListener {

    // Declare edit texts and buttons for user input dialog box


    private static final String BEER = "beer";
    private static final String WINE = "wine";
    private static final String MIXED_DRINK = "mixed drink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drinks);

        //Find the views by ID

        FloatingActionButton fab = (FloatingActionButton) findViewById()


//TODO set on click listeners to three categories
//TODO  Beer/Wine/Mixed Drinks(USE Switch Case

        Button beerBtn = (Button) findViewById(R.id.beerBtn);
        Button wineBtn = (Button) findViewById(R.id.wineBtn);
        Button mixedDrinkBtn = (Button) findViewById(R.id.mixedDrinksBtn);

        beerBtn.setOnClickListener(this);
        wineBtn.setOnClickListener(this);
        mixedDrinkBtn.setOnClickListener(this);
    }


}
/*    @Override
    public void onClick(View v) {

        String type = "";

        switch (v.getId()) {

            // show table that has to do everything with beer
            case R.id.beerBtn:

                type = BEER;
                break;


            // show table that has to do everything with wine
            case R.id.wineBtn:
                type = WINE;
                break;

            // show table that has to do everything with mixed drinks
            case R.id.mixedDrinksBtn:
                type = MIXED_DRINK;
                break;
        }
        Intent i = new Intent(this, ExploreSelection.class);
        i.putExtra("type", type);
        startActivity(i);
    }*/