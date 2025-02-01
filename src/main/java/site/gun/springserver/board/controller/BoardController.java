package site.gun.springserver.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import site.gun.springserver.board.dto.CreateBoardDto;
import site.gun.springserver.board.service.BoardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
@Slf4j
public class BoardController {

    private final BoardService boardService;

//    // 게시글 전체 조회
//    @GetMapping
//    public ResponseEntity<List<Board>> getAllBoards() {
//        List<Board> boards = boardService.getAllBoards();
//        return new ResponseEntity<>(boards, HttpStatus.OK);
//    }

//    // 게시글 ID로 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
//        Optional<Board> board = boardService.getBoardById(id);
//        return board.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

//    // 게시글 제목으로 검색
//    @GetMapping("/search")
//    public ResponseEntity<List<Board>> searchBoards(@RequestParam String title) {
//        List<Board> boards = boardService.searchBoardsByTitle(title);
//        return new ResponseEntity<>(boards, HttpStatus.OK);
//    }

    // 게시글 생성
    @PostMapping
    public void createBoard(@RequestBody CreateBoardDto board) {
        log.info("RegisterRequestDto: {}",board);
        boardService.createBoard(board);
    }

//    // 게시글 수정
//    @PutMapping("/{id}")
//    public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board board) {
//        try {
//            Board updatedBoard = boardService.updateBoard(id, board);
//            return new ResponseEntity<>(updatedBoard, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // 게시글 삭제
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
//        try {
//            boardService.deleteBoard(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}