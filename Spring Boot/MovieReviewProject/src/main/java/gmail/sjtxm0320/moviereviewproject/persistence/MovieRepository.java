package gmail.sjtxm0320.moviereviewproject.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gmail.sjtxm0320.moviereviewproject.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m, mi, avg(coalesce(r.grade, 0)), count(distinct r.reviewNum) from Movie m left outer join MovieImage mi on mi.movie = m left outer join Review r on r.movie = m group by m")
    public Page<Object[]> getList(Pageable pageable);

    // 특정 영화 정보를 가지고 영화 이미지 정보, 리뷰 개수, grade의 평균을 구해주는 메서드
    @Query("select m, mi, r from Movie m "
        + "left outer join MovieImage mi on mi.movie = m "
        + "left outer join Review r on r.movie = m "
        + "where m.mno = :mno group by mi")
    List<Object[]> getMovieWithAll(@Param("mno") Long mno);
}
