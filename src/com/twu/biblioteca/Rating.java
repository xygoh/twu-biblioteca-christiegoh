package com.twu.biblioteca;

public class Rating {
    int rating;
    boolean unrated = false;

    public Rating(int rating) {
        if (isValid(rating)) {
            this.rating = rating;
        }else{
            System.out.println("Ratings between 1 - 10 only");
            throw new IllegalArgumentException();
        }
    }

    public Rating(){
        this.unrated = true;
    }

    public String getRating(){
        if(unrated == true){
            return "Unrated";
        }else{
            return Integer.toString(rating);
        }
    }

    private static boolean isValid(int rating){
        if (rating < 1 || rating > 10){
            return false;
        }
        return true;
    }
}
