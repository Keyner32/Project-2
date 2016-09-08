package com.example.gabekeyner.project_2;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.gabekeyner.project_2.Main_Menus.MyDrinks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

/**
 * Created by GabeKeyner on 9/8/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MyDrinksTest {
    @Rule
    public ActivityTestRule<MyDrinks> mActivityRule = new ActivityTestRule<MyDrinks>(MyDrinks.class);


    //Test for My Drinks Activity

    @Test
    public void addDrink() throws Exception {
        onView(ViewMatchers.withId(R.id.fab))
                .perform(click());

    }
}
