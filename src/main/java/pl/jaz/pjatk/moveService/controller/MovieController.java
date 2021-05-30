package pl.jaz.pjatk.moveService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jaz.pjatk.moveService.model.Movie;
import pl.jaz.pjatk.moveService.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovieById(id, movie));
    }

    @PutMapping("/{id}/isAvailable")
    public ResponseEntity<Void> isAvailable(@PathVariable Long id){
        movieService.isAvailable(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}

