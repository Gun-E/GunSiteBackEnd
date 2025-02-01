package site.gun.springserver.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.gun.springserver.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
