import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

class Movie {
    public String name;
    public int year;
    public int rating;

    public Movie(String name, int year, int rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }
}

@Repository
public class MovieRepository {

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute(
                "CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), year int, rating int)");
    }

    public void createMovie(String name, int year, int rating) {
        template.update("INSERT INTO movies (name, year, rating) VALUES (?,?,?)", name, year, rating);
    }

    public List<Movie> findMoviesByName(String nameStartsWith) {
        String sql = "SELECT * FROM movies WHERE name LIKE ?";
        return template.query(sql, new Object[] { nameStartsWith + "%" }, (rs, rowNum) -> new Movie(
                rs.getString("name"), rs.getInt("year"), rs.getInt("rating")));
    }
}
