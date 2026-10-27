package ro.damaris.splabdamaris.commands;

import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CommandExecutor {
    // Creăm un pool de thread-uri pentru a procesa comenzile asincron
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public void executeAsync(Command<?> command) {
        executor.submit(command::execute);
    }
}