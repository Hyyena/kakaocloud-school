package gmail.sjtxm0320.moviereviewproject.persistence;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gmail.sjtxm0320.moviereviewproject.domain.Member;
import gmail.sjtxm0320.moviereviewproject.domain.Movie;
import gmail.sjtxm0320.moviereviewproject.domain.Review;

@SpringBootTest
class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMovieReview() {
        IntStream.rangeClosed(1, 200).forEach(i -> {
            // 영화 번호
            Long mno = (long)(Math.random() * 100) + 1;
            // 회원 번호
            Long mid = (long)(Math.random() * 100) + 1;

            Movie movie = Movie.builder().mno(mno).build();
            Member member = Member.builder().mid(mid).build();
            Review review = Review.builder()
                .movie(movie)
                .member(member)
                .grade((int)(Math.random() * 5) + 1)
                .text("review" + i)
                .build();

            reviewRepository.save(review);
        });
    }

}
