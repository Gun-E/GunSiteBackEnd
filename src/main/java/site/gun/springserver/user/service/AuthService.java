package site.gun.springserver.user.service;


import site.gun.springserver.user.domain.CustomUserDetails;

public interface AuthService {
    String generateToken(CustomUserDetails authentication);

    void logout(String token);
}
