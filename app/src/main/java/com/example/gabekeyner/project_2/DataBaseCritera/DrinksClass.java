package com.example.gabekeyner.project_2.DataBaseCritera;

/**
 * Created by GabeKeyner on 9/6/2016.
 */
public class DrinksClass {


    private String alcoholType;
    private String name;
    private Double ABV;
    private String description;

    public DrinksClass(String alcoholType, String name, Double ABV, String description) {


        this.alcoholType = alcoholType;
        this.name = name;
        this.ABV = ABV;
        this.description = description;
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
}