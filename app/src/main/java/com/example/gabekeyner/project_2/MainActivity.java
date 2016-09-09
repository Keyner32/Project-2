package com.example.gabekeyner.project_2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gabekeyner.project_2.Main_Menus.Explore;
import com.example.gabekeyner.project_2.Main_Menus.MyDrinks;

/*TODO REQUIREMENTS
-[x]Have a theme and display data related to that theme:
    Great Gatsby
-[*]Allow the user to search by at least three different search criterias:
   for a shopping app: name,abv%, description.
-[*]Show results in separate entries/pages to the user, including :descriptions
-[*]Gather data for the search results from the database
-[*]Allow the user to add rows to a database, which they can view at any time:
    "Add a new Drinkk Floating Action Button"
-[*]Incorporate Object Oriented principles into your app
    DrinksClass:has gives each drink a Name , Type of Alcohol,ABV%, Description.
-[*]Contain code comments, explaining the functionality behind sections of code
-[*]Include at least 4 user stories in the readme.md
-[*]Include espresso tests for your app
-[*]Ensure that you add a sufficient number of tests for the features of each screen of your app

Bonus:
-[]Use relationships between tables (highly recommended)
    e.g. create a review system for user feedback for each item (second table)
-[]Incorporate Square's Picasso photo library
-[]Incorporate Material Design principles into your app
-[]Add more complexity to the user's searches (possibly allowing more than one search criteria at a time)
-[]Add JUnit tests for your non-Android classes (i.e. not Activity or Fragment)


 */

public class MainActivity extends AppCompatActivity {

    //Declare your buttons

    Button myDrinksBtn;
    Button exploreBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MediaPlayer playMusic = MediaPlayer.create(this, R.raw.alittle_party);

        playMusic.start();

//[*] TODO Set on click listener to your {My_drinks Button}


        myDrinksBtn = (Button) findViewById(R.id.my_drinks);
        myDrinksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyDrinks.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Welcome Back Old Friend", Toast.LENGTH_SHORT).show();

            }
        });

//[*] TODO  and {Explore Button} to start those separate activities


        exploreBtn = (Button) findViewById(R.id.explore);
        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Explore.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Lets Find A New Drink", Toast
                        .LENGTH_SHORT)
                        .show();
            }
        });

    }
}
