package site.gun.springserver.board.service;

import org.springframework.data.domain.PageRequest;
import site.gun.springserver.board.dto.BoardDto;
import site.gun.springserver.board.dto.CreateBoardDto;
import java.util.List;

public interface BoardService {
    void createBoard(CreateBoardDto board);

    List<BoardDto> getBoards(String category, int limit);

    List<BoardDto> getBoardsList(String category, PageRequest pageRequest);

    int getTotalBoardsCount(String category);
}
