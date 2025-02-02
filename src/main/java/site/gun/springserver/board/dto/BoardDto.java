package site.gun.springserver.board.dto;

import java.time.LocalDateTime;

public record BoardDto(Long boardId, String title, String content, String username, LocalDateTime date, String category) {
}
