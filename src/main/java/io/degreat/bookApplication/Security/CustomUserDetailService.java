package io.degreat.bookApplication.Security;

import io.degreat.bookApplication.Model.User;
import io.degreat.bookApplication.Service.Iservice.UserService;
import io.degreat.bookApplication.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService
                .findByUsername(username)
                .orElseThrow(
                        ()->new UsernameNotFoundException(username + "not found"));
        Set<GrantedAuthority> authorities =
                Set.of( SecurityUtils
                        .convertToAuthority(user.getRole().name()));

        return UserPrincipal.builder()
                .user(user).id(user.getUserId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
