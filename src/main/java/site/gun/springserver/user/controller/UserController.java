package site.gun.springserver.user.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.gun.springserver.user.dto.EmailCheckDto;
import site.gun.springserver.user.dto.RegisterRequestDto;
import site.gun.springserver.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDto registerRequestDto) {
        log.info("RegisterRequestDto: {}", registerRequestDto);
        userService.register(registerRequestDto);
    }

    @PostMapping("/email-duplicate-check")
    public boolean checkDuplicateCheck(@RequestBody EmailCheckDto email) {
        log.info("EmailCheckDto: {}", email);
        return userService.emailDuplicateCheck(email);
    }
}
