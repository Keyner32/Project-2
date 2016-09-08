package com.example.gabekeyner.project_2.Main_Menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gabekeyner.project_2.R;

import java.util.List;


public class MyDrinks extends AppCompatActivity implements View.OnClickListener {

        private ListView addedDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drinks);

        //List view for user added drink

        addedDrink = (ListView) findViewById(R.id.result_drink);

        //Find FAB by ID

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(this);

    }
   @Override
    public void onClick(View v) {

       if (v == findViewById(R.id.fab)) {

           Intent intent = new Intent(this, MySelectionActivity.class);
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
