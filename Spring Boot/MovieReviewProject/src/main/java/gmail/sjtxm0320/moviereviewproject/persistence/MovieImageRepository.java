package gmail.sjtxm0320.moviereviewproject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import gmail.sjtxm0320.moviereviewproject.domain.MovieImage;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
