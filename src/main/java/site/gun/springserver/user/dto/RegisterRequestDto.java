package site.gun.springserver.user.dto;

public record RegisterRequestDto(String email, String password, String name, String phone) {
}
