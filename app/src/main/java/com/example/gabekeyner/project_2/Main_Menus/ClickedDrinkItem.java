package com.example.gabekeyner.project_2.Main_Menus;

import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClassHelper;
import com.example.gabekeyner.project_2.R;

public class ClickedDrinkItem extends AppCompatActivity {

    ListView listView;

    TextView titleView;
    TextView abvView;
    TextView descView;

    CursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_drink_item);

        final DrinksClassHelper helper = DrinksClassHelper.getInstance(ClickedDrinkItem.this);

        titleView = (TextView) findViewById(R.id.titleView);

        abvView = (TextView) findViewById(R.id.abvView);

        descView = (TextView) findViewById(R.id.descView);

        int id = getIntent().getIntExtra("id", -1);

        String title = helper.getTitleByID(id);
        String abv = helper.getAbvByID(id);
        String desc = helper.getDescByID(id);

        //get abv by id
        //get desc by id


        titleView.setText(title);
        abvView.setText(abv);
        descView.setText(desc);


    }
}
