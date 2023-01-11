package gmail.sjtxm0320.guestbook.persistence;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import gmail.sjtxm0320.guestbook.domain.GuestBook;
import gmail.sjtxm0320.guestbook.domain.QGuestBook;

@SpringBootTest
class GuestBookRepositoryTest {
    @Autowired
    private GuestBookRepository guestBookRepository;

    // 데이터 삽입 메서드 테스트
    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            GuestBook guestBook = GuestBook.builder()
                .title("Title..." + i)
                .content("Content..." + i)
                .writer("user" + (i % 10))
                .build();

            System.out.println(guestBookRepository.save(guestBook));
        });
    }

    @Test
    public void updateDummies() {
        GuestBook guestBook = GuestBook.builder()
            .gno(1L)
            .title("Update Title")
            .content("Update Content")
            .writer("예나")
            .build();
        guestBookRepository.save(guestBook);
    }

    // title에 1이라는 글자가 포함된 Entity 조회
    @Test
    public void testQuery1() {
        // 10개씩 첫 번째 페이지의 데이터 조회
        // modDate의 내림차순 정렬
        Pageable pageable = PageRequest.of(0, 10, Sort.by("modDate").descending());

        // querydsl 수행
        QGuestBook qGuestBook = QGuestBook.guestBook;

        // title에 1이 포함된 조건 생성
        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expression = qGuestBook.title.contains(keyword);
        builder.and(expression);

        Page<GuestBook> result = guestBookRepository.findAll(builder, pageable);

        for (GuestBook guestBook : result.getContent()) {
            System.out.println(guestBook);
        }
    }

    // title 또는 content에 1이 포함된 데이터 조회
    @Test
    public void testQuery2() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("modDate").descending());

        // querydsl 수행을 위해 Q 클래스 가져오기
        QGuestBook qGuestBook = QGuestBook.guestBook;

        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();

        // title에 포함된 조건
        BooleanExpression exTitle = qGuestBook.title.contains(keyword);

        // content에 포함된 조건
        BooleanExpression exContent = qGuestBook.content.contains(keyword);

        // 2개의 조건을 or로 결합
        BooleanExpression exAll = exTitle.or(exContent);
        builder.and(exAll);
        // gno가 100보다 작은 조건 추가
        builder.and(qGuestBook.gno.lt(100L));

        Page<GuestBook> result = guestBookRepository.findAll(builder, pageable);

        for (GuestBook guestBook : result.getContent()) {
            System.out.println(guestBook);
        }
    }
}
