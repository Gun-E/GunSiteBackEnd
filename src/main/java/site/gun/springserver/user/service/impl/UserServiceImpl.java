package site.gun.springserver.user.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.gun.springserver.entity.User;
import site.gun.springserver.user.dto.EmailCheckDto;
import site.gun.springserver.user.dto.RegisterRequestDto;
import site.gun.springserver.user.exception.UserAlreadyExist;
import site.gun.springserver.user.repository.UserRepository;
import site.gun.springserver.user.service.UserService;
import site.gun.springserver.user.type.USER_ROLE;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void register(RegisterRequestDto registerDto) {
        if (userRepository.existsUserByEmailLike(registerDto.email())) {
            throw new UserAlreadyExist();
        }
        String name = registerDto.name();
        String email = registerDto.email();
        String password = registerDto.password();
        String phone = registerDto.phone();
        password = passwordEncoder.encode(password);

        User user = User.builder()
                .email(email)
                .password(password)
                .name(name)
                .role(USER_ROLE.USER.getRole())
                .phone(phone)
                .createdDate(LocalDateTime.now())
                .build();
        userRepository.save(user);
    }


    @Override
    public boolean emailDuplicateCheck(EmailCheckDto email) {
        return userRepository.existsUserByEmailLike(email.email());
    }

}
