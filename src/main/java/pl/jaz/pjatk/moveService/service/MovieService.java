package pl.jaz.pjatk.moveService.service;

import org.springframework.stereotype.Service;
import pl.jaz.pjatk.moveService.exceptions.MovieNotFound;
import pl.jaz.pjatk.moveService.model.Movie;
import pl.jaz.pjatk.moveService.repository.MovieRepository;

import java.util.List;


@Service
public class MovieService {

    public final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFound::new);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
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

    public void isAvailable(Long id) {
        Movie movie = getMovieById(id);
        movie.setAvailable(true);
        saveMovie(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.delete(getMovieById(id));
    }
}
