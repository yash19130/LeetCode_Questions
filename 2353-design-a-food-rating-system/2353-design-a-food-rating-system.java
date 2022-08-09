class FoodRatings 
{
    public Map<String, Integer> foodRating;
    public Map<String, String> foodCuisine;
    public Map<String, TreeMap<Integer, TreeSet<String>>> cuisineMap; 
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) 
    {
        this.foodRating = new HashMap<>();
        this.foodCuisine = new HashMap<>();
        this.cuisineMap = new HashMap<>();
        int n = foods.length;
        for(int i=0; i<n; i++)
        {
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            if(!cuisineMap.containsKey(cuisines[i]))
                cuisineMap.put(cuisines[i], new TreeMap<>());
            if(!cuisineMap.get(cuisines[i]).containsKey(ratings[i]))
                cuisineMap.get(cuisines[i]).put(ratings[i], new TreeSet<>());
            cuisineMap.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) 
    {
        int rating = foodRating.get(food);
        String cuisine = foodCuisine.get(food);
        cuisineMap.get(cuisine).get(rating).remove(food);
        if(cuisineMap.get(cuisine).get(rating).isEmpty())
            cuisineMap.get(cuisine).remove(rating);
        if(!cuisineMap.get(cuisine).containsKey(newRating))
            cuisineMap.get(cuisine).put(newRating, new TreeSet<>());
        cuisineMap.get(cuisine).get(newRating).add(food);
        foodRating.put(food, newRating);
    }
    
    public String highestRated(String cuisine) 
    {
        int highestRating = cuisineMap.get(cuisine).lastKey();
        return cuisineMap.get(cuisine).get(highestRating).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */