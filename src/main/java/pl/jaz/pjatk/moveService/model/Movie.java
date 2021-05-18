package pl.jaz.pjatk.moveService.model;


import java.util.Objects;

public class Movie {

    private Long id;
    private String name;
    private Category category;
    private Integer rated;

    public Movie() {
    }

    public Movie(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Movie(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Movie(String name, Category category, Integer rated) {
        this.name = name;
        this.category = category;
        this.rated = rated;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getRated() {
        return rated;
    }

    public void setRated(Integer rated) {
        this.rated = rated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return rated == movie.rated
                && Objects.equals(id, movie.id)
                && Objects.equals(name, movie.name)
                && Objects.equals(category, movie.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, rated);
    }

    @Override
    public String toString() {
        return "Move - " +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", category: " + category +
                ", rated: " + rated;
    }
}
