package ru.netology.cinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CinemaTest {

    @Test
    public void shouldFindAllAddedMovies() {
        CinemaManager manager = new CinemaManager();

        manager.addMovie("movie1");
        manager.addMovie("movie2");
        manager.addMovie("movie3");
        manager.addMovie("movie4");
        manager.addMovie("movie5");
        manager.addMovie("movie6");
        manager.addMovie("movie7");
        manager.addMovie("movie8");
        manager.addMovie("movie9");
        manager.addMovie("movie10");
        manager.addMovie("movie11");

        String[] actual = manager.findAll();
        String[] expected = {"movie11",
                "movie10",
                "movie9",
                "movie8",
                "movie7",
                "movie6",
                "movie5",
                "movie4",
                "movie3",
                "movie2",
                "movie1",
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastMoreThanLimit() {
        CinemaManager manager = new CinemaManager(3);
        manager.addMovie("movie1");
        manager.addMovie("movie2");
        manager.addMovie("movie3");
        manager.addMovie("movie4");
        manager.addMovie("movie5");
        manager.addMovie("movie6");

        String[] actual = manager.findLast(3);
        String[] expected = { "movie6", "movie5", "movie4" };

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastLimitEqualsLength() {
        CinemaManager manager = new CinemaManager(6);
        manager.addMovie("movie1");
        manager.addMovie("movie2");
        manager.addMovie("movie3");
        manager.addMovie("movie4");
        manager.addMovie("movie5");
        manager.addMovie("movie6");

        String[] actual = manager.findLast(6);
        String[] expected = { "movie6", "movie5", "movie4", "movie3", "movie2", "movie1" };

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastMoviesLessThanLimit() {
        CinemaManager manager = new CinemaManager(6);
        manager.addMovie("movie1");
        manager.addMovie("movie2");
        manager.addMovie("movie3");
        manager.addMovie("movie4");
        manager.addMovie("movie5");


        String[] actual = manager.findLast(6);
        String[] expected = {"movie5", "movie4", "movie3", "movie2", "movie1" };

        assertArrayEquals(expected, actual);
    }
}
