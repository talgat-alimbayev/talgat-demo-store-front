package talgat.demo.store.front.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Data
@Table("users")
public class User implements UserDetails {
    @Id
    private Long id;
    private final String username;
    private final String password;
    private final String fullName;
    private final String address;
    private final String email;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
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
