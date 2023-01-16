package gmail.sjtxm0320.moviereviewproject.persistence;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gmail.sjtxm0320.moviereviewproject.domain.Member;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMember() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                .email("test" + i + "@gmail.com")
                .pw("1234")
                .nickname("reviewer" + i)
                .build();

            memberRepository.save(member);
        });
    }
}
