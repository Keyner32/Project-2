package com.example.gabekeyner.project_2;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by GabeKeyner on 9/7/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    //Tests for Main Activity


    @Test
    public void missingInput() throws Exception {


        onView(withId(R.id.my_drinks))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.name_input))
                .perform(click(), clearText(), typeText("Corona"), closeSoftKeyboard());
        onView(withId(R.id.type_input))
                .perform(click(), clearText(), closeSoftKeyboard());
        ;
        onView(withId(R.id.description))
                .perform(click(), clearText(), typeText("Mexican Beer known to be good with limes"), closeSoftKeyboard
                        ());
        onView(withId(R.id.abv_input))
                .perform(click(), clearText(), typeText("4"), closeSoftKeyboard());

        onView(withId(R.id.add_drink))
                .perform(click());

        onView(withId(R.id.type_input))
                .check(ViewAssertions.matches(hasErrorText("Missing Alcohol Type")));

    }

    @Test
    public void missingDescInput() throws Exception {


        onView(withId(R.id.my_drinks))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.name_input))
                .perform(click(), clearText(), typeText("805 Brew"), closeSoftKeyboard());
        onView(withId(R.id.type_input))
                .perform(click(), clearText(), typeText("Beer"), closeSoftKeyboard());
        onView(withId(R.id.description))
                .perform(click(), clearText(), closeSoftKeyboard());
        onView(withId(R.id.abv_input))
                .perform(click(), clearText(), typeText("4"), closeSoftKeyboard());

        onView(withId(R.id.add_drink))
                .perform(click());

        onView(withId(R.id.description))
                .check(ViewAssertions.matches(hasErrorText("Missing Description")));

    }

    @Test
    public void myDrinkButtonClick1() throws Exception {


        onView(withId(R.id.my_drinks))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.name_input))
                .perform(click(), clearText(), typeText("new castle"), closeSoftKeyboard());
        onView(withId(R.id.type_input))
                .perform(click(), clearText(), typeText("beer"), closeSoftKeyboard());
        onView(withId(R.id.description))
                .perform(click(), clearText(), typeText("english brown ale, from nederland"), closeSoftKeyboard());
        onView(withId(R.id.abv_input))
                .perform(click(), clearText(), typeText("4"), closeSoftKeyboard());
        onView(withId(R.id.add_drink))
                .perform(click());

    }

    @Test
    public void myDrinkButtonClick2() throws Exception {


        onView(withId(R.id.my_drinks))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.name_input))
                .perform(click(), clearText(), typeText("foster"), closeSoftKeyboard());
        onView(withId(R.id.type_input))
                .perform(click(), clearText(), typeText("beer"), closeSoftKeyboard());
        onView(withId(R.id.description))
                .perform(click(), clearText(), typeText("Australian"), closeSoftKeyboard());
        onView(withId(R.id.abv_input))
                .perform(click(), clearText(), typeText("4"), closeSoftKeyboard());
        onView(withId(R.id.add_drink))
                .perform(click());

    }

    @Test
    public void myDrinkButtonClick3() throws Exception {


        onView(withId(R.id.my_drinks))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.name_input))
                .perform(click(), clearText(), typeText("LA Water"), closeSoftKeyboard());
        onView(withId(R.id.type_input))
                .perform(click(), clearText(), typeText("mixed drink"), closeSoftKeyboard());
        onView(withId(R.id.description))
                .perform(click(), clearText(), typeText("vodka"), closeSoftKeyboard());
        onView(withId(R.id.abv_input))
                .perform(click(), clearText(), typeText("5"), closeSoftKeyboard());
        onView(withId(R.id.add_drink))
                .perform(click());

    }
    @Test
    public void myDrinkButtonClick() throws Exception {


        onView(withId(R.id.my_drinks))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.name_input))
                .perform(click(), clearText(), typeText("Adios Mother Fucker"), closeSoftKeyboard());
        onView(withId(R.id.type_input))
                .perform(click(), clearText(), typeText("mixed drink"), closeSoftKeyboard());
        onView(withId(R.id.description))
                .perform(click(), clearText(), typeText("alot of different liquors"), closeSoftKeyboard());
        onView(withId(R.id.abv_input))
                .perform(click(), clearText(), typeText("13"), closeSoftKeyboard());
        onView(withId(R.id.add_drink))
                .perform(click());

    }




}