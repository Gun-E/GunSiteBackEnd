package site.gun.springserver.user.exception;

public final class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("아이디를 찾을 수 없습니다.");
    }
}
