package site.gun.springserver.board.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.gun.springserver.board.dto.BoardDto;
import site.gun.springserver.entity.Board;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT new site.gun.springserver.board.dto.BoardDto(b.id, b.title, b.content, u.name, b.date, b.category) " +
            "FROM Board b JOIN b.user u " +
            "WHERE b.category = :category " +
            "ORDER BY b.date DESC")
    List<BoardDto> findTopByCategoryOrderByDateDesc(String category, Pageable pageable);

    int countByCategory(String category);

    @Query("SELECT new site.gun.springserver.board.dto.BoardDto( " +
            "b.id, b.title, b.content, u.name, b.date, b.category) " +
            "FROM Board b JOIN b.user u WHERE b.id = :boardId")
    Optional<BoardDto> findBoardById(@Param("boardId") Long boardId);
}
