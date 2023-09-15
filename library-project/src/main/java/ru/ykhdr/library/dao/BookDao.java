package ru.ykhdr.library.dao;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ykhdr.library.models.Book;

import java.util.List;

@AllArgsConstructor
@Component
public class BookDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(@NotNull Book book) {
        jdbcTemplate.update("INSERT INTO Book(name,author,release_year) VALUES (?,?,?)",
                book.getName(), book.getAuthor(), book.getReleaseYear());
    }
}
