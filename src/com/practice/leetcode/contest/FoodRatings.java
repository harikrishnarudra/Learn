package com.practice.leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FoodRatings {

    private Map<String, Map<String, Integer>> map = new HashMap<>();
    private Map<String, String> foodCuisineMap = new HashMap<>();
    private String[] foods;
    private String[] cuisines;
    private int[] ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        buildFoodRatingMapInit();
    }

    private void buildFoodRatingMapInit(){
        for (int i = 0; i < foods.length; i++) {
            String cuisine = cuisines[i];
            String food = foods[i];
            int rating = ratings[i];
            if (map.containsKey(cuisine)) {
                Map<String, Integer> foodRatingMap = map.get(cuisine);
                foodRatingMap.put(food, rating);
                map.put(cuisine, foodRatingMap);
            } else {
                Map<String, Integer> foodRatingMap = new HashMap<>();
                foodRatingMap.put(food, rating);
                map.put(cuisine, foodRatingMap);
            }
            foodCuisineMap.put(food, cuisine);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        Map<String, Integer> stringIntegerMap = map.get(cuisine);
        stringIntegerMap.put(food, newRating);
        map.put(cuisine, stringIntegerMap);
    }

    public String highestRated(String cuisine) {
        Map<String, Integer> stringIntegerMap = map.get(cuisine);
        List<String> foods = new ArrayList<>();
        int max = -1;
        for(Map.Entry<String, Integer> entry:stringIntegerMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                foods = new ArrayList<>();
                foods.add(entry.getKey());
            }
            if (entry.getValue() == max) {
                foods.add(entry.getKey());
            }
        }
        if(foods.size() > 1) {
            Collections.sort(foods);
        }
        return foods.get(0);
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese"));
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */