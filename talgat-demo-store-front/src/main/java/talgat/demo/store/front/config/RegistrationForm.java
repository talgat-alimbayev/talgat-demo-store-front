package talgat.demo.store.front.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import talgat.demo.store.front.model.User;

@Data
public class RegistrationForm {
      @NotBlank
      @Size(min = 5, message = "Слишком короткое имя пользователя (мин. 5)")
      private String username;
      @NotBlank
      @Size(min = 5, message = "Слишком короткий пароль (мин. 5)")
      private String password;

      @NotBlank
      @Size(min = 5, message = "Слишком короткое имя (мин. 5)")
      private String fullName;
      @NotBlank
      @Size(min = 5, message = "Слишком короткий адрес (мин. 5)")
      private String address;
      @NotBlank
      @Size(min = 5, message = "Слишком короткий имейл (мин. 5)")
      private String email;

//      public User toUser(){
//            return new User(username, password,
//                    fullName, address, email);
//      }

      public User toUser(PasswordEncoder passwordEncoder){
            return new User(username, passwordEncoder.encode(password),
                            fullName, address, email);
      }
}
