package site.gun.springserver.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import site.gun.springserver.entity.User;
import site.gun.springserver.user.domain.CustomUserDetails;
import site.gun.springserver.user.repository.UserRepository;
import site.gun.springserver.user.type.USER_ROLE;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrPhone(id, id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        if (user.getRole() == null || Objects.equals(user.getRole(), USER_ROLE.GUEST.toString())) {
            throw new IllegalArgumentException("사용자의 권한이 없습니다.");
        }

        Collection<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole()));

        return new CustomUserDetails(
                user.getUserId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                authorities
        );
    }
}