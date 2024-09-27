package site.gun.springserver.user.service;


import site.gun.springserver.user.dto.EmailCheckDto;
import site.gun.springserver.user.dto.RegisterRequestDto;

public interface UserService {

    void register(RegisterRequestDto registerRequestDto);

    boolean emailDuplicateCheck(EmailCheckDto email);
}
