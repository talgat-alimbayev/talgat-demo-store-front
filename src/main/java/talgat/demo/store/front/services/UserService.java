package talgat.demo.store.front.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import talgat.demo.store.front.model.User;

import java.util.Optional;

@Service
public class UserService {
    private RestTemplate rest;

    public UserService(RestTemplate rest) {
        this.rest = rest;
    }

    public Optional<User> findByUsername(String username){
        ResponseEntity<User> user = rest.
                getForEntity("http://localhost:8080/api/users/find-by-username?username={username}",
                             User.class, username);
        if (user.getBody() != null){
            return Optional.of(user.getBody());
        }
        return Optional.empty();
    }

    public User saveUser(User user){
        return rest.postForObject("http://localhost:8080/api/users/new-user", user, User.class);
    }
}
