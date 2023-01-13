package gmail.sjtxm0320.boardproject.persistence;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gmail.sjtxm0320.boardproject.domain.Board;
import gmail.sjtxm0320.boardproject.domain.Reply;

@SpringBootTest
class ReplyRepositoryTest {
    @Autowired
    private ReplyRepository replyRepository;

    // 댓글 데이터 삽입
    @Test
    public void insertReply() {
        for (int i = 1; i <= 300; i++) {
            long bno = (long)(Math.random() * 100) + 1;

            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder().text("Reply..." + i).board(board).replyer("guest").build();

            replyRepository.save(reply);
        }
    }

    // 댓글 1개를 가져오는 메서드
    @Test
    @Transactional
    public void readReply() {
        Optional<Reply> result = replyRepository.findById(101L);

        Reply reply = result.get();
        System.out.println(reply);
        System.out.println(reply.getBoard());
    }

    // 댓글을 가져오는 메서드 확인
    @Test
    public void testListReply() {
        List<Reply> replyList = replyRepository.findByBoardOrderByRno(Board.builder().bno(50L).build());

        replyList.forEach(reply -> System.out.println(reply));
    }
}
