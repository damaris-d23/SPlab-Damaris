package ro.damaris.splabdamaris.commands;

public interface Command<T> {
    T execute();
}