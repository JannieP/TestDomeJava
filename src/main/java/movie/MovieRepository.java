package movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute("CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), year int, rating int)");
    }

    public void createMovie(String name, int year, int rating) {
        String sql = "INSERT INTO movies (name, year, rating) VALUES (?, ?, ?)";
        template.update(sql, new Object[]{name, year, rating});
    }

    public List<Movie> findMoviesByName(String likeName) {
        String sql = "SELECT name, year, rating FROM movies WHERE name LIKE '" + likeName + "' ";
        List<Movie> movies = template.query(sql, (rs, rowNum) -> new Movie(rs.getString("name"), rs.getInt("year"), rs.getInt("rating")));
        return movies;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
        config.register(Config.class);
        config.refresh();
        MovieRepository repository = config.getBean(MovieRepository.class);

        repository.createMovie("Some movie", 1974, 3);
        repository.createMovie("Some other movie", 1993, 2);

        List<Movie> movies = repository.findMoviesByName("Some%");
        for(Movie movie : movies) {
            System.out.println(movie.name + " - " + movie.year + " - " + movie.rating);
        }
    }
}
