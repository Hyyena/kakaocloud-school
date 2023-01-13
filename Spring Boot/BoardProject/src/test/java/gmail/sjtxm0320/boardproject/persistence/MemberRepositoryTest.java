package gmail.sjtxm0320.boardproject.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gmail.sjtxm0320.boardproject.domain.Member;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    // 회원 데이터 삽입
    @Test
    public void insertMember() {
        for (int i = 1; i <= 100; i++) {
            Member member = Member.builder().email("user" + i + "@gmail.com").password("1234").name("USER" + i).build();

            memberRepository.save(member);
        }
    }
}
