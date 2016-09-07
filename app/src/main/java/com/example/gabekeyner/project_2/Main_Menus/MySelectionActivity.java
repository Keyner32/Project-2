package com.example.gabekeyner.project_2.Main_Menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.gabekeyner.project_2.R;

public class MySelectionActivity extends AppCompatActivity {

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

        name_input = (EditText)findViewById(R.id.name_input);
        type_input = (EditText)findViewById(R.id.type_input);
        description = (EditText)findViewById(R.id.description);
        abv_input = (EditText)findViewById(R.id.abv_input);
        addDrink = (Button)findViewById(R.id.add_drink);
        cancel = (Button)findViewById(R.id.cancel_button);

    }
}
