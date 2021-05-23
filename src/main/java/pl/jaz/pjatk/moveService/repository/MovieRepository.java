package pl.jaz.pjatk.moveService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaz.pjatk.moveService.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
