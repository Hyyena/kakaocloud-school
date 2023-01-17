package gmail.sjtxm0320.moviereviewproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gmail.sjtxm0320.moviereviewproject.domain.Member;
import gmail.sjtxm0320.moviereviewproject.domain.Movie;
import gmail.sjtxm0320.moviereviewproject.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    /*
     * Paging 기능
     * 테이블의 전체 데이터 가져오기
     * 기본키를 가지고 데이터 1개 가져오기
     * 데이터 삽입과 수정(기본키를 조건으로 하는)에 사용되는 메서드 제공
     * 기본키를 가지고 삭제하는 메서드와 Entity를 가지고 삭제
     */

    // 이름을 기반으로 하는 메서드 생성 가능(테이블 1개)
    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    // 회원 정보를 가지고 데이터를 삭제하는 메서드
    void deleteByMember(Member member);

    // JPQL을 이용한 쿼리 작성 가능(Join)
    @Modifying
    @Query("update Review r set r.member.mid = null where r.member.mid = :mid")
    void updateByMember(@Param("mid") Long mid);

    // Querydsl을 이용한 쿼리 작성 가능(동적 쿼리)
}
