package site.gun.springserver.board.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.gun.springserver.board.dto.BoardDto;
import site.gun.springserver.board.dto.CreateBoardDto;
import site.gun.springserver.board.repository.BoardRepository;
import site.gun.springserver.board.service.BoardService;
import site.gun.springserver.entity.Board;
import site.gun.springserver.entity.User;
import site.gun.springserver.user.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Override
    public void createBoard(CreateBoardDto boardDto) {
        String title = boardDto.title();
        String content = boardDto.content();
        String category = boardDto.category();
        LocalDateTime date = LocalDateTime.now();
        Long userId = boardDto.userId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        Board board = Board.builder()
                .title(title)
                .content(content)
                .category(category)
                .date(date)
                .user(user)
                .build();
        boardRepository.save(board);
    }

    @Override
    public List<BoardDto> getBoards(String category, int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return boardRepository.findTopByCategoryOrderByDateDesc(category, pageable);
    }

    @Override
    public List<BoardDto> getBoardsList(String category, PageRequest pageRequest) {
        return boardRepository.findTopByCategoryOrderByDateDesc(category, pageRequest);
    }

    @Override
    public int getTotalBoardsCount(String category) {
        return boardRepository.countByCategory(category);  // 카테고리에 해당하는 전체 게시물 수 반환
    }

    @Override
    public BoardDto getBoardById(Long boardId) {
        return boardRepository.findBoardById(boardId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다. ID: " + boardId));
    }
}
