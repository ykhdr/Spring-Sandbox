package ru.ykhdr.library.dao;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ykhdr.library.models.Book;

import java.util.List;
import java.util.Optional;

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

    public Optional<Book> show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny();
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id = ?", id);
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET name=?,author=?,release_year=? WHERE id = ?",
                book.getName(), book.getAuthor(), book.getReleaseYear(), id);
    }

    public List<Book> booksByHolder(int holderId) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE holder_id = ?", new Object[]{holderId}, new BeanPropertyRowMapper<>(Book.class));
    }

    public void addHolder(int bookId, int holderId) {
        jdbcTemplate.update("UPDATE book SET holder_id = ? WHERE book_id = ?", holderId, bookId);
    }
}
