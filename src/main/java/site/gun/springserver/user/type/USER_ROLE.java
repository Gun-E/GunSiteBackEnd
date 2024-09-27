package site.gun.springserver.user.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum USER_ROLE {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    GUEST("ROLE_GUEST");

    private final String role;
}
