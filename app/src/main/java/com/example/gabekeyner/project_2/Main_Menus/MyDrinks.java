package com.example.gabekeyner.project_2.Main_Menus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClassHelper;
import com.example.gabekeyner.project_2.R;

import java.util.List;


public class MyDrinks extends AppCompatActivity implements View.OnClickListener {

        CursorAdapter simpleCursorAdapter;
        private ListView addedDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drinks);


        String namePlacer = "Name : ";
        String abvPlacer  = "ABV% : ";
        String descriptionPlacer  = "Description : ";
//
//        String nameLayout = namePlacer + DrinksClassHelper.COL_NAME;
//        String abvLayout = abvPlacer + DrinksClassHelper.COL_ABV;
//        String descriptionLayout = descriptionPlacer + DrinksClassHelper.COL_DESCRIPTION;



        //List view for user added drink

        addedDrink = (ListView) findViewById(R.id.result_drink);
//        namePlacer =

        //Find FAB by ID

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(this);

        DrinksClassHelper helper = new DrinksClassHelper(this);


        //CREATE cursors

        Cursor cursor = DrinksClassHelper.getInstance(MyDrinks.this).getUserDrinks();


        String[] columns = new String[]{DrinksClassHelper.COL_NAME, DrinksClassHelper.COL_ABV, DrinksClassHelper
                .COL_DESCRIPTION};
        int[] viewNames = new int[]{R.id.list_item_name, R.id.list_item_ABV, R.id.list_item_description};

        simpleCursorAdapter = new SimpleCursorAdapter(
                MyDrinks.this,
                R.layout.list_item,
                cursor,
                columns,
                viewNames,
                0
        );

        //Set adapter
        ListView listView = (ListView) findViewById(R.id.result_drink);



        //Simple Cursor Adapter
        listView.setAdapter(simpleCursorAdapter);



//TODO add cutsom back button press
        //TODO add cutsom back button press
        //TODO add cutsom back button press
        //TODO add cutsom back button press




    }

   @Override
    public void onClick(View v) {

       if (v == findViewById(R.id.fab)) {

           Intent intent = new Intent(this, MyDrinkSelection.class);
           startActivity(intent);


       }

   }

    private void updateList(List<String> newList) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MyDrinks.this,
                android.R.layout.simple_list_item_1,
                newList
        );

        addedDrink.setAdapter(adapter);

    }

}
