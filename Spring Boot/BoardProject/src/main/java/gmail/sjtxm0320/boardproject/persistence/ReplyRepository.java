package gmail.sjtxm0320.boardproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gmail.sjtxm0320.boardproject.domain.Board;
import gmail.sjtxm0320.boardproject.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Modifying
    @Query("delete from Reply r where r.board.bno = :bno")
    void deleteByBno(@Param("bno") Long bnt);

    // 게시글을 이용해서 데이터 찾아오기
    List<Reply> findByBoardOrderByRno(Board board);
}
