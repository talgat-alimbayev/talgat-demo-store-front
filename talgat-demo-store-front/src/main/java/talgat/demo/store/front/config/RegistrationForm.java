package talgat.demo.store.front.config;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import talgat.demo.store.front.model.User;

@Data
public class RegistrationForm {
      @Size(min = 5, message = "Слишком короткое имя пользователя (мин. 5)")
      private String username;
      @Size(min = 5, message = "Слишком короткий пароль (мин. 5)")
      private String password;

      @Size(min = 5, message = "Слишком короткое имя (мин. 5)")
      private String fullName;
      @Size(min = 5, message = "Слишком короткий адрес (мин. 5)")
      private String address;
      @Size(min = 5, message = "Слишком короткий имейл (мин. 5)")
      private String email;
      public User toUser(PasswordEncoder passwordEncoder){
            return new User(username, passwordEncoder.encode(password),
                            fullName, address, email);
      }
}
