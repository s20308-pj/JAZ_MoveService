package pl.jaz.pjatk.moveService.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Integer rated;
    private boolean isAvailable;

    public Movie() {
        this.isAvailable = false;
    }

    public Movie(String name, Category category) {
        this.name = name;
        this.category = category;
        this.isAvailable = false;
    }

    public Movie(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = false;
    }

    public Movie(String name, Category category, Integer rated) {
        this.name = name;
        this.category = category;
        this.rated = rated;
        this.isAvailable = false;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getRated() {
        return rated;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRated(Integer rated) {
        this.rated = rated;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return isAvailable == movie.isAvailable
                && Objects.equals(id, movie.id)
                && Objects.equals(name, movie.name)
                && category == movie.category
                && Objects.equals(rated, movie.rated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, rated, isAvailable);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", rated=" + rated +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
