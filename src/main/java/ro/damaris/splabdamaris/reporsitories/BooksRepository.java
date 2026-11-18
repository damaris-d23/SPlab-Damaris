package ro.damaris.splabdamaris.reporsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.damaris.splabdamaris.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
}