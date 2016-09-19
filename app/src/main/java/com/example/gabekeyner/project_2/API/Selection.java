package com.example.gabekeyner.project_2.API;

/**
 * Created by GabeKeyner on 9/18/2016.
 */
public class Selection {
    private String drinkName;
    private String alcoholType;
    private Float abvPercent;
    private String drinkDescription;


    public String getDrinkName() {
        return drinkName;
    }

    public String getAlcoholType() {
        return alcoholType;
    }

    public Float getAbvPercent() {
        return abvPercent;
    }

    public String getDrinkDescription() {
        return drinkDescription;
    }

    @Override
    public String toString() {
        return "\"One of many drinks is a :" +
                "drinkName='" + drinkName + '\'' +
                ", alcoholType='" + alcoholType + '\'' +
                ", abvPercent=" + abvPercent +
                ", drinkDescription='" + drinkDescription + '\'' +
                '}';
    }
}

/*  drinkName: String,
    alcoholType: String,
    abvPercent: Number,
    drinkDescription: String
    */
