package gmail.sjtxm0320.boardproject.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "author")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;
    private String title;
    private String content;

    // 처음에는 가져오지 않고, 사용할 때 가져온다.
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    // title을 수정하는 메서드
    public void changeTitle(String title) {
        if (title == null || title.trim().length() == 0) {
            this.title = "무제";

            return;
        }
        this.title = title;
    }

    // content를 수정하는 메서드
    public void changeContent(String content) {
        this.content = content;
    }
}
