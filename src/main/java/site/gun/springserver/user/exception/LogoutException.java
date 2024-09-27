package site.gun.springserver.user.exception;

public final class LogoutException extends RuntimeException{
    public LogoutException(){
        super("로그아웃 에러");
    }
}
