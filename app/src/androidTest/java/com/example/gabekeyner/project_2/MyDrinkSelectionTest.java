package com.example.gabekeyner.project_2;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.gabekeyner.project_2.Main_Menus.MyDrinkSelection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;

/**
 * Created by GabeKeyner on 9/8/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MyDrinkSelectionTest {

    @Rule
    public ActivityTestRule<MyDrinkSelection> mActivityRule = new ActivityTestRule<MyDrinkSelection>(MyDrinkSelection.class);


    //Test for My Drink Selection Activity
    @Test
    public void inputDrinkData() throws Exception {
        onView(ViewMatchers.withId(R.id.name_input))
                .perform(click(),clearText(),typeText("new castle"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.type_input))
                .perform(click(),clearText(),typeText("beer"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.description))
                .perform(click(),clearText(),typeText("english brown ale, from nederland"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.abv_input))
                .perform(click(),clearText(),typeText("4"), closeSoftKeyboard());

    }
}
