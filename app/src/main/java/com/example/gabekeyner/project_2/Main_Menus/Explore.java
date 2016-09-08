package com.example.gabekeyner.project_2.Main_Menus;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClassHelper;
import com.example.gabekeyner.project_2.R;

public class Explore extends AppCompatActivity implements View.OnClickListener {

    private static final String BEER = "beer";
    private static final String WINE = "wine";
    private static final String MIXED_DRINK = "mixed drink";


    public DrinksClassHelper helper;
    private ListView mSearchBarView;
    private CursorAdapter mCursorAdapter;



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



        mSearchBarView = (ListView) findViewById(R.id.search_bar);

    }



    @Override
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
    }


    //TODO Search Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        return true;
    }


}
