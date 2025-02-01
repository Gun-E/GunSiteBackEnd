package site.gun.springserver.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import site.gun.springserver.board.dto.BoardDto;
import site.gun.springserver.board.dto.BoardListDto;
import site.gun.springserver.board.dto.CreateBoardDto;
import site.gun.springserver.board.service.BoardService;
import site.gun.springserver.entity.Board;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public List<BoardDto> getBoards(
            @RequestParam String category,
            @RequestParam(defaultValue = "5") int limit
    ) {
        return boardService.getBoards(category, limit);
    }

    @GetMapping("/boards/list")
    public List<BoardDto> getBoardsList(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return boardService.getBoardsList(category, pageRequest);
    }

    @PostMapping
    public void createBoard(@RequestBody CreateBoardDto board) {
        log.info("RegisterRequestDto: {}", board);
        boardService.createBoard(board);
    }

}