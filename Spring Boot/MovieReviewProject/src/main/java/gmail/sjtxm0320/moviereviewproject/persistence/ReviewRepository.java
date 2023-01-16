package gmail.sjtxm0320.moviereviewproject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import gmail.sjtxm0320.moviereviewproject.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
