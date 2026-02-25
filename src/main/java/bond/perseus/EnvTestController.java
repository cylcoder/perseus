package bond.perseus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvTestController {

  @Value("${spring.profiles.active:default}")
  private String profile;

  @GetMapping("/api/env")
  public String checkEnv() {
    return "Running on: " + profile.toUpperCase();
  }

}
