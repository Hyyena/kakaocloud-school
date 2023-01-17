package gmail.sjtxm0320.moviereviewproject.persistence;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import gmail.sjtxm0320.moviereviewproject.domain.Movie;
import gmail.sjtxm0320.moviereviewproject.domain.MovieImage;

@SpringBootTest
class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieImageRepository movieImageRepository;

    @Test
    public void insertMovie() {
        // 영화 100개 생성 후 삽입
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Movie movie = Movie.builder().title("Movie" + i).build();

            movieRepository.save(movie);

            int count = (int)(Math.random() * 5) + 1;

            for (int j = 0; j < count; j++) {
                MovieImage movieImage = MovieImage.builder()
                    .uuid(UUID.randomUUID().toString())
                    .movie(movie)
                    .imgName("test" + j + ".jpg")
                    .build();

                movieImageRepository.save(movieImage);
            }
        });
    }

    // JOIN 연습
    @Test
    public void joinTest() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "mno"));

        Page<Object[]> result = movieRepository.getList(pageable);

        for (Object[] objects : result.getContent()) {
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public void detailTest() {
        List<Object[]> list = movieRepository.getMovieWithAll(3L);

        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
