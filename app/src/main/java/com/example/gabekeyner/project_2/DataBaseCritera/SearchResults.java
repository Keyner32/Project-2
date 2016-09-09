package com.example.gabekeyner.project_2.DataBaseCritera;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.example.gabekeyner.project_2.R;

public class SearchResults extends AppCompatActivity {

    public ListView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        //Call for intent
        handleIntent(getIntent());


        searchView = (ListView) findViewById(R.id.search_result);


    }


    //[*]TODO Search Bar
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
            //searchAll (query) lets the user search by any column
            Cursor cursor = DrinksClassHelper.getInstance(this).searchAll(query);

            String[] columns = new String[]{DrinksClassHelper.COL_NAME, DrinksClassHelper.COL_ABV, DrinksClassHelper.COL_DESCRIPTION};
            int[] viewNames = new int[]{R.id.list_item_name, R.id.list_item_ABV, R.id.list_item_description};
            CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(
                    SearchResults.this,
                    R.layout.list_item,
                    cursor,
                    columns,
                    viewNames,
                    0
            );


            ListView listView = (ListView) findViewById(R.id.search_result);
            listView.setAdapter(simpleCursorAdapter);

        }
    }

}
