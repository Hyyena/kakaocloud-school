package gmail.sjtxm0320.boardproject.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gmail.sjtxm0320.boardproject.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository {
    // Board 데이터를 가져올 때 Author 정보도 가져오는 메서드
    @Query("select b, a from Board b left join b.author a where b.bno = :bno")
    public Object getBoardWithAuthor(@Param("bno") Long bno);

    // 글 번호를 받아서 Board 정보와 Board와 관련된 Reply 정보 차아오기
    // Board 1개에 여러 개의 Reply가 존재한다.
    // Board와 Reply가 결합한 형태의 목록으로 리턴
    @Query("select b, r from Board b left join Reply r on r.board = b where b.bno = :bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    // 게시글 목록, 작성자 정보, 댓글의 개수를 가져오는 메서드
    @Query("select b, a, count(r) from Board b left join b.author a left join Reply r on r.board = b group by b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);

    // 글번호를 가지고 데이터를 찾아오는 메서드
    @Query("select b, a, count(r) from Board b left join b.author a left outer join Reply r on r.board = b where b.bno = :bno")
    Object getBoardByBno(@Param("bno") Long bno);
}
