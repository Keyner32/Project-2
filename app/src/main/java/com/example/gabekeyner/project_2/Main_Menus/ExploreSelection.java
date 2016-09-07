package com.example.gabekeyner.project_2.Main_Menus;

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
import android.widget.Toast;

import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClassHelper;
import com.example.gabekeyner.project_2.R;

public class ExploreSelection extends AppCompatActivity {

    private CursorAdapter mCursorAdapter;
    private DrinksClassHelper mHelper;
    private ListView DrinksListView;
    public String title = "Search Result";


    //    private Cursor cursor;
//    private Cursor searchCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_selection);




        //Intent from the three categories

        handleIntent(getIntent());

        Intent intent = getIntent();
        String type = intent.getExtras().getString("type");





        //Instantiate subclass of SQLiteHelper

        DrinksClassHelper helper = new DrinksClassHelper(this);

        DrinksListView = (ListView) findViewById(R.id.list_view);


        //CREATE cursor

        Cursor cursor = DrinksClassHelper.getInstance(ExploreSelection.this).getAllDrinks(type);


        String[] columns = new String[]{DrinksClassHelper.COL_NAME, DrinksClassHelper.COL_ABV, DrinksClassHelper.COL_DESCRIPTION};
        int[] viewNames = new int[]{R.id.list_item_name, R.id.list_item_ABV, R.id.list_item_description};
        CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(
                ExploreSelection.this,
                R.layout.list_item,
                cursor,
                columns,
                viewNames,
                0
        );

        //Set adapter
        ListView listView = (ListView) findViewById(R.id.list_view);


        //Simple Cursor Adapter
        listView.setAdapter(simpleCursorAdapter);


//        if (!Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
//            Intent i = getIntent();
//            if (i.getStringExtra("type") != null) {
//                title = i.getStringExtra("type").toString();
//
//                cursor = mHelper.getBeers(title);
//                ((TextView) findViewById(R.id.textView)).setText(title.toString().toUpperCase());
//            }
//
//        }

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
            Toast.makeText(ExploreSelection.this, "Searching for " + query, Toast.LENGTH_SHORT).show();
//            if (mCursorAdapter != null) {
//                mCursorAdapter.swapCursor(searchCursor);
//                mCursorAdapter.notifyDataSetChanged();
//            }
        }
    }
}

