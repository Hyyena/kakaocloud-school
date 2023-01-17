package gmail.sjtxm0320.moviereviewproject.persistence;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import gmail.sjtxm0320.moviereviewproject.domain.Member;
import gmail.sjtxm0320.moviereviewproject.domain.Movie;
import gmail.sjtxm0320.moviereviewproject.domain.Review;
import jakarta.transaction.Transactional;

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

    @Test
    // @Transactional
    public void getReviews() {
        Movie movie = Movie.builder().mno(96L).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(review -> {
            System.out.println(review.getReviewNum());
            System.out.println(review.getMember().getEmail());
        });
    }

    @Test
    public void deleteByMember() {
        Member member = Member.builder().mid(8L).build();

        reviewRepository.deleteByMember(member);
    }

    @Test
    @Transactional
    @Commit
    public void updatebyMember() {
        reviewRepository.updateByMember(58L);
    }
}
