package gmail.sjtxm0320.boardproject.persistence;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import gmail.sjtxm0320.boardproject.domain.Board;
import gmail.sjtxm0320.boardproject.domain.Member;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    // 게시글 데이터 삽입
    @Test
    public void insertBoard() {
        for (int i = 1; i <= 100; i++) {
            Member member = Member.builder().email("user" + i + "@gmail.com").build();

            Board board = Board.builder().title("Title..." + i).content("Content..." + i).author(member).build();

            boardRepository.save(board);
        }
    }

    // 게시글 1개를 가져오는 메서드
    @Test
    @Transactional
    public void readBoard() {
        Optional<Board> result = boardRepository.findById(100L);

        Board board = result.get();
        System.out.println(board);
        System.out.println(board.getAuthor());
    }

    // Board 데이터를 가져올 때 Author의 데이터도 가져오기
    @Test
    public void joinTest1() {
        Object result = boardRepository.getBoardWithAuthor(100L);

        // 결과가 배열
        System.out.println(result);

        Object[] arr = (Object[])result;
        System.out.println(Arrays.toString(arr));

        Board board = (Board)arr[0];
        Member member = (Member)arr[1];

        System.out.println(board);
        System.out.println(member);
    }

    @Test
    public void testJoin2() {
        List<Object[]> result = boardRepository.getBoardWithReply(100L);

        for (Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void testJoin3() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {
            Object[] arr = (Object[])row;
            System.out.println(Arrays.toString(arr));

            Board board = (Board)arr[0];
            Member member = (Member)arr[1];
            Long count = (Long)arr[2];

            System.out.println(board);
            System.out.println(member);
            System.out.println(count);
        });
    }
}
