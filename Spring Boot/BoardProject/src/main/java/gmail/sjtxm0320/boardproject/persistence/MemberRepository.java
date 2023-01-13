package gmail.sjtxm0320.boardproject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import gmail.sjtxm0320.boardproject.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
