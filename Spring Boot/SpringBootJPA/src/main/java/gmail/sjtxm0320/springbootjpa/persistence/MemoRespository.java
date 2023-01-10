package gmail.sjtxm0320.springbootjpa.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gmail.sjtxm0320.springbootjpa.domain.Memo;

public interface MemoRespository extends JpaRepository<Memo, Long> {
    // mno의 값이 from부터 to 사이인 데이터 조회
    List<Memo> findByMnoBetween(Long from, Long to);

    // mno의 값이 from부터 to 사이인 데이터를 Mno의 내림차순으로 정렬해서 조회하는 메서드
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    // 페이징을 적용해서 조회
    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    void deleteByMnoLessThan(Long num);

    // mno와 memoText를 매개변수로 받아서 수정하는 메서드(JPQL)
    @Transactional
    @Modifying
    // Native SQL이 아니기 때문에 Table 이름이 아닌 Entity 클래스 이름을 사용해야 한다.
    @Query("update Memo m set m.memoText = :memoText where m.mno = :mno")
    public int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText);

    @Transactional
    @Modifying
    @Query("update Memo m set m.memoText = :#{#param.memoText} where m.mno = :#{#param.mno}")
    public int updateMemoText(@Param("param") Memo memo);

    @Query("select m from Memo m where m.mno > :mno")
    Page<Memo> getListWithQuery(@Param("mno") Long mno, Pageable pageable);

    @Query("select m.mno, m.memoText, current_date from Memo m where m.mno > :mno")
    Page<Object[]> getObjectWithQuery(@Param("mno") Long mno, Pageable pageable);
}
