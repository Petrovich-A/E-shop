package by.petrovich.eshop.security;

import by.petrovich.eshop.entity.Order;
import by.petrovich.eshop.entity.Role;
import by.petrovich.eshop.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

public class CustomUserDetails extends User implements UserDetails {
    public CustomUserDetails(Integer userId,
                             String name,
                             String password,
                             String email,
                             LocalDate birthDate,
                             BigDecimal balance,
                             Set<Order> orders,
                             Role role) {
        super(userId, name, password, email, birthDate, balance, orders, role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
