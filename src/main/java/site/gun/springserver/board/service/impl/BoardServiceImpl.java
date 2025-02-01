package site.gun.springserver.board.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.gun.springserver.board.dto.CreateBoardDto;
import site.gun.springserver.board.repository.BoardRepository;
import site.gun.springserver.board.service.BoardService;
import site.gun.springserver.entity.Board;
import site.gun.springserver.entity.User;
import site.gun.springserver.user.repository.UserRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Override
    public void createBoard(CreateBoardDto boardDto) {
        String title = boardDto.title();
        String content = boardDto.content();
        LocalDateTime date = LocalDateTime.now();
        Long userId = boardDto.userId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        Board board = Board.builder()
                .title(title)
                .content(content)
                .date(date)
                .user(user)
                .build();
        boardRepository.save(board);
    }
}
