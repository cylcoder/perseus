package bond.perseus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

  @Value("${spring.profiles.active:default}")
  private String profile;

  @Value("${server.port:8080}")
  private String port;

  @GetMapping("/api/env")
  public String checkEnv() {
    String containerId = System.getenv("HOSTNAME");
    return "Running on: " + profile.toUpperCase() + " (container ID: " + containerId + ")";
  }

  @GetMapping("/api/port")
  public String getPort() {
    return port;
  }

  @GetMapping("/api/slow")
  public void slow() throws InterruptedException {
    log.info("TestController.slow() started");
    Thread.sleep(15000);
    log.info("TestController.slow() finished");
  }

}
