package com.example.gabekeyner.project_2.Main_Menus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClass;
import com.example.gabekeyner.project_2.DataBaseCritera.DrinksClassHelper;
import com.example.gabekeyner.project_2.R;

public class MySelectionActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name_input;
    private EditText type_input;
    private EditText description;
    private EditText abv_input;
    private Button addDrink;
    private Button cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_selection);

        name_input = (EditText) findViewById(R.id.name_input);
        type_input = (EditText) findViewById(R.id.type_input);
        description = (EditText) findViewById(R.id.description);
        abv_input = (EditText) findViewById(R.id.abv_input);

        addDrink = (Button) findViewById(R.id.add_drink);
        cancel = (Button) findViewById(R.id.cancel_button);


        //Set onclicklisteners to buttons
        addDrink.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //set add_drink button to do save to db
            case R.id.add_drink:
                if (addDrinkToDb()) finish();
                break;
            //set cancel button to finish
            case R.id.cancel_button:
                finish();
                break;
        }
    }


    private boolean addDrinkToDb() {

        String alcoholType = type_input.getText().toString().trim();
        String name = name_input.getText().toString().trim();
        String desc = description.getText().toString().trim();

        //Dont let the drink to be saved if alcoholtype, name, description are empty.
        if (TextUtils.isEmpty(alcoholType)) {
            type_input.setError("Missing Alcohol Type");
            return false;
        }
        if (TextUtils.isEmpty(name)) {
            name_input.setError("Missing Name");
            return false;
        }
        if (TextUtils.isEmpty(desc)) {
            description.setError("Missing Name");
            return false;
        }

        //Set the ABV string to 0 if its empty
        String abvString = abv_input.getText().toString();
        double ABV = abvString.isEmpty() ? 0 : Integer.parseInt(abvString);


        //Instantiate a new Drink
        DrinksClass addedDrink = new DrinksClass(alcoholType, name, ABV, desc);

        DrinksClassHelper helper = new DrinksClassHelper(MySelectionActivity.this);

        //Save the Drink to the Database
        helper.addItem(addedDrink);


        Toast.makeText(MySelectionActivity.this, "Drink as been add to you Bar", Toast.LENGTH_LONG).show();
        return true;
    }
}
