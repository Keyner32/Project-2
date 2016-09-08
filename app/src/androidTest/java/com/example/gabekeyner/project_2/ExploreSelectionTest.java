package com.example.gabekeyner.project_2;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.gabekeyner.project_2.Main_Menus.ExploreSelection;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by GabeKeyner on 9/8/2016.
 */
@RunWith(AndroidJUnit4.class)
public class ExploreSelectionTest {

    @Rule
    public ActivityTestRule<ExploreSelection> mActivityRule = new ActivityTestRule<ExploreSelection>(ExploreSelection.class);

}
