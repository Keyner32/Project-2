package com.example.gabekeyner.project_2.DataBaseCritera;

/**
 * Created by GabeKeyner on 9/6/2016.
 */
public class DrinksClass  {

    private int id;
    private String alcoholType;
    private String name;
    private Double ABV;
    private String description;

    public DrinksClass(int id, String alcoholType, String name, Double ABV, String description) {

        this.id = id;
        this.alcoholType = alcoholType;
        this.name = name;
        this.ABV = ABV;
        this.description = description;
    }


}