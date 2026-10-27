package ro.damaris.splabdamaris.commands;

import ro.damaris.splabdamaris.models.Book;
import ro.damaris.splabdamaris.services.BooksService;

public class AddBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book book;

    public AddBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        // Logica este delegată către Receiver (BooksService)
        return booksService.addBook(book);
    }
}