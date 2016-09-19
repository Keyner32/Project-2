package com.example.gabekeyner.project_2.API;

import android.text.Selection;

import java.util.Arrays;

/**
 * Created by GabeKeyner on 9/18/2016.
 */
public class APISearchResult {
    Selection[] list;

    public Selection[] getList(){
        return list;
    }

    public void setList(Selection[] list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "APISearchResult{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
