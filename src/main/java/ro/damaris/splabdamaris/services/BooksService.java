package ro.damaris.splabdamaris.services;

import org.springframework.stereotype.Service;
import ro.damaris.splabdamaris.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final List<Book> books = new ArrayList<>();
    private long idCounter = 1;

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBook(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public Book addBook(Book book) {
        book.setId(idCounter++);
        books.add(book);
        return book;
    }

    public Book updateBook(Long id, Book updatedBook) {
        return getBook(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return book;
        }).orElse(null);
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(b -> b.getId().equals(id));
    }
}