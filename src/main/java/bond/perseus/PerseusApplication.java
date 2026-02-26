package bond.perseus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PerseusApplication {

  public static void main(String[] args) {
    SpringApplication.run(PerseusApplication.class, args);
  }

}
