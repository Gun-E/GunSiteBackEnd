package site.gun.springserver.user.exception;

public class UserAlreadyExist extends RuntimeException{
    public UserAlreadyExist() {
        super("이미 존재 하는 유저 입니다");
    }
}
