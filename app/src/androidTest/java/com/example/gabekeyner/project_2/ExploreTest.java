package com.example.gabekeyner.project_2;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.gabekeyner.project_2.Main_Menus.Explore;

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
public class ExploreTest {

    @Rule
    public ActivityTestRule<Explore> mActivityRule = new ActivityTestRule<Explore>(Explore.class);

    //Tests for ExploreTest Activity
    @Test
    public void showBeers() throws Exception {
        onView(ViewMatchers.withId(R.id.beerBtn))
                .perform(click());

    }

    @Test
    public void showWines() throws Exception {
        onView(ViewMatchers.withId(R.id.wineBtn))
                .perform(click());

    }

    @Test
    public void showMixedDrinks() throws Exception {
        onView(ViewMatchers.withId(R.id.mixedDrinksBtn))
                .perform(click());

    }
//TODO FIX THIS TEST WHEN YOUR SEARCH BAR iS FINISED
    @Test
    public void enterSearchInput() throws Exception {
        onView(ViewMatchers.withId(R.id.search))
                .perform(click());
        onView(ViewMatchers.withId(R.id.search))
                .perform(clearText(), typeText("corona"), closeSoftKeyboard());

    }
}
