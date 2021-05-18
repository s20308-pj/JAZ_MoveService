package pl.jaz.pjatk.moveService.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.jaz.pjatk.moveService.exceptions.MovieNotFound;
import pl.jaz.pjatk.moveService.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static pl.jaz.pjatk.moveService.model.Category.ACTION;
import static pl.jaz.pjatk.moveService.model.Category.COMEDY;
import static pl.jaz.pjatk.moveService.model.Category.CRIME;
import static pl.jaz.pjatk.moveService.model.Category.FANTASY;
import static pl.jaz.pjatk.moveService.model.Category.HORROR;
import static pl.jaz.pjatk.moveService.model.Category.SCI_FI;


@Service
public class MovieService {

    private final List<Movie> movieList = new ArrayList<Movie>();

    public MovieService() {
        movieList.add(new Movie(1L, "The Lord of the Rings: The Fellowship of the Ring", FANTASY));
        movieList.add(new Movie(2L, "Shinning", HORROR));
        movieList.add(new Movie(3L, "Fight Club", ACTION));
        movieList.add(new Movie(4L, "Forest Gump", COMEDY));
        movieList.add(new Movie(5L, "Star Wars", SCI_FI));
        movieList.add(new Movie(6L, "Last Man Standing", CRIME));
    }

    public Movie getMovieById(Long id) {
        Movie movie = movieList.stream().filter(lookingMovie -> lookingMovie.getId().equals(id)).findFirst().orElse(null);
        if (movie == null) {
            throw new MovieNotFound();
        }
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }

    public Movie saveMovie(Movie movie) {
        movieList.add(movie);
        return movie;
    }

    public Movie updateMovieById(Long id, Movie movie) {
        Movie movieToUpdate = getMovieById(id);
        if (movie.getName() != null) {
            movieToUpdate.setName((movie.getName()));
        }
        if (movie.getCategory() != null) {
            movieToUpdate.setCategory(movie.getCategory());
        }
        if (movie.getRated() != null) {
            movieToUpdate.setRated(movie.getRated());
        }
        return saveMovie(movieToUpdate);
    }

    public void deleteMovie(Long id) {
        movieList.remove(getMovieById(id));
    }
}
