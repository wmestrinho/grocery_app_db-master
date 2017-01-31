package com.ironyard.data;

/**
 * Created by jasonskipper on 1/26/17.
 */
public class GroceryItem {
    private String name;
    private double price;
    private String cat;
    private int isle;
    private long id;

    public GroceryItem(){

    }

    public GroceryItem(String name, double price, String cat, int isle){
        this.name = name;
        this.isle = isle;
        this.price = price;
        this.cat = cat;
    }


    public GroceryItem(String name, double price, String cat, int isle, long id) {
        this.name = name;
        this.isle = isle;
        this.price = price;
        this.cat = cat;
        this.id = id;

    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCat() {return cat;}

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getIsle() {
        return isle;
    }

    public void setIsle(int isle) {
        this.isle = isle;
    }
    }
