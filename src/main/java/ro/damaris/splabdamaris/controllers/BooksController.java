package ro.damaris.splabdamaris.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.damaris.splabdamaris.Book;
import ro.damaris.splabdamaris.commands.AddBookCommand;
import ro.damaris.splabdamaris.commands.Command;
import ro.damaris.splabdamaris.commands.CommandExecutor;
import ro.damaris.splabdamaris.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor commandExecutor;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return booksService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Command<Book> command = new AddBookCommand(booksService, book);
        return ResponseEntity.ok(command.execute());
    }

    @PostMapping("/async")
    public ResponseEntity<String> createBookAsync(@RequestBody Book book) {
        Command<Book> command = new AddBookCommand(booksService, book);
        commandExecutor.executeAsync(command);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Comanda a fost preluata asincron.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return booksService.updateBook(id, book)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        booksService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}