package com.example.gabekeyner.project_2.Main_Menus;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gabekeyner.project_2.R;

public class Explore extends AppCompatActivity implements View.OnClickListener {

    private static final String BEER = "beer";
    private static final String WINE = "wine";
    private static final String MIXED_DRINK = "mixed drink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        handleIntent(getIntent());



        Button beerBtn = (Button) findViewById(R.id.beerBtn);
        Button wineBtn = (Button) findViewById(R.id.wineBtn);
        Button mixedDrinkBtn = (Button) findViewById(R.id.mixedDrinksBtn);

        beerBtn.setOnClickListener(this);
        wineBtn.setOnClickListener(this);
        mixedDrinkBtn.setOnClickListener(this);


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


    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(Explore.this, "Searching for " + query, Toast.LENGTH_SHORT).show();
//            if (mCursorAdapter != null) {
//                mCursorAdapter.swapCursor(searchCursor);
//                mCursorAdapter.notifyDataSetChanged();
//            }
        }
    }

}
