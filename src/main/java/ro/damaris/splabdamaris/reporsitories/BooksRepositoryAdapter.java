package ro.damaris.splabdamaris.reporsitories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.damaris.splabdamaris.Book;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BooksRepositoryAdapter implements CrudRepository<Book, Long> {

    private final BooksRepository jpaRepository;

    @Override
    public List<Book> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Book save(Book entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}