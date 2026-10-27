package ro.damaris.splabdamaris.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.damaris.splabdamaris.commands.AddBookCommand;
import ro.damaris.splabdamaris.commands.Command;
import ro.damaris.splabdamaris.commands.CommandExecutor;
import ro.damaris.splabdamaris.models.Book;
import ro.damaris.splabdamaris.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor commandExecutor; // Injectăm noul executor

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    // Varianta Sincronă (ce ai testat mai devreme)
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Command<Book> command = new AddBookCommand(booksService, book);
        Book createdBook = command.execute();
        return ResponseEntity.ok(createdBook);
    }

    // Varianta Asincronă (Nouă)
    @PostMapping("/async")
    public ResponseEntity<String> createBookAsync(@RequestBody Book book) {
        Command<Book> command = new AddBookCommand(booksService, book);

        // Trimitem comanda spre procesare în fundal
        commandExecutor.executeAsync(command);

        // Răspundem IMEDIAT clientului că cererea a fost acceptată (Cod 202)
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Comanda de adăugare a cărții a fost preluată și se procesează asincron.");
    }
}