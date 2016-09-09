package com.example.gabekeyner.project_2.DataBaseCritera;

/**
 * Created by GabeKeyner on 9/6/2016.
 */
public class DrinksClass {


    //Object Oriented Programming = Drink

    private String alcoholType;
    private String name;
    private Double ABV;
    private String description;
    private String user_drink;

    public DrinksClass(String alcoholType, String name, Double ABV, String description,String user_drink) {

        this.alcoholType = alcoholType;
        this.name = name;
        this.ABV = ABV;
        this.description = description;
        this.user_drink = user_drink;
    }

    public String getAlcoholType() {
        return alcoholType;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Double getABV() {
        return ABV;
    }

    public String getUser_drink() {
        return user_drink;
    }
}