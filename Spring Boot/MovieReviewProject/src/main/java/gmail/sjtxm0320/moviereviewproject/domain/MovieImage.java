package gmail.sjtxm0320.moviereviewproject.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
// toString을 할 때, movie는 제외시킨다.
// 지연 생성이기 때문에 get을 하지 않은 상태에서 toString을 호출하면 NullPointerException이 발생한다.
@ToString(exclude = "movie")
// 부모 테이블을 만들 때 이 속성의 값을 포함시켜 생성
@Embeddable
public class MovieImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;

    // 파일 이름이 겹치지 않도록 하기 위해 추가
    private String uuid;
    // 파일 이름
    private String imgName;
    // 하나의 디렉토리에 너무 많은 파일이 저장되지 않도록 업로드 날짜별로 파일을 기록하기 위한 디렉토리 이름
    private String path;

    /*
     * ManyToOne: 하나의 Movie가 여러 개의 MovieImage를 소유
     * FetchType.LAZY: 데이터를 불러올 때 movie를 불러오지 않고, 사용할 때 불러온다.
     * 외래키의 이름은 movie_mno로 만들어진다.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
