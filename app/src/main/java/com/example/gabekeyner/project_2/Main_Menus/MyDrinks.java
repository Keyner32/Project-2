package com.example.gabekeyner.project_2.Main_Menus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClassHelper;
import com.example.gabekeyner.project_2.MainActivity;
import com.example.gabekeyner.project_2.R;


public class MyDrinks extends AppCompatActivity implements View.OnClickListener {

    CursorAdapter simpleCursorAdapter;
    private ListView addedDrink;
    Button menu_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drinks);



        //List view for user added drink

        addedDrink = (ListView) findViewById(R.id.result_drink);


        //Find FAB by ID

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(this);


//        DrinksClassHelper helper = new DrinksClassHelper(this);
//
//        //CREATE cursors
//
//        Cursor cursor = DrinksClassHelper.getInstance(MyDrinks.this).getUserDrinks();


        String[] columns = new String[]{DrinksClassHelper.COL_NAME, DrinksClassHelper.COL_ABV, DrinksClassHelper
                .COL_DESCRIPTION};
        int[] viewNames = new int[]{R.id.list_item_name, R.id.list_item_ABV, R.id.list_item_description};

        simpleCursorAdapter = new SimpleCursorAdapter(
                MyDrinks.this,
                R.layout.list_item,
                null,
                columns,
                viewNames,
                0
        );

        //Set adapter
        ListView listView = (ListView) findViewById(R.id.result_drink);


        //Simple Cursor Adapter
        listView.setAdapter(simpleCursorAdapter);


        //Set an onItemClickListener to the list view so that it starts a intent.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MyDrinks.this, ClickedDrinkItem.class);
                Cursor cursor = simpleCursorAdapter.getCursor();

                //Find the intent by it COL_ID
                cursor.moveToPosition(i);
                intent.putExtra("id", cursor.getInt(cursor.getColumnIndex(DrinksClassHelper.COL_ID)));
                startActivity(intent);

            }

            });

        //Menu Button

        Button menu_button = (Button)findViewById(R.id.menu_button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                MyDrinks.this.finish();

            }
        });

    }
// will run whenever activity is visible
    @Override
    protected void onStart() {
        DrinksClassHelper helper = new DrinksClassHelper(this);

        //CREATE cursors

        Cursor cursor = DrinksClassHelper.getInstance(MyDrinks.this).getUserDrinks();

        simpleCursorAdapter.changeCursor(cursor);

        super.onStart();
    }

    //On click on the Floating Action button for a new drink
    @Override
    public void onClick(View v) {

        if (v == findViewById(R.id.fab)) {

            Intent intent = new Intent(this, MyDrinkSelection.class);
            startActivity(intent);


        }

    }


}
