package eu.bausov.projects.pump_selector.web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserRoleService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String rolesCommaSeparated) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        String[] roles = rolesCommaSeparated.split(",");
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.toUpperCase()));
        }

        return new User("anyUser", "", authorities);
    }
}
