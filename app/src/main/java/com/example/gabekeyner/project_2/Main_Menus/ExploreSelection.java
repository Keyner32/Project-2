package com.example.gabekeyner.project_2.Main_Menus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClassHelper;
import com.example.gabekeyner.project_2.R;

public class ExploreSelection extends AppCompatActivity {


    public ListView DrinksListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_selection);


        //Intent from the three categories


        Intent intent = getIntent();
        String type = intent.getExtras().getString("type");


        //Instantiate subclass of SQLiteHelper

        DrinksClassHelper helper = new DrinksClassHelper(this);

        DrinksListView = (ListView) findViewById(R.id.list_view);


        //CREATE cursor

        Cursor cursor = DrinksClassHelper.getInstance(ExploreSelection.this).getAllDrinks(type);


        String[] columns = new String[]{DrinksClassHelper.COL_NAME, DrinksClassHelper.COL_ABV, DrinksClassHelper.COL_DESCRIPTION};
        int[] viewNames = new int[]{R.id.list_item_name, R.id.list_item_ABV, R.id.list_item_description};
        //Create Cursor Adapter
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

        Button menu_button = (Button) findViewById(R.id.menu_button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Explore.class);
                ExploreSelection.this.finish();

            }
        });

    }


}

