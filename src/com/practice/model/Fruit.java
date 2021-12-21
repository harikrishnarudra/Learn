package com.practice.model;

public class Fruit implements Cloneable {
    public Fruit(String name, String color) {
        this.fruitName = name;
        this.color = color;
    }

    private String fruitName;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String toString() {
        return "Name: " + this.getFruitName() + " color: " + this.getColor();
    }

    public Fruit clone() {
        Fruit newF = null;
        try {
             newF = (Fruit) super.clone();
        }catch (CloneNotSupportedException exception){
            exception.printStackTrace();
        }
        return newF;
    }

}
