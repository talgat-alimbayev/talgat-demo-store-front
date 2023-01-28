package talgat.demo.store.front.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;

@Data
@NoArgsConstructor
public class User implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String email;
    private String role;

    public User(String username, String password, String fullName, String address, String email, String role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.getRole().trim()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    // just for demo
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // just for demo
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // just for demo
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // just for demo
    @Override
    public boolean isEnabled() {
        return true;
    }
}
