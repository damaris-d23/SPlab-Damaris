package ro.damaris.splabdamaris.observer;

import org.springframework.stereotype.Component;
import ro.damaris.splabdamaris.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject {

    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private Book book;

    public void add(Book book) {
        this.book = book;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}