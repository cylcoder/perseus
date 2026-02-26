package bond.perseus;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

  @Value("${spring.mail.username}")
  private String username;

  private final JavaMailSender mailSender;

  @Async
  public void sendMail(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(username);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    mailSender.send(message);
  }

}
