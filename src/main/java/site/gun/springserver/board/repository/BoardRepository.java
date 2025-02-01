package site.gun.springserver.board.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.gun.springserver.board.dto.BoardDto;
import site.gun.springserver.entity.Board;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT new site.gun.springserver.board.dto.BoardDto(b.id, b.title, b.content, u.name, b.date) " +
            "FROM Board b JOIN b.user u " +
            "WHERE b.category = :category " +
            "ORDER BY b.date DESC")
    List<BoardDto> findTopByCategoryOrderByDateDesc(String category, Pageable pageable);

    int countByCategory(String category);
}
