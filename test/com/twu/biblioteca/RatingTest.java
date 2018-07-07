package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class RatingTest {
    @Test
    public void testLegalRatingInput(){
        Rating r = new Rating(5);
        assertEquals("5",r.getRating());
    }

    @Test
    public void testLegalRatingNoInput(){
        Rating r = new Rating();
        assertEquals("Unrated",r.getRating());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalRatingInput(){
        Rating r = new Rating(24);
    }
}