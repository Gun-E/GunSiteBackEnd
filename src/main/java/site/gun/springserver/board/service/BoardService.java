package site.gun.springserver.board.service;

import site.gun.springserver.board.dto.CreateBoardDto;

public interface BoardService {
    void createBoard(CreateBoardDto board);
}
