package ro.damaris.splabdamaris;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ro.damaris.splabdamaris.reporsitories.BooksRepository;

@SpringBootApplication
public class SPlabDamarisApplication {

        public static void main(String[] args) {
                SpringApplication.run(SPlabDamarisApplication.class, args);
        }

        @Bean
        public WebMvcConfigurer corsConfigurer() {
                return new WebMvcConfigurer() {
                        @Override
                        public void addCorsMappings(CorsRegistry registry) {
                                registry.addMapping("/**");
                        }
                };
        }

        @Bean
        public CommandLineRunner initData(BooksRepository booksRepository) {
                return args -> {
                        Book book = new Book("Design Patterns in Java");
                        Author author = new Author("Gang of Four");
                        book.addAuthor(author);

                        Section cap1 = new Section("Capitolul 1");
                        cap1.add(new Paragraph("Acesta este primul paragraf salvat in H2."));
                        cap1.add(new Image("image1.png"));

                        book.addContent(cap1);

                        booksRepository.save(book);

                        System.out.println("========== Cartea a fost salvata in baza de date! ==========");
                };
        }
}