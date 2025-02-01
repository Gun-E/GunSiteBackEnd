package site.gun.springserver.board.dto;

public record CreateBoardDto(String title, String content, String category, Long userId) {
}
