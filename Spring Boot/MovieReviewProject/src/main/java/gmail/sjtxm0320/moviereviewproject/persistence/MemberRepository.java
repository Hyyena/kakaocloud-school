package gmail.sjtxm0320.moviereviewproject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import gmail.sjtxm0320.moviereviewproject.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
