package pl.jaz.pjatk.moveService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaz.pjatk.moveService.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Override
    List<Movie> findAll();

    @Override
    Optional<Movie> findById(Long aLong);

    @Override
    Movie save(Movie movie);

    @Override
    void delete(Movie movie);
}
