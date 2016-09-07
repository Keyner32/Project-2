package com.example.gabekeyner.project_2.Main_Menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gabekeyner.project_2.R;

public class Explore extends AppCompatActivity implements View.OnClickListener {

    private static final String beer = "beer";
    private static final String wine = "wine";
    private static final String mixed_drink = "mixed drink";

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

                Intent b = new Intent(this, ExploreSelection.class);
                b.putExtra("beer", beer);
                startActivity(b);


                // show table that has to do everything with wine
            case R.id.wineBtn:

                Intent w = new Intent(this, ExploreSelection.class);
                w.putExtra("wine", wine);
                startActivity(w);


                // show table that has to do everything with mixed drinks
            case R.id.mixedDrinksBtn:

                Intent md = new Intent(this, ExploreSelection.class);
                md.putExtra("mixed drink", mixed_drink);
                startActivity(md);


        }
    }


}
