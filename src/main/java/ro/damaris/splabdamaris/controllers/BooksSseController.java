package ro.damaris.splabdamaris.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.damaris.splabdamaris.observer.AllBooksSubject;
import ro.damaris.splabdamaris.observer.SseObserver;

@RestController
@RequiredArgsConstructor
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    @RequestMapping("/books-sse")
    public SseEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
        SseObserver observer = new SseObserver(emitter);
        allBooksSubject.attach(observer);

        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> allBooksSubject.detach(observer));
        emitter.onError(e -> allBooksSubject.detach(observer));

        return emitter;
    }
}