package com.example.gabekeyner.project_2;

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

        handleIntent(getIntent());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

//            // show table that has to do everything with beer
//            case R.id.beerBtn:
//                Intent intent = new Intent(this, "put your universal class here for beeres");
//                startActivity(intent);
//                break;
//
//            // show table that has to do everything with wine
//            case R.id.wineBtn:
//                Intent intent1 = new Intent(this, "put your universal class here for wines");
//                startActivity(intent1);
//                break;
//
//            // show table that has to do everything with mixed drinks
//            case R.id.mixedDrinksBtn:
//                Intent intent2 = new Intent(this, "put your universal class here for mixed");
//                startActivity(intent2);
//                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(Explore.this,"Searching for "+query,Toast.LENGTH_SHORT).show();
        }
    }
}
