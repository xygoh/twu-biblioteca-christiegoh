package com.twu.biblioteca;

public class Rating {
    int rating;
    boolean unrated = false;

    public Rating(int rating) {
        this.rating = rating;
    }

    public Rating(String s){
        this.unrated = true; // if s == 'unrated'
    }

    public String getRating(){
        if(unrated == true){
            return "Unrated";
        }else{
            return Integer.toString(rating);
        }
    }
}
