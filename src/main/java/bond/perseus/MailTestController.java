package bond.perseus;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailTestController {

  private final MailService mailService;

  @Value("${spring.profiles.active:default}")
  private String profile;

  @GetMapping("/api/mail")
  public void sendTestMail(String to) {
    String subject = "Test";
    String text = "SMTP test from " + profile.toUpperCase() + " environment";
    mailService.sendMail(to, subject, text);
  }

}
