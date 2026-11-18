package ro.damaris.splabdamaris.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.damaris.splabdamaris.Book;
import ro.damaris.splabdamaris.reporsitories.CrudRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final CrudRepository<Book, Long> booksRepository;

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return booksRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(updatedBook.getTitle());
            return booksRepository.save(existingBook);
        });
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }
}