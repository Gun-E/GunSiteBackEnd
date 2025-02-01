package site.gun.springserver.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.gun.springserver.board.dto.BoardDto;
import site.gun.springserver.board.dto.CreateBoardDto;
import site.gun.springserver.board.service.BoardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<BoardDto> getBoards(
            @RequestParam String category,
            @RequestParam(defaultValue = "5") int limit
    ) {
        return boardService.getBoards(category, limit);
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getBoardsList(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        List<BoardDto> boardPage = boardService.getBoardsList(category, pageRequest);

        int totalBoards = boardService.getTotalBoardsCount(category);
        int totalPages = (int) Math.ceil((double) totalBoards / size);

        Map<String, Object> response = new HashMap<>();
        response.put("boards", boardPage);
        response.put("totalPages", totalPages);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public void createBoard(@RequestBody CreateBoardDto board) {
        log.info("RegisterRequestDto: {}", board);
        boardService.createBoard(board);
    }

}