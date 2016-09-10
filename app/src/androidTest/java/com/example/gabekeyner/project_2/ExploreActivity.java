package com.example.gabekeyner.project_2;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.gabekeyner.project_2.Main_Menus.Explore;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by GabeKeyner on 9/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class ExploreActivity {
    @Rule
    public ActivityTestRule<Explore> mActivityRule = new ActivityTestRule<Explore>(Explore.class);



    @Test
    public void showBeers() throws Exception {

        onView(withId(R.id.beerBtn))
                .perform(click());

    }

    @Test
    public void showWines() throws Exception {


        onView(withId(R.id.wineBtn))
                .perform(click());

    }

    @Test
    public void showMixedDrinks() throws Exception {

        onView(withId(R.id.mixedDrinksBtn))
                .perform(click());

    }

}
