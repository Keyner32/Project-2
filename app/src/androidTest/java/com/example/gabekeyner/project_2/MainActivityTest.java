package com.example.gabekeyner.project_2;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.gabekeyner.project_2.Main_Menus.Explore;
import com.example.gabekeyner.project_2.Main_Menus.MyDrinks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by GabeKeyner on 9/7/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

   @Rule
   public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);


   @Test
    public void menuButtonsClick() throws Exception {


       onView(ViewMatchers.withId(R.id.my_drinks))
               .perform(click());

       intended(hasComponent(MyDrinks.class.getName()))
                .check()


       onView(ViewMatchers.withId(R.id.beerBtn))
               .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));

    }

    @Test
    public void menuButtonsClick2() throws Exception{

        onView(ViewMatchers.withId(R.id.explore))
                .perform(click());

        intended(hasComponent(Explore.class.getName()));
    }


    @Test
    public void show

}
