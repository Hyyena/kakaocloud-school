package gmail.sjtxm0320;

import java.util.List;

// goods 테이블에 수행할 데이터베이스 작업의 원형을 소유할 인터페이스
public interface GoodDAO {
    // goods 테이블의 전체 데이터 가져오기
    List<Good> getAll();

    // goods 테이블에서 code를 가지고 데이터 조회하기
    Good getGood(String code);

    // goods 테이블에서 name이나 manufacture에 포함된 데이터 조회
    List<Good> likeGood(String content);

    // goods 테이블에 데이터 삽입
    // 수정은 모양이 동일
    // 삭제는 동일하게 만들어도 되고, 매개변수를 기본키로 만들어도 된다.
    int insertGood(Good good);
}
