package ro.damaris.splabdamaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ro.damaris.splabdamaris.difexamples.ClientComponent;
import ro.damaris.splabdamaris.difexamples.SingletonComponent;
import ro.damaris.splabdamaris.difexamples.TransientComponent;

@SpringBootApplication
public class SPlabDamarisApplication {

        public static void main(String[] args) {
                ApplicationContext context = SpringApplication.run(SPlabDamarisApplication.class, args);

                TransientComponent transientBean = context.getBean(TransientComponent.class);
                transientBean.operation();
                transientBean = context.getBean(TransientComponent.class);
                transientBean.operation();

                SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
                singletonBean.operation();
                singletonBean = context.getBean(SingletonComponent.class);
                singletonBean.operation();

                ClientComponent c = context.getBean(ClientComponent.class);
                c.operation();
                c = (ClientComponent) context.getBean("clientComponent");
                c.operation();
        }
}