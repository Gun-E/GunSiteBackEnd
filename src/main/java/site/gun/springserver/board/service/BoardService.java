package site.gun.springserver.board.service;

import org.springframework.data.domain.PageRequest;
import site.gun.springserver.board.dto.BoardDto;
import site.gun.springserver.board.dto.CreateBoardDto;
import site.gun.springserver.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    void createBoard(CreateBoardDto board);

    List<BoardDto> getBoards(String category, int limit);

    List<BoardDto> getBoardsList(String category, PageRequest pageRequest);
}
